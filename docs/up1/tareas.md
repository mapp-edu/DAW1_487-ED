# Tareas de la UP1

Todas las tareas se califican con la [escala común 0–4](../modulo/rubricas.md). Entrega cada tarea en Aules como un único PDF llamado `UP1-T1x-Apellido-Nombre.pdf`.

---

## T1.1 · Del código fuente a la ejecución { #t11 }

**RA1 · CE a, c, d** · Peso: 30 % de las tareas del RA1 · Individual

### Enunciado

Trabaja con [`NotasEstructurado.java`](../recursos/up1/NotasEstructurado.java).

1. **Compila y ejecuta desde la terminal**, sin IDE: `javac`, `java`. Haz una captura de cada paso y explica qué fichero genera cada comando.
2. **Muestra el *bytecode*** con `javap -c NotasEstructurado` e identifica la instrucción que corresponde a la división de `calcularMedia`.
3. **Compara con un lenguaje compilado a nativo.** Escribe el mismo programa en C (te damos el esqueleto en clase), compílalo en dos pasos (`gcc -c` y `gcc`) y señala cuál es el código objeto y cuál el ejecutable.
4. **Portabilidad.** Copia el `.class` y el ejecutable de C a otro sistema operativo (o a una máquina virtual) y explica qué ocurre en cada caso y por qué.
5. **Relación con el hardware.** Explica qué hacen la memoria, el procesador y los periféricos durante la ejecución de `NotasEstructurado`, desde que se lanza el comando hasta que se muestra el resultado.

### Entregables

PDF con las capturas, las respuestas razonadas y un esquema propio del proceso fuente → objeto o *bytecode* → ejecución.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE c** · Fuente, objeto y ejecutable | Compila y ejecuta en Java y en C, e identifica correctamente cada tipo de código. | Explica qué hace cada herramienta (compilador, enlazador) y por qué el objeto aún no se puede ejecutar. | Esquema propio, claro y correcto, del proceso completo en ambos lenguajes. |
| **CE d** · Código intermedio y máquina virtual | Muestra el *bytecode* y localiza la instrucción pedida. | Argumenta la portabilidad con el experimento y menciona el papel del JIT. | Relaciona la máquina virtual con otros casos (.NET, Python, WebAssembly) con ejemplos correctos. |
| **CE a** · Programa y componentes | Describe el papel de la memoria, la CPU y los periféricos. | Relaciona elementos concretos del código (variables, llamadas, E/S) con cada componente. | La explicación sigue el ciclo completo de ejecución con precisión terminológica. |

---

## T1.2 · Ficha comparativa de lenguajes { #t12 }

**RA1 · CE e** · Peso: 30 % de las tareas del RA1 · Individual

*Adaptado del ejercicio 3 de la presentación de la U01 del curso 2025-26.*

### Enunciado

1. Elabora una **tabla comparativa** con Java, Python, JavaScript, C, PHP y **tres lenguajes más** que elijas (por ejemplo, Kotlin, Rust, Go, C#, TypeScript o Swift). Para cada uno indica: año y origen, nivel, forma de ejecución, tipado (estático o dinámico, fuerte o débil), paradigmas y usos principales.
2. Consulta la **edición más reciente** de un ranking de popularidad (TIOBE, IEEE Spectrum o Stack Overflow) y analiza los cinco primeros puestos: indica la fecha y la fuente.
3. **Caso práctico.** Una pyme quiere: (a) una web de reservas, (b) un *script* que procese cada noche ficheros CSV y (c) el *firmware* de un sensor de temperatura. Recomienda un lenguaje para cada parte y justifica la elección.
4. Razona las **ventajas e inconvenientes** de compilar, interpretar o usar una máquina virtual.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE e** · Clasificación (tabla) | Los 8 lenguajes, con todas las columnas y sin errores importantes. | Cada clasificación dudosa (por ejemplo, Python «interpretado») se matiza correctamente. | Fuentes citadas y tabla clara y homogénea. |
| **CE e** · Análisis del ranking | Cinco primeros puestos, con fecha y fuente. | Explica las causas de las tendencias que observa. | Contrasta al menos dos rankings y comenta sus diferencias de método. |
| **CE e** · Caso práctico | Un lenguaje adecuado para cada parte. | Cada elección se argumenta con características del lenguaje. | Valora alternativas y riesgos (rendimiento, mantenimiento, talento disponible). |

---

## T1.3 · Plan de desarrollo de un proyecto { #t13 }

**RA1 · CE b, f, g** · Peso: 40 % de las tareas del RA1 · En parejas

*Adaptado de la práctica P01-Desarrollo de aplicaciones del curso 2025-26.*

### Contexto

Sois el departamento de informática de una academia de formación que quiere sustituir su aplicación de gestión de notas (hojas de cálculo compartidas) por una **aplicación web**. La dirección os pide un plan.

### Enunciado

1. **Fases y documentación.** Describid cada fase del desarrollo para este proyecto: qué se hará, quién lo hará y qué documentos se generarán (ERS, diseño, plan de pruebas, manual de usuario…). Incluid la migración de los datos actuales.
2. **Ciclo de vida y metodología.** Comparad la cascada con Scrum para este caso y elegid uno de forma razonada.
3. **Backlog ágil.** Si elegís Scrum (o un enfoque híbrido), redactad al menos **8 historias de usuario** con criterios de aceptación, estimadlas en puntos y ordenadlas. Definid la *Definition of Done* y planificad el primer *sprint*.
4. **Tablero.** Cread el tablero del primer *sprint* en GitHub Projects, Trello o Taiga y adjuntad un enlace o una captura.
5. **Herramientas.** Proponed una herramienta para cada fase (gestión, diseño, IDE, control de versiones, pruebas, documentación, despliegue) y evaluad brevemente qué aporta cada una.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE b** · Fases del desarrollo | Todas las fases, con actividades, roles y documentos adecuados al caso. | Se explica la relación entre fases y se tiene en cuenta la migración y el mantenimiento. | El plan es realista y está adaptado al contexto de la academia. |
| **CE g** · Metodologías ágiles | Comparativa correcta y *backlog* con historias bien formadas, estimación, DoD y *sprint*. | La elección se justifica con las características del proyecto; las historias cumplen INVEST. | El tablero es coherente con el *backlog* y el *sprint* tiene un objetivo claro y alcanzable. |
| **CE f** · Herramientas | Una herramienta adecuada para cada fase. | Se valora qué aporta cada herramienta y se compara con una alternativa. | Las herramientas forman una cadena coherente e integrada (por ejemplo, IDE + Git + CI). |
