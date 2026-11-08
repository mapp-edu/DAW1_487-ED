# Tareas de la UP3

Calificación con la [escala común 0–4](../modulo/rubricas.md). En Aules se entrega el **enlace al repositorio** de GitHub (si es privado, añade al docente como colaborador) y un PDF breve con las capturas que se piden. **El repositorio es la evidencia principal**: un programa que funciona pero no usa Git correctamente no supera la tarea.

---

## T3.1 · Primer repositorio: aparcamiento { #t31 }

**RA4 · CE f** · Peso: 16 % de las tareas del RA4 · Individual

*Adaptado de la «Actividad semana pre-Navidad (PROG-GIT)» del curso 2025-26.*

### Parte A · Programa

Desarrolla en Java un programa que controle la ocupación de un aparcamiento de **3 plantas con 5 plazas** cada una (matriz 3×5; 0 = libre, 1 = ocupada):

1. Pide el estado de cada plaza y vuelve a pedirlo si no es 0 o 1.
2. Muestra el estado de cada planta y sus plazas libres.
3. Muestra el total de plazas libres y ocupadas.
4. Indica la planta con más plazas libres.

*Ampliación opcional:* comprobación de cuadrados mágicos N×N (filas, columnas y diagonales con la misma suma).

### Parte B · Control de versiones

1. Crea el repositorio **desde la terminal** (`git init`) con un `.gitignore` adecuado y un `README.md`.
2. Haz **al menos 6 *commits* atómicos** que reflejen el avance (estructura, lectura con validación, visualización, cálculos…). Usa mensajes descriptivos (se recomienda Conventional Commits).
3. Haz al menos **3 de esos *commits* desde el IDE** (IntelliJ IDEA o VS Code), revisando antes el *diff*.
4. Crea el repositorio vacío en GitHub (sin README ni `.gitignore`), enlázalo como `origin` y publica `main`.
5. Crea la etiqueta `v1.0` en el *commit* final y publícala (`git push --tags`).
6. Practica deshacer: introduce un error en un *commit* y corrígelo con `git revert`.

**PDF:** capturas de `git log --oneline --graph`, de la vista de cambios del IDE antes de un *commit* y del repositorio en GitHub.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE f** · Uso de Git (terminal e IDE) | Repositorio con `.gitignore`, 6 o más *commits* (3 desde el IDE), remoto, etiqueta y `revert`. | El PDF explica qué hace cada operación y por qué se usa `revert` en lugar de `reset`. | *Commits* atómicos con mensajes impecables; el historial cuenta la evolución del programa. |
| Programa | Cumple los 4 requisitos y se ejecuta sin errores. | Código estructurado en métodos con nombres claros. | README con instrucciones de ejecución y ejemplo de salida. |

*Pesos: CE f 70 %, programa 30 %.*

---

## T3.2 · Ramas y conflictos { #t32 }

**RA4 · CE f** · Peso: 16 % de las tareas del RA4 · Individual

### Enunciado

Sobre el repositorio de la T3.1:

1. Crea la rama `feature/estadisticas` y añade el **porcentaje de ocupación** por planta y total (2 *commits* o más).
2. Sin fusionar aún, vuelve a `main`, crea `fix/mensajes` y **cambia los mismos mensajes de salida** que has tocado en `feature/estadisticas`.
3. Fusiona `fix/mensajes` en `main` (avance rápido) y después `feature/estadisticas`: **debe producirse un conflicto**. Resuélvelo con la herramienta de fusión del IDE.
4. Elimina las ramas fusionadas, local y remotamente.
5. Responde: ¿qué tipo de fusión ha hecho Git en cada caso y por qué? ¿Qué habría pasado con `git rebase main` en `feature/estadisticas` antes de fusionar?

**PDF:** captura del conflicto en el IDE (tres paneles), captura del grafo final (`git log --oneline --graph --all`) y respuestas.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE f** · Ramas y fusiones | Ramas creadas, fusionadas y eliminadas; grafo correcto. | Se identifican correctamente la fusión *fast-forward* y la de tres vías y se explica por qué ocurre cada una. | Ramas con nombres convencionales y explicación del *rebase* precisa, con un esquema. |
| **CE f** · Conflictos con el IDE | Conflicto producido y resuelto, sin marcadores restantes; el programa funciona. | Se explica qué decisión se tomó al resolverlo y por qué. | El *commit* de fusión describe la resolución. |

---

## T3.3 · Hundir la flota en equipo { #t33 }

**RA4 · CE h** · Peso: 21 % de las tareas del RA4 · En parejas

*Adaptado del ejercicio «Hundir la flota (PROG-GITHUB)» del curso 2025-26.*

### Enunciado

Desarrollad en pareja el juego **Hundir la flota** por consola, en Java, siguiendo **GitHub Flow**.

**Organización del repositorio (una persona lo crea):**

1. Repositorio `hundir-la-flota-<apellido1>-<apellido2>` con README y `.gitignore` de Java. Añadid al compañero como colaborador.
2. **Protección de la rama `main`**: no se permite hacer *push* directo y se exige un PR con al menos 1 aprobación. En repositorios privados, esta opción requiere GitHub Pro, que es gratuito con GitHub Education; si no lo tenéis, haced el repositorio público.
3. Cread *issues* para las tareas y un tablero en GitHub Projects.

**Reparto mínimo:**

| Alumno/a A · Lógica | Alumno/a B · Interfaz de consola |
|---------------------|----------------------------------|
| Tablero (matriz de `char`) | Mostrar el tablero |
| Colocación aleatoria de barcos | Pedir y validar la fila y la columna |
| Disparos, intentos, victoria y derrota | Mensajes del juego y menú |
| Clases `Board` y `Game` | Clases `Main` y `ConsoleUI` |

**Flujo obligatorio:**

1. Cada funcionalidad se desarrolla en una **rama** (`feature/...`) enlazada a su *issue*.
2. Cada rama se integra mediante un **PR** que **revisa la otra persona** (al menos un comentario real por PR).
3. Provocad y resolved **al menos un conflicto** (por ejemplo, ambos modificáis `Main.java`), documentado en el PR.
4. Publicad la versión `v1.0` como **release** de GitHub.

**Entrega individual en Aules:** enlace al repositorio y un PDF con (a) capturas de los PR y de la revisión, (b) el grafo de ramas (*Insights → Network*), (c) la resolución del conflicto y (d) una **reflexión personal** sobre qué ha funcionado y qué cambiaríais.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE h** · Repositorio remoto y flujo | `main` protegida; ramas por funcionalidad; todo integrado mediante PR; *release* `v1.0`. | El PDF justifica la estrategia (por qué GitHub Flow) y explica cada paso. | *Issues*, PR y tablero enlazados de forma coherente; historial limpio. |
| **CE h** · Colaboración y revisión | Commits propios de ambos miembros, PR revisados por el compañero y conflicto resuelto. | Las revisiones aportan comentarios útiles y se atienden con nuevos *commits*. | Trabajo equilibrado y reflexión personal madura. |
| Programa | El juego funciona de principio a fin. | Responsabilidades separadas en clases. | README con reglas, ejecución y capturas. |

*Pesos: flujo 40 %, colaboración 40 %, programa 20 %.*
