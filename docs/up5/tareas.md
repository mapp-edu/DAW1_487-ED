# Tareas de la UP5

Calificación con la [escala común 0–4](../modulo/rubricas.md). Las cuatro tareas se hacen sobre **el mismo repositorio** `ed-up5-<usuario>`, de forma que al final tengas un proyecto refactorizado, analizado, documentado y con integración continua. Entrega en Aules el enlace y, para cada tarea, el PR correspondiente.

---

## T5.1 · Refactorización guiada por pruebas { #t51 }

**RA4 · CE a, b, e** · Peso: 15 % de las tareas del RA4 · Individual

### Enunciado

Parte de **uno** de estos programas (cópialo al repositorio en un primer *commit* sin cambios):

- [`NotasNoEstructurado.java`](../recursos/up1/NotasNoEstructurado.java), ampliado para N alumnos;
- el programa del aparcamiento de la T3.1;
- tu juego de Hundir la flota de la T3.3.

Pasos:

1. **Pruebas de caracterización (CE b).** Antes de tocar nada, escribe pruebas de JUnit que capturen el comportamiento actual. Si el código no se puede probar (todo está en `main`), haz primero la **mínima** extracción de métodos necesaria y explícalo.
2. **Identifica los malos olores (CE a)**: al menos 5, con su nombre del catálogo, la línea y la refactorización que propones.
3. **Refactoriza con el IDE (CE e)** aplicando al menos **6 refactorizaciones distintas** (renombrar, extraer método, extraer constante, extraer clase, sustituir condicional por polimorfismo, introducir objeto parámetro…). **Un *commit* por refactorización**, con el nombre de la refactorización en el mensaje (`refactor: extrae método calcularMedia`).
4. Las pruebas deben estar **en verde tras cada *commit***.
5. Tabla final en el README: olor → refactorización → *commit* → atajo o menú del IDE utilizado.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE a** · Patrones de refactorización | 5 olores identificados con la refactorización adecuada. | Se explica por qué cada olor perjudica el mantenimiento. | Se relacionan con principios de diseño (responsabilidad única, abierto/cerrado). |
| **CE b** · Pruebas asociadas | Pruebas de caracterización previas que pasan antes y después. | Se razona qué comportamiento protege cada prueba y sus límites. | Las pruebas se mejoran también y quedan como especificación legible. |
| **CE e** · Refactorizar con el IDE | 6 refactorizaciones distintas hechas con la herramienta del IDE, un *commit* cada una. | Cada *commit* es atómico y las pruebas siguen en verde (verificable en el historial). | El código final es claramente mejor y se presenta un antes y después medido (complejidad, longitud de los métodos). |

---

## T5.2 · Revisión con un analizador de código { #t52 }

**RA4 · CE c, d** · Peso: 10 % de las tareas del RA4 · Individual

### Enunciado

1. **Revisión (CE c).** Analiza el proyecto de la T5.1 con **SonarQube for IDE** y con las **inspecciones de IntelliJ IDEA** (o con Checkstyle en VS Code). Clasifica los hallazgos (errores, vulnerabilidades, malos olores, estilo) y **corrige al menos 8**, en *commits* separados.
2. Para al menos **2 hallazgos que decidas no corregir**, justifica la decisión y suprímelos de forma explícita y documentada.
3. **Configuración (CE d).** Añade **Checkstyle** al `pom.xml` con un `checkstyle.xml` propio en el que:
    - cambies el umbral de al menos 2 reglas (por ejemplo, la longitud de los métodos y la complejidad ciclomática);
    - desactives 1 regla que no tenga sentido para tu proyecto, justificándolo;
    - excluyas el código de pruebas de alguna regla.
4. Haz que `mvn checkstyle:check` falle si se incumplen las reglas y comprueba que falla introduciendo una violación a propósito.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE c** · Revisión con analizador | Dos analizadores usados y 8 hallazgos corregidos. | Se explica cada regla incumplida y por qué la corrección mejora el código; las supresiones están justificadas. | Comparación crítica de lo que detecta cada herramienta. |
| **CE d** · Configuración | `checkstyle.xml` con los cambios pedidos y fallo de construcción comprobado. | Cada cambio de configuración se razona para el contexto del proyecto. | Configuración compartida en el repositorio y lista para la CI (T5.4). |

---

## T5.3 · Documentación del proyecto { #t53 }

**RA4 · CE g** · Peso: 9 % de las tareas del RA4 · Individual

*Adaptada de las prácticas de Javadoc, Markdown y MkDocs del curso 2025-26.*

### Enunciado

1. **Javadoc.** Documenta **todas** las clases y los métodos públicos del proyecto con las etiquetas que correspondan (`@param`, `@return`, `@throws`, `@author`, `@version`, `@since`, `@see`). Usa el generador de esqueletos del IDE y revisa la inspección de Javadoc hasta que no haya avisos.
2. Genera la documentación HTML con Maven (`mvn javadoc:javadoc`) y desde el IDE.
3. **Documentación como código.** Crea un sitio con **Zensical** en la carpeta `docs/` con, como mínimo: portada, guía de instalación y ejecución, guía de uso con capturas, un diagrama Mermaid de la estructura de clases y una página de «Decisiones de diseño» que recoja las refactorizaciones de la T5.1.
4. Enlaza el Javadoc generado desde el sitio.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE g** · Javadoc con el IDE | Todas las clases y los métodos públicos documentados; HTML generado sin avisos. | Las descripciones explican el contrato (precondiciones, valores especiales, excepciones), no repiten el nombre. | Coherente con el código final y con ejemplos de uso con `{@code}`. |
| **CE g** · Documentación como código | Sitio de Zensical con todas las páginas pedidas. | Se explica qué tipo de documentación es cada página y para quién está escrita. | Documentación clara y profesional, enlazada con el Javadoc y el README. |

---

## T5.4 · *Pipeline* de integración continua { #t54 }

**RA4 · CE i** · Peso: 13 % de las tareas del RA4 · Individual

### Enunciado

1. Crea `.github/workflows/ci.yml` que, en cada *push* y *pull request* a `main`: compile con Java 25, ejecute las pruebas con cobertura (`mvn verify`), compruebe Checkstyle y guarde el informe de JaCoCo como artefacto.
2. Crea `.github/workflows/docs.yml` que publique en **GitHub Pages** el sitio de Zensical de la T5.3 (con el Javadoc incluido).
3. Activa la **protección de `main`** exigiendo que el *workflow* de CI pase antes de fusionar.
4. **Demuestra el funcionamiento**: abre un PR que rompa una prueba (la CI debe fallar y bloquear el *merge*), corrígelo en la misma rama y fusiónalo cuando esté en verde.
5. Añade al README las insignias de CI y el enlace a la documentación publicada.

### Rúbrica

| Elemento | Nivel 2 · Correcto y completo | Nivel 3 · Justificado | Nivel 4 · Coherente y bien comunicado |
|----------|-------------------------------|-----------------------|---------------------------------------|
| **CE i** · *Pipeline* de CI | El *workflow* compila, prueba, comprueba el estilo y guarda la cobertura; se ejecuta en *push* y PR. | Se explica cada paso y evento del YAML y la diferencia entre CI, entrega y despliegue continuos. | Uso de caché, insignias y artefactos; *pipeline* rápido y bien estructurado. |
| **CE i** · Integración en el flujo de trabajo | Rama protegida con comprobación obligatoria y PR fallido y corregido. | Se razona el valor de bloquear fusiones (relación con la UP3). | Documentación publicada automáticamente y enlazada; el repositorio sirve como plantilla para otros proyectos. |
