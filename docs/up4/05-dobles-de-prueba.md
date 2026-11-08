# 5. Dobles de prueba

Una prueba **unitaria** debe probar **una unidad aislada**. Pero las clases reales dependen de otras: una base de datos, un servicio web, el reloj del sistema, el envío de correos… Si la prueba usa esas dependencias reales, será lenta, frágil y no repetible.

Un **doble de prueba** (*test double*, término de Gerard Meszaros, por analogía con los dobles de cine) es un objeto que **sustituye a una dependencia real** durante la prueba.

## Tipos

| Tipo | Qué hace | Cuándo se usa |
|------|----------|---------------|
| ***Dummy*** | Se pasa como parámetro pero nunca se usa | Para rellenar una firma |
| ***Stub*** | Devuelve **respuestas predefinidas** | Para controlar las **entradas indirectas** de la unidad (el dato que devuelve un repositorio) |
| ***Fake*** | Implementación funcional simplificada | Una base de datos en memoria, un repositorio con un `HashMap` |
| ***Spy*** | Objeto real (o *stub*) que además **registra** cómo se le llama | Para comprobar llamadas sin perder el comportamiento real |
| ***Mock*** | Objeto programado con **expectativas** sobre las llamadas que debe recibir | Para verificar las **salidas indirectas** (que se envió un correo, que se guardó un registro) |

**Stub** = verificación de **estado** (miro el resultado). **Mock** = verificación de **comportamiento** (miro qué llamadas se hicieron).

## Ejemplo sin bibliotecas: un *fake* y un *stub* a mano

```java
public interface RepositorioNotas {
    List<Double> notasDe(String alumno);
}

public class ServicioBoletin {
    private final RepositorioNotas repo;
    public ServicioBoletin(RepositorioNotas repo) { this.repo = repo; }  // inyección de dependencias

    public double media(String alumno) {
        List<Double> notas = repo.notasDe(alumno);
        if (notas.isEmpty()) throw new IllegalStateException("Sin notas");
        return notas.stream().mapToDouble(Double::doubleValue).average().orElseThrow();
    }
}
```

```java
@Test
void mediaConStubManual() {
    RepositorioNotas stub = alumno -> List.of(4.0, 6.0, 8.0);   // stub con una lambda
    ServicioBoletin servicio = new ServicioBoletin(stub);
    assertEquals(6.0, servicio.media("ana"), 1e-9);
}
```

La clave es el **diseño**: como `ServicioBoletin` recibe su dependencia por el constructor (inyección de dependencias) y depende de una **interfaz**, sustituirla en la prueba es trivial.

## Con Mockito

**Mockito** crea dobles automáticamente. Dependencias de prueba (además de JUnit):

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.23.0</version>
    <scope>test</scope>
</dependency>
```

```java
@ExtendWith(MockitoExtension.class)
class ServicioBoletinTest {

    @Mock RepositorioNotas repo;            // doble creado por Mockito
    @Mock Notificador notificador;
    @InjectMocks ServicioBoletin servicio;  // la unidad bajo prueba, con los dobles inyectados

    @Test
    void mediaUsaLasNotasDelRepositorio() {
        when(repo.notasDe("ana")).thenReturn(List.of(4.0, 6.0, 8.0));   // stubbing

        assertEquals(6.0, servicio.media("ana"), 1e-9);                 // estado
        verify(repo).notasDe("ana");                                    // comportamiento
    }

    @Test
    void sinNotasLanzaExcepcionYNoNotifica() {
        when(repo.notasDe("luis")).thenReturn(List.of());

        assertThrows(IllegalStateException.class, () -> servicio.media("luis"));
        verifyNoInteractions(notificador);
    }

    @Test
    void siElRepositorioFallaSePropagaLaExcepcion() {
        when(repo.notasDe(anyString())).thenThrow(new RuntimeException("BD caída"));
        assertThrows(RuntimeException.class, () -> servicio.media("ana"));
    }
}
```

| API de Mockito | Uso |
|----------------|-----|
| `when(x.metodo(args)).thenReturn(v)` | Respuesta predefinida (*stub*) |
| `thenThrow(ex)` | Simular un error de la dependencia |
| `verify(x).metodo(args)` | Comprobar que se llamó |
| `verify(x, times(2))`, `never()`, `atLeastOnce()` | Número de llamadas |
| `verifyNoInteractions(x)` | Que no se usó |
| `any()`, `anyString()`, `eq(v)` | Comparadores de argumentos |
| `ArgumentCaptor<T>` | Capturar el argumento recibido para inspeccionarlo |
| `spy(objetoReal)` | Espía sobre un objeto real |

!!! warning "Mockito con Java 21 o superior"
    Al ejecutar las pruebas puede aparecer un aviso porque Mockito carga un agente Java dinámicamente. No impide que las pruebas funcionen. La configuración para eliminarlo está en el [pom.xml de ejemplo](../recursos/up4/pom.xml) (agente declarado en `maven-surefire-plugin`).

## Buenas prácticas

- **No simules lo que no es tuyo** de forma indiscriminada: es mejor envolver una API externa en una interfaz propia y simular esa interfaz.
- **No abuses de los *mocks*.** Si una prueba necesita diez, probablemente la clase tiene demasiadas responsabilidades (una pista para refactorizar en la UP5).
- Prefiere **verificar el estado** y verifica el comportamiento solo cuando la llamada **es** el resultado esperado (enviar un correo, registrar un evento).
