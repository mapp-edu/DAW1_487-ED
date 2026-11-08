# Tareas de la UP7

Calificación con la [escala común 0–4](../modulo/rubricas.md). Entrega en el repositorio `ed-up6-<usuario>` (carpeta `up7/`) con los `.puml` y las imágenes exportadas. En Aules, el enlace.

Las tres tareas trabajan sobre el mismo sistema, **gestión de calificaciones**, para que los diagramas sean coherentes entre sí y con un diagrama de clases.

---

## T7.1 · Casos de uso: gestión de calificaciones { #t71 }

**RA6 · CE a, b** · Peso: 30 % de las tareas del RA6 · Individual

*Adaptada de la práctica P04-Diagramas de comportamiento-casos de uso (Gestión calificaciones) del curso 2025-26.*

### Enunciado del sistema

??? abstract "Gestión de calificaciones (enunciado completo)"
    Se desea desarrollar una aplicación de gestión de las calificaciones de los alumnos para atender las quejas de los profesores, que trabajan con lápiz y papel.

    El profesor recibe en formato electrónico las actas en blanco de las asignaturas de las que es responsable. El acta contiene los datos de la asignatura (titulación, campus, curso académico, denominación, convocatoria y grupo) y la lista de alumnos matriculados (NIU, NIF, nombre y apellidos). El profesor puede:

    - completar un acta con las notas de los alumnos;
    - añadir o borrar un alumno de un acta;
    - integrar las actas de varios grupos de una misma asignatura en una sola.

    Además, la aplicación debe:

    - permitir consultar de cualquier alumno el DNI, el número de expediente y la lista de asignaturas en las que está matriculado;
    - obtener una estadística de las calificaciones de un grupo: para cada calificación, número de personas, porcentaje sobre los presentados y porcentaje sobre el total;
    - consultar el porcentaje de presentados y de no presentados;
    - mostrar un gráfico con el número de personas por intervalo de nota y la media de la clase;
    - ofrecer una calculadora (suma, resta, multiplicación, división) que se activa al introducir una nota y vuelca el resultado, redondeado a dos decimales, en la casilla de la nota;
    - importar y exportar la lista de alumnos con sus calificaciones a un formato compatible con hojas de cálculo;
    - imprimir las actas y la lista provisional de calificaciones.

    Como ampliación, solo para quien se identifique como **administrador**:

    - altas, bajas, modificaciones y consultas de alumnos y de su matriculación en una asignatura y grupo;
    - gestión de asignaturas, titulaciones y grupos;
    - consultar los alumnos que no se pueden matricular y el motivo;
    - consultar el historial académico de un alumno.

### Enunciado de la tarea

1. **(CE a)** Tabla con los tipos de diagramas de comportamiento: para cada uno, qué muestra y **qué parte de este sistema** modelarías con él.
2. **(CE b)** Diagrama de casos de uso completo en PlantUML: actores (con generalización si procede), límite del sistema, casos de uso y relaciones `include` y `extend` donde aporten.
3. **(CE b)** Especificación completa (con escenarios principal y alternativos) de **dos** casos de uso: *Introducir nota* (con la calculadora como extensión) e *Integrar actas de varios grupos*.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE a** · Tipos de diagramas | Tabla correcta con todos los tipos estudiados. | Cada diagrama se aplica a una parte concreta del sistema, de forma razonada. | Se relacionan los diagramas entre sí (coherencia del modelo). |
| **CE b** · Casos de uso | Diagrama con todos los actores y funcionalidades; especificaciones completas. | El uso de `include`, `extend` y la generalización se justifica. | Granularidad adecuada, nombres consistentes y escenarios alternativos completos. |

---

## T7.2 · Interacción: secuencia y comunicación { #t72 }

**RA6 · CE c, d** · Peso: 35 % de las tareas del RA6 · Individual

### Enunciado

1. **Interpretar (CE c).** Con el [diagrama de secuencia del restaurante](03-interaccion.md#ejemplo-calcular-la-cuenta-de-una-mesa), responde: ¿qué objetos participan y cuáles crean los otros? ¿Qué operaciones debe tener cada clase? ¿Qué ocurre si no hay propina? Escribe en Java el método `total()` de `Pedido` y el de `calcularCuenta()` de `Restaurante` a partir del diagrama.
2. **Elaborar (CE d).** Para el caso de uso *Introducir nota* de la T7.1, dibuja el **diagrama de secuencia** del escenario principal y del alternativo «nota no válida» (usa un fragmento `alt`), con los objetos `:InterfazActa`, `:Acta`, `:LineaActa` y `:Alumno`.
3. **Elaborar (CE d).** Dibuja el **diagrama de comunicación** equivalente al del punto 2 (escenario principal) y compara las dos vistas.
4. Comprueba la coherencia: haz un diagrama de clases mínimo con las operaciones que aparecen en tus mensajes.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE c** · Interpretación | Respuestas correctas y código Java coherente con el diagrama. | Se explica cada elemento de la notación (activación, retorno, `loop`, `opt`). | Se detectan mejoras del diseño a partir del diagrama. |
| **CE d** · Elaboración | Diagramas de secuencia (con `alt`) y de comunicación correctos. | Las decisiones (qué objeto recibe cada mensaje) se razonan. | Total coherencia con el diagrama de clases y comparación crítica de las dos vistas. |

---

## T7.3 · Actividad y estados { #t73 }

**RA6 · CE e, f, g, h** · Peso: 35 % de las tareas del RA6 · Individual

### Enunciado

1. **Interpretar una actividad (CE e).** Con el [diagrama de actividad del restaurante](04-actividad.md#ejemplo-atender-una-mesa-en-el-restaurante): ¿quién realiza cada acción? ¿Qué acciones pueden ocurrir en paralelo? ¿Qué pasa si no hay mesas libres? ¿Dónde está el bucle?
2. **Elaborar una actividad (CE f).** Diagrama de actividad, **con calles**, del proceso «Cerrar la evaluación»: el profesor completa las actas; si faltan notas, el sistema avisa; **en paralelo**, el sistema genera las estadísticas y el PDF del acta; secretaría revisa el acta y la valida o la devuelve con observaciones.
3. **Interpretar estados (CE g).** Con el [diagrama de estados de la mesa](05-estados.md#ejemplo-la-mesa-del-restaurante): ¿qué eventos son válidos en el estado `Reservada`? ¿Qué significa `after(20 min)`? ¿Qué ocurre si llega el evento `cobrar` estando `Libre`? Diseña **cuatro casos de prueba** a partir del diagrama.
4. **Plantear estados (CE h).** Diagrama de estados del **Acta**: en blanco, en edición, completa, firmada, validada por secretaría, devuelta con observaciones, cerrada. Incluye al menos una guarda, una acción y una actividad `entry`.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE e** · Interpretar actividad | Respuestas correctas. | Se explican los elementos (calles, *fork/join*, decisión y fusión). | Se proponen mejoras del proceso. |
| **CE f** · Elaborar actividad | Diagrama correcto con calles, decisión y paralelismo. | Se justifican las decisiones de modelado. | Diagrama claro y coherente con los casos de uso de la T7.1. |
| **CE g** · Interpretar estados | Respuestas correctas y cuatro casos de prueba. | Los casos de prueba cubren transiciones válidas y eventos no permitidos. | Se relacionan con pruebas de JUnit (UP4). |
| **CE h** · Plantear estados | Diagrama del Acta con todos los estados, guarda, acción y `entry`. | Las transiciones y guardas se razonan. | Coherente con la clase `Acta` y con su implementación en Java mediante enumeración. |
