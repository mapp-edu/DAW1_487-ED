# Tareas de la UP4

Calificación con la [escala común 0–4](../modulo/rubricas.md). Las tareas T4.3 y T4.4 se entregan como **repositorio de GitHub** (enlace en Aules) y las T4.1 y T4.2 como PDF en Aules.

---

## T4.1 · Depuración de un programa { #t41 }

**RA3 · CE c, d, e** · Peso: 20 % de las tareas del RA3 · Individual

*Adaptada de la práctica «Debugger con VS Code» del curso 2025-26.*

### Enunciado

1. **Herramientas (CE c).** Elabora una tabla con las herramientas de depuración y de prueba de **IntelliJ IDEA** y **VS Code** (puntos de ruptura y sus tipos, ejecución paso a paso, *watches*, evaluación de expresiones, ejecución de pruebas, cobertura), con su atajo y una captura de dónde están.
2. **Puntos de ruptura y seguimiento (CE d).** Haz la [práctica guiada `LlenarNumeros`](03-depuracion.md#practica-guiada-llenarnumeros), pasos 1 a 5, en **uno** de los dos IDE. Documenta cada paso con una captura que muestre las variables y la pila de llamadas.
3. **Modificar el comportamiento (CE e).** El programa [`EstadisticasNotas.java`](../recursos/up4/EstadisticasNotas.java) compila y se ejecuta, pero tiene **tres errores lógicos** (la salida esperada está en su comentario inicial). Localízalos con el depurador, sin añadir `println`. Para cada uno, indica qué punto de ruptura usaste, qué observaste, qué valor modificaste en tiempo de ejecución para confirmar la hipótesis y cómo lo corregiste.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE c** · Herramientas | Tabla completa para ambos IDE. | Se explica cuándo conviene cada herramienta. | Se comparan las diferencias entre los dos IDE con criterio. |
| **CE d** · Puntos de ruptura y seguimiento | Pasos 1 a 5 hechos y documentados, incluido el punto de ruptura condicional. | Se interpreta lo que muestran las variables y la pila en cada paso. | Uso de *logpoints* o de puntos de ruptura de excepción como ampliación. |
| **CE e** · Examinar y modificar | Los tres errores, localizados y corregidos. | Para cada error se razona la hipótesis y se confirma modificando valores en tiempo de ejecución. | Cada corrección deja además una prueba que la protege (anticipo de la T4.3). |

---

## T4.2 · Diseño de casos de prueba { #t42 }

**RA3 · CE a, b** · Peso: 25 % de las tareas del RA3 · Individual

*Adaptada de la práctica P04-JUnit (actividades 1 a 4) del curso 2025-26.*

### Enunciado

Trabajarás con dos métodos:

- **`obtenerSubcadena(cadena, pos, p)`**, en la versión modificada que sustituye `a` y `e` por `*` y elimina las `z` (ver [Diseño de casos de prueba](02-diseno-casos-prueba.md#grafo-de-flujo-y-complejidad-ciclomatica)).
- **`calcularPrecio(double base, int edad, boolean esSocio)`**, según esta especificación: la base debe ser > 0 (si no, `IllegalArgumentException`); hay un 50 % de descuento para menores de 12 años y mayores de 65; un 20 % para socios de 12 a 65 años; los descuentos no se acumulan (se aplica el mayor); la edad debe estar entre 0 y 120.

Para cada método:

1. **Tipos de prueba (CE a).** ¿Qué niveles y tipos de prueba aplicarías a cada método y a una aplicación que los use? ¿Qué pruebas serían de caja negra y cuáles de caja blanca, y por qué?
2. **Caja negra (CE b).** Clases de equivalencia (válidas y no válidas), valores límite y, para `calcularPrecio`, una tabla de decisión.
3. **Caja blanca (CE b).** Grafo de flujo, complejidad ciclomática calculada de dos formas y caminos independientes.
4. **Tabla de casos de prueba**: ID, técnica de origen, entrada, resultado esperado.
5. Señala los casos que **revelan defectos o huecos en la especificación** y propone cómo resolverlos.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE a** · Tipos de prueba | Clasificación correcta de niveles, tipos y técnicas. | Se razona por qué cada tipo es adecuado para este caso. | Propone un mini plan de pruebas con alcance y criterios de salida. |
| **CE b** · Caja negra | Clases, límites y tabla de decisión correctos y completos. | Se explica el criterio de partición y por qué cada clase no válida tiene su propio caso. | Detecta ambigüedades de la especificación y propone cómo aclararlas. |
| **CE b** · Caja blanca | Grafo, V(G) y caminos correctos. | V(G) calculada de dos formas y casos que cubren todos los caminos. | Relaciona la cobertura de caminos con la de condiciones y justifica los casos añadidos. |

---

## T4.3 · Pruebas unitarias automáticas e incidencias { #t43 }

**RA3 · CE f, g, h** · Peso: 35 % de las tareas del RA3 · Individual · Repositorio `ed-up4-t43-<usuario>`

### Enunciado

1. Crea un **proyecto Maven** a partir del [pom.xml de ejemplo](../recursos/up4/pom.xml).
2. Implementa `obtenerSubcadena` y `calcularPrecio` (en una clase `Utilidades`) y una clase `Notas` con `calificar(double)` y `media(List<Double>)`.
3. Implementa **como pruebas de JUnit 6 todos los casos diseñados en la T4.2** (CE f). Usa al menos:
    - una prueba **parametrizada** con `@CsvSource` para los valores límite;
    - `assertThrows` para las entradas no válidas;
    - `@BeforeEach` y `@DisplayName`;
    - `@Nested` para agrupar las pruebas de cada método.
4. Ejecuta las pruebas con `mvn verify` y desde el IDE. Consigue al menos un **90 % de cobertura de ramas** con JaCoCo (CE g). Adjunta el informe.
5. Las pruebas **deben encontrar defectos**: sustituye tu clase por [esta versión de `Notas`](../recursos/up4/defectos/Notas.java), que tiene 2 defectos introducidos, y ejecuta tus pruebas. Para cada defecto, crea una ***issue* de GitHub** siguiendo la plantilla de [incidencias](06-incidencias.md), corrígelo en una rama y ciérralo con un PR que la referencie (CE h).
6. README con instrucciones de ejecución, tabla de resultados y enlace a las *issues*.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE f** · Pruebas unitarias | Todos los casos de la T4.2 implementados, con todos los elementos pedidos. | Nombres descriptivos, patrón AAA, una idea por prueba y explicación de qué cubre cada grupo. | Pruebas legibles como especificación: alguien podría deducir los requisitos leyéndolas. |
| **CE g** · Automatización | `mvn verify` pasa y la cobertura de ramas es ≥ 90 %. | Se interpreta el informe de cobertura y se justifican las ramas no cubiertas. | Las pruebas se ejecutan en GitHub Actions (anticipo de la UP5). |
| **CE h** · Incidencias | Dos *issues* completas, corregidas mediante PR que las cierran. | Cada incidencia indica severidad y prioridad razonadas e incluye la prueba que la reproduce. | Plantilla de *issue* en el repositorio y ciclo de vida completo y trazable. |

---

## T4.4 · Aislar con dobles de prueba { #t44 }

**RA3 · CE i** · Peso: 20 % de las tareas del RA3 · Individual · En el mismo repositorio que la T4.3

### Enunciado

Añade al proyecto un `ServicioBoletin` que:

- obtiene las notas de un alumno de un `RepositorioNotas` (interfaz);
- calcula la media y la calificación con `Notas`;
- si la media es inferior a 5, llama a `Notificador.avisarTutor(alumno, media)` (interfaz);
- si el repositorio lanza una excepción, la envuelve en una `BoletinException`.

No implementes las interfaces reales. Prueba `ServicioBoletin`:

1. Con un **stub** o **fake** escrito a mano (sin bibliotecas) para al menos un caso.
2. Con **Mockito**: *stubbing* de respuestas, simulación de una excepción, verificación de que se llama (o no) a `avisarTutor` con los argumentos correctos (usa `ArgumentCaptor` en al menos un caso).
3. Explica en el README qué tipo de doble es cada uno que has usado (*dummy*, *stub*, *fake*, *spy* o *mock*) y por qué.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE i** · Dobles a mano | Al menos un *stub* o *fake* manual funcionando. | Se explica por qué permite aislar la unidad (inyección de dependencias). | Comparación razonada entre el doble manual y el de Mockito. |
| **CE i** · Mockito | *Stubbing*, excepción, `verify` y `ArgumentCaptor` usados correctamente. | Cada doble está clasificado y su uso justificado (estado o comportamiento). | Pruebas mínimas y precisas, sin *mocks* innecesarios. |
