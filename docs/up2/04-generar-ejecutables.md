# 4. Generar ejecutables

En Java, el «ejecutable» habitual es un fichero **JAR** (*Java ARchive*): un ZIP con los `.class`, los recursos y un **manifiesto** que indica la clase principal. Se ejecuta con `java -jar app.jar` en cualquier sistema con una JVM. Si se quiere un instalador nativo (`.exe`, `.deb`, `.dmg`), se usa `jpackage`.

## Un mismo código, varios entornos

Partimos de un proyecto sencillo:

```text
rectangulo/
└── src/
    └── Main.java
```

=== "Terminal (sin IDE)"

    ```bash
    javac -d out src/Main.java
    jar --create --file rectangulo.jar --main-class Main -C out .
    java -jar rectangulo.jar
    ```

=== "IntelliJ IDEA"

    1. *File → Project Structure → Artifacts → + → JAR → From modules with dependencies…* y elige la clase `Main`.
    2. *Build → Build Artifacts… → rectangulo:jar → Build*.
    3. El JAR aparece en `out/artifacts/rectangulo_jar/`.

    Si el proyecto es de **Maven**, basta con ejecutar la fase `package` en la ventana *Maven*. El JAR queda en `target/`.

=== "VS Code"

    1. Abre la carpeta del proyecto. La extensión de Java la reconoce como proyecto.
    2. En la vista *Java Projects*, pulsa el icono **Export Jar…** y elige la clase principal.
    3. El JAR se genera en la raíz del proyecto.

    También puedes usar la tarea de `tasks.json` del apartado anterior.

=== "Maven (cualquier entorno)"

    ```bash
    mvn package
    java -jar target/rectangulo-1.0.jar
    ```

    Para que el JAR sea ejecutable, el `pom.xml` debe declarar la clase principal en el *plugin* `maven-jar-plugin`. Maven se estudia en la [UP4](../up4/04-junit.md).

Fíjate en que **el JAR resultante es equivalente**. Lo que cambia es dónde queda, qué metadatos añade cada herramienta y lo fácil que es repetir el proceso. Por eso, en un equipo, la construcción se basa en una herramienta independiente del IDE (Maven o Gradle) y cada IDE la usa.

## Un mismo entorno, varios lenguajes

VS Code permite trabajar con muchos lenguajes instalando sus extensiones:

| Lenguaje | Extensión | «Ejecutable» que se obtiene | Comando |
|----------|-----------|-----------------------------|---------|
| Java | Extension Pack for Java | `.jar` | `java -jar app.jar` |
| Python | Python (Microsoft) | Script `.py` o ejecutable con PyInstaller | `python app.py`<br>`pyinstaller --onefile app.py` |
| JavaScript / TypeScript | Integrada | Script (Node.js) o *bundle* | `node app.js`<br>`npx tsc` |
| C | C/C++ (Microsoft) | Binario nativo | `gcc main.c -o app` |

IntelliJ IDEA también admite otros lenguajes mediante *plugins* (Python, por ejemplo), aunque JetBrains ofrece IDE específicos para cada uno (PyCharm, WebStorm, CLion).

## Características comunes y específicas

| Aspecto | IntelliJ IDEA | VS Code |
|---------|---------------|---------|
| Tipo | IDE completo, especializado en la JVM | Editor extensible y multilenguaje |
| Modelo de proyecto | Módulos y artefactos propios + Maven/Gradle | Carpeta + ficheros de configuración (`.vscode/`) |
| Análisis de código | Muy profundo (inspecciones propias) | El que aporta cada extensión (LSP) |
| Refactorización | Muy completa | Básica o intermedia en Java |
| Consumo de recursos | Alto | Moderado (depende de las extensiones) |
| Configuración | Menús y asistentes | Ficheros JSON y paleta de comandos |
| Comunes a ambos | Git integrado, terminal, depurador, ejecución de pruebas, Maven, marketplace de extensiones, sincronización de ajustes, asistentes de IA | |
