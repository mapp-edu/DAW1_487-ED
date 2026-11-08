# UP5 · Refactorización, documentación e integración continua

Un código que funciona no es suficiente: tiene que poder **leerse, mantenerse y evolucionar**. En esta unidad mejorarás código existente con refactorizaciones seguras (protegidas por las pruebas de la UP4), revisarás su calidad con analizadores estáticos, lo documentarás y automatizarás todo el proceso con integración continua en GitHub Actions.

| | |
|---|---|
| **Resultado de aprendizaje** | RA4 · Optimiza código empleando las herramientas disponibles en el entorno de desarrollo |
| **Criterios** | a, b, c, d, e, g, i |
| **Duración** | 15 horas · semanas 19–23 · 2.ª evaluación |
| **Peso** | La UP5 aporta el 50 % de la nota del RA4 (31 % del módulo) |

## Objetivos

- Reconocer «malos olores» del código y los patrones de refactorización que los corrigen.
- Refactorizar con las herramientas del IDE, protegiendo el comportamiento con pruebas.
- Analizar el código con analizadores estáticos y configurar sus reglas.
- Documentar clases con Javadoc y redactar documentación técnica en Markdown.
- Construir un *pipeline* de integración continua que compile, pruebe, analice y publique la documentación.

## Contenidos

1. [Refactorización](01-refactorizacion.md)
2. [Analizadores de código](02-analizadores.md)
3. [Documentación del código](03-documentacion.md)
4. [Integración continua](04-integracion-continua.md)

## Secuencia

| Semana | Tutoría colectiva | Trabajo autónomo |
|:------:|-------------------|------------------|
| 19 | Malos olores y catálogo de refactorizaciones. Refactorizar `NotasNoEstructurado` en directo con el IDE. | Apartado 1. **T5.1** |
| 20 | Pruebas de caracterización y refactorización segura. | **T5.1** |
| 21 | Analizadores: SonarQube for IDE, inspecciones de IntelliJ y Checkstyle. Configurar reglas. | Apartado 2. **T5.2** |
| 22 | Javadoc, Markdown y documentación como código con Zensical. | Apartado 3. **T5.3** |
| 23 | GitHub Actions: *pipeline* de CI y publicación en GitHub Pages. **Prueba presencial de la 2.ª evaluación.** | Apartado 4. **T5.4** |

## Tareas evaluables

| Tarea | CE | Peso en las tareas del RA4 |
|-------|:--:|:--------------------------:|
| [T5.1 · Refactorización guiada por pruebas](tareas.md#t51) | a, b, e | 15 % |
| [T5.2 · Revisión con un analizador de código](tareas.md#t52) | c, d | 10 % |
| [T5.3 · Documentación del proyecto](tareas.md#t53) | g | 10 % |
| [T5.4 · *Pipeline* de integración continua](tareas.md#t54) | i | 15 % |

## Recursos

- [Catálogo de refactorizaciones de Martin Fowler](https://refactoring.com/catalog/)
- [Refactoring.Guru (en español)](https://refactoring.guru/es/refactoring)
- [How to Write Doc Comments for the Javadoc Tool](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
- [Documentación de GitHub Actions](https://docs.github.com/es/actions)
- [Documentación de Zensical](https://zensical.org/docs/)
