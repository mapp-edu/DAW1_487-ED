# UP4 · Diseño y realización de pruebas

Probar no es «comprobar que funciona»: es **buscar errores de forma sistemática** y dejar pruebas automáticas que avisen cuando algo se rompa. En esta unidad diseñarás casos de prueba con técnicas de caja negra y de caja blanca, depurarás programas con el IDE, automatizarás pruebas con JUnit 6 y aislarás componentes con dobles de prueba.

| | |
|---|---|
| **Resultado de aprendizaje** | RA3 · Verifica el funcionamiento de programas diseñando y realizando pruebas |
| **Criterios** | a, b, c, d, e, f, g, h, i |
| **Duración** | 21 horas · semanas 12–18 · 2.ª evaluación |
| **Peso del RA** | 22 % de la nota del módulo |

## Objetivos

- Clasificar las pruebas por nivel, objetivo y técnica, y situarlas en un plan de pruebas.
- Diseñar casos de prueba con clases de equivalencia, valores límite y cobertura de caminos.
- Usar el depurador: puntos de ruptura (también condicionales), ejecución paso a paso, inspección y modificación de variables.
- Escribir pruebas unitarias automáticas con JUnit 6 y ejecutarlas con Maven y desde el IDE.
- Medir la cobertura de código e interpretarla.
- Usar dobles de prueba (*stubs* y *mocks*) con Mockito.
- Documentar incidencias de forma reproducible.

## Contenidos

1. [Fundamentos de las pruebas](01-fundamentos.md)
2. [Diseño de casos de prueba](02-diseno-casos-prueba.md)
3. [Depuración en el IDE](03-depuracion.md)
4. [Pruebas unitarias con JUnit](04-junit.md)
5. [Dobles de prueba](05-dobles-de-prueba.md)
6. [Documentar incidencias](06-incidencias.md)

## Secuencia

| Semana | Tutoría colectiva | Trabajo autónomo |
|:------:|-------------------|------------------|
| 12 | Por qué y cuándo probar. Tipos y niveles. Plan de pruebas. | Apartado 1 |
| 13 | Depurador en IntelliJ IDEA y VS Code (práctica guiada `LlenarNumeros`). | Apartado 3. **T4.1** |
| 14 | Caja negra: clases de equivalencia y valores límite. | Apartado 2 |
| 15 | Caja blanca: grafo de flujo, complejidad ciclomática y caminos. | Apartado 2. **T4.2** |
| 16 | Maven y JUnit 6: primer proyecto con pruebas (práctica guiada `Calculadora`). | Apartado 4 |
| 17 | Pruebas parametrizadas, excepciones y cobertura. Incidencias. | Apartados 4 y 6. **T4.3** |
| 18 | Dobles de prueba con Mockito. Introducción a TDD. | Apartado 5. **T4.4** |

## Tareas evaluables

| Tarea | CE | Peso en las tareas del RA3 |
|-------|:--:|:--------------------------:|
| [T4.1 · Depuración de un programa](tareas.md#t41) | c, d, e | 20 % |
| [T4.2 · Diseño de casos de prueba](tareas.md#t42) | a, b | 25 % |
| [T4.3 · Pruebas unitarias automáticas e incidencias](tareas.md#t43) | f, g, h | 35 % |
| [T4.4 · Aislar con dobles de prueba](tareas.md#t44) | i | 20 % |

## Recursos

- [Guía de usuario de JUnit 6](https://docs.junit.org/current/user-guide/)
- [Documentación de Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org.mockito/org/mockito/Mockito.html)
- [Maven en 5 minutos](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- Código de partida: [LlenarNumeros.java](../recursos/up4/LlenarNumeros.java) y [proyecto Maven de ejemplo](../recursos/up4/pom.xml)
