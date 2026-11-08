# Tareas de la UP2

Calificación con la [escala común 0–4](../modulo/rubricas.md). Entrega en Aules: PDF `UP2-T2x-Apellido-Nombre.pdf` y, en la T2.2, también un ZIP con el código y los ejecutables.

---

## T2.1 · Mi entorno de desarrollo { #t21 }

**RA2 · CE a, b, c, d** · Peso: 50 % de las tareas del RA2 · Individual

### Enunciado

Documenta, con capturas y explicaciones, la preparación de **dos entornos**: IntelliJ IDEA (propietario, con versión gratuita) y VS Code (con núcleo libre).

1. **Instalación (CE a).** Instala el JDK 25 y los dos entornos. Indica el método de instalación, la versión y la licencia de cada uno. Explica la diferencia entre instalar IntelliJ IDEA con la Toolbox App y con el instalador directo.
2. **Módulos (CE b).** En cada entorno, instala **al menos dos** extensiones o *plugins* útiles para el curso (por ejemplo, SonarQube for IDE, PlantUML, Rainbow Brackets, GitLens) y **desinstala o desactiva** otro. Muestra el antes y el después.
3. **Personalización y automatización (CE c).**
    - Ajusta el tema, la fuente y un atajo de teclado.
    - Crea un `.editorconfig` y comprueba que los dos entornos lo respetan.
    - Crea **una plantilla o *snippet* propio** en cada entorno y una **acción automática** (formatear al guardar, una tarea o una macro).
4. **Actualizaciones (CE d).** Configura en cada entorno cómo se actualizan el IDE y las extensiones. Elige la política que te parezca más adecuada para un curso con entregas y justifícala.

Para comprobar que todo funciona, resuelve en ambos entornos **uno** de estos ejercicios (adaptados de los «Ejercicios de Java para practicar con IntelliJ» del curso 2025-26):

??? example "Ejercicio A · Rectángulo hueco"
    Pide `alto` y `ancho` y dibuja solo el borde de un rectángulo de asteriscos.
    ```text
    alto = 4, ancho = 6
    ******
    *    *
    *    *
    ******
    ```

??? example "Ejercicio B · Números crecientes hasta un límite"
    Pide `n` (filas) y `limite`. En la fila *i* se escriben *i* números consecutivos; la impresión se detiene al llegar a `limite`.
    ```text
    n = 6, limite = 20
    1
    2 3
    4 5 6
    7 8 9 10
    11 12 13 14 15
    16 17 18 19 20
    ```

??? example "Ejercicio C · Tabla N×N clasificada"
    Pide `n` y muestra los números del 1 a n² en una tabla n×n, sustituyendo cada uno por una letra: **X** si es múltiplo de 10, **P** si es primo, **E** si es par no primo, **I** si es impar no primo (el 1 cuenta como impar no primo). Al final, muestra cuántos hay de cada tipo.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE a** · Instalación | Los dos entornos y el JDK, instalados y verificados, con su versión y licencia. | Se comparan los métodos de instalación y se elige uno de forma razonada. | Documentación que otra persona podría seguir paso a paso. |
| **CE b** · Módulos | Extensiones instaladas y desinstaladas o desactivadas en ambos entornos. | Se explica para qué sirve cada una y por qué se elige. | Se incluye `.vscode/extensions.json` o los *plugins* requeridos del proyecto. |
| **CE c** · Personalización y automatización | Apariencia, `.editorconfig`, plantilla y automatización funcionando. | Se explica qué problema resuelve cada ajuste. | Configuración coherente y exportada (perfil o ajustes) para reutilizarla. |
| **CE d** · Actualizaciones | Actualizaciones configuradas en los dos entornos. | La política elegida se justifica (estabilidad frente a seguridad). | Se describe cómo volver a una versión anterior si algo falla. |

---

## T2.2 · Un código, varios entornos; un entorno, varios lenguajes { #t22 }

**RA2 · CE e, f, g** · Peso: 50 % de las tareas del RA2 · Individual

### Enunciado

1. **Mismo código, varios entornos (CE f).** Con el programa Java de la T2.1, genera un **JAR ejecutable** de tres formas: desde la terminal, desde IntelliJ IDEA y desde VS Code. Ejecuta los tres con `java -jar` y compara dónde se generan, su tamaño y su manifiesto (`unzip -p app.jar META-INF/MANIFEST.MF`, o abre el JAR como ZIP).
2. **Mismo entorno, varios lenguajes (CE e).** En VS Code, escribe el mismo programa en **Python** y en **JavaScript** (Node.js) o **C**, y obtén su forma ejecutable (script, binario o ejecutable de PyInstaller). Indica qué extensión y qué herramienta usa cada lenguaje.
3. **Comparativa (CE g).** Elabora una tabla de características **comunes y específicas** de IntelliJ IDEA y VS Code a partir de **tu experiencia** en las dos tareas, y termina con una recomendación: ¿cuál usarías para un proyecto Java de equipo? ¿Y para un proyecto web con varios lenguajes?

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE f** · Mismo código, varios entornos | Tres JAR generados y ejecutados correctamente. | Se explican las diferencias encontradas y por qué una herramienta de construcción común evita problemas. | La comparación de manifiestos y ubicaciones es rigurosa. |
| **CE e** · Varios lenguajes en un entorno | Dos lenguajes más, ejecutados desde VS Code. | Se explica cómo traduce y ejecuta cada lenguaje (relación con la UP1). | Se automatiza la ejecución con tareas de VS Code. |
| **CE g** · Comunes y específicas | Tabla con al menos 8 aspectos. | Cada aspecto se apoya en la experiencia propia (capturas o ejemplos). | Recomendación razonada según el tipo de proyecto. |
