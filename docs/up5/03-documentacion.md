# 3. Documentación del código

Un software sin documentar es más difícil de usar, mantener y ampliar. Pero documentación **inservible u obsoleta** es casi peor que ninguna. La clave es documentar **lo necesario**, **cerca del código** y de forma que se **mantenga actualizado**.

## Tipos de documentación

| Tipo | Destinatario | Ejemplos |
|------|--------------|----------|
| **De requisitos y diseño** | Equipo y cliente | ERS, historias de usuario, diagramas UML (UP6 y UP7) |
| **Técnica / de código** | Desarrolladores | Comentarios, **Javadoc**, README, guía de contribución, ADR |
| **De pruebas** | QA y desarrolladores | Plan de pruebas, informes, incidencias (UP4) |
| **De usuario** | Usuarios finales | Manual de usuario, ayuda en línea, preguntas frecuentes |
| **De explotación** | Administradores de sistemas | Manual de instalación y despliegue, configuración |

### Escribir documentación de calidad

1. Piensa en **quién** la va a leer y para qué.
2. Haz un esquema antes de escribir y ordena por importancia.
3. Usa los **estándares y herramientas** del lenguaje (en Java, Javadoc).
4. Escribe con claridad: frases cortas, ejemplos y terminología consistente.
5. **Versiónala con el código** para que evolucione con él.

## Comentarios en el código

El mejor comentario es un código que no lo necesita: nombres claros y métodos pequeños. Comenta el **porqué**, no el **qué**.

=== "Comentarios que sobran"

    ```java
    // Incrementa i en 1
    i++;

    // Comprueba si la media es mayor o igual que 5
    if (media >= 5) { ... }
    ```

=== "Comentarios útiles"

    ```java
    // La normativa de evaluación redondea hacia abajo las notas de evaluación
    // y hacia el entero más próximo la nota final (ver evaluacion.md).
    int notaEvaluacion = (int) Math.floor(media);

    // TODO(#42): sustituir por la API de calendario del centro cuando esté disponible
    ```

## Javadoc

**Javadoc** es la herramienta del JDK que genera documentación HTML de la API a partir de comentarios especiales `/** … */` situados antes de clases, interfaces, constructores, métodos y atributos públicos.

```java
/**
 * Representa a un empleado de la empresa y su retribución.
 *
 * <p>El salario se expresa en euros brutos anuales.</p>
 *
 * @author Nombre Apellido
 * @version 1.2
 * @since 1.0
 * @see Directivo
 */
public class Empleado {

    /**
     * Aplica un complemento salarial si el empleado tiene más de 40 años
     * y su nombre no está vacío.
     *
     * @param complemento importe en euros que se suma al salario; debe ser positivo
     * @return {@code true} si se ha aplicado el complemento, {@code false} en caso contrario
     * @throws IllegalArgumentException si {@code complemento} es negativo
     */
    public boolean aplicarComplemento(double complemento) { ... }
}
```

| Etiqueta | Dónde | Significado |
|----------|-------|-------------|
| `@author` | Clase | Autoría |
| `@version` | Clase | Versión |
| `@since` | Clase y miembros | Versión en que apareció |
| `@param nombre descr.` | Métodos y constructores | Un parámetro (una etiqueta por parámetro) |
| `@return descr.` | Métodos no `void` | Valor devuelto |
| `@throws Tipo descr.` | Métodos y constructores | Excepción que puede lanzar |
| `@see referencia` | Cualquiera | Ver también |
| `@deprecated descr.` | Cualquiera | Obsoleto (acompaña a la anotación `@Deprecated`) |
| `{@code …}` / `{@link Clase#metodo}` | En el texto | Código en línea / enlace |

!!! note "Javadoc en Markdown (Java 23 o superior)"
    Desde Java 23 los comentarios de documentación también pueden escribirse en **Markdown** con `///` al inicio de cada línea (JEP 467), en lugar de HTML dentro de `/** */`. Las etiquetas `@param`, `@return`, etc. funcionan igual.

    ```java
    /// Calcula la **media aritmética** de las notas.
    ///
    /// @param notas lista no vacía de notas entre 0 y 10
    /// @return la media
    public static double media(List<Double> notas) { ... }
    ```

### Generar la documentación

```bash
javadoc -d doc -author -version src/*.java          # con el JDK
mvn javadoc:javadoc                                 # con Maven → target/reports/apidocs
```

- **IntelliJ IDEA**: *Tools → Generate JavaDoc…*. Escribe `/**` + ++enter++ sobre un método para generar el esqueleto con sus etiquetas. La inspección *Javadoc declaration problems* avisa de los parámetros sin documentar.
- **VS Code**: la extensión de Java genera el esqueleto al escribir `/**`; la documentación se genera con la tarea de Maven o con el comando `javadoc` en una tarea.

## Alternativas: documentación como código

Además de la API, un proyecto necesita guías, decisiones de diseño y manuales. Hoy se escriben en **Markdown**, se versionan en el mismo repositorio y se publican automáticamente:

- **README.md**: la portada del repositorio (qué es, cómo se instala, cómo se usa, cómo se contribuye).
- **Generadores de sitios estáticos**: **Zensical** (el que genera este sitio), Docusaurus, Hugo. Convierten una carpeta de Markdown en una web navegable con buscador.
- **Pandoc**: convierte Markdown a PDF, DOCX, HTML… (con LaTeX y plantillas como Eisvogel para obtener PDF con formato profesional).
- **Diagramas como código**: Mermaid y PlantUML, que se versionan como texto.
- **ADR** (*Architecture Decision Records*): pequeños documentos que registran por qué se tomó una decisión técnica.

### Un sitio de documentación con Zensical en 5 minutos

```bash
pip install zensical          # requiere Python 3
zensical new .                # crea zensical.toml, docs/index.md y el workflow de publicación
zensical serve                # vista previa en http://localhost:8000 con recarga automática
zensical build                # genera el sitio estático en site/
```

```text
mi-proyecto/
├── zensical.toml           # configuración: nombre, navegación, tema
├── docs/
│   ├── index.md            # portada
│   ├── instalacion.md
│   └── uso.md
└── .github/workflows/docs.yml   # publica en GitHub Pages en cada push (apartado 4)
```

La navegación se declara en `zensical.toml`:

```toml
[project]
site_name = "Gestor de notas"
nav = [
  { "Inicio" = "index.md" },
  { "Instalación" = "instalacion.md" },
  { "Uso" = "uso.md" },
]
```

!!! info "MkDocs y Zensical"
    En el curso 2025-26 se usaba MkDocs con el tema *Material for MkDocs*. Su equipo de desarrollo lo ha dejado en mantenimiento y ahora desarrolla **Zensical**, que puede leer los ficheros `mkdocs.yml` existentes. Para proyectos nuevos se recomienda Zensical.
