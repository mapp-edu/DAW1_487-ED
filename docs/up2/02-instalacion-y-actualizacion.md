# 2. Instalación y actualización

## Paso 1: el JDK

Los IDE de Java necesitan un **JDK** (*Java Development Kit*) para compilar. Usaremos **Java 25 (LTS)**.

=== "Windows"

    1. Descarga el instalador `.msi` de **Eclipse Temurin 25** desde [adoptium.net](https://adoptium.net/).
    2. Durante la instalación, activa **«Set JAVA_HOME variable»** y **«Add to PATH»**.
    3. Abre una terminal nueva y comprueba la versión con `java --version`.

    También puedes instalarlo con `winget install EclipseAdoptium.Temurin.25.JDK`.

=== "Linux (Debian/Ubuntu)"

    ```bash
    sudo apt update
    sudo apt install openjdk-25-jdk   # si tu distribución aún no lo ofrece, usa el repositorio de Adoptium
    java --version
    ```

=== "macOS"

    ```bash
    brew install --cask temurin@25
    java --version
    ```

!!! tip "Varias versiones de Java"
    En el mundo profesional es normal tener varios JDK instalados. IntelliJ IDEA puede descargarlos y gestionarlos por proyecto (*Project Structure → SDK*). En la terminal puedes usar [SDKMAN!](https://sdkman.io/) (Linux y macOS).

## Paso 2: IntelliJ IDEA

Dos formas de instalarlo:

- **JetBrains Toolbox App** (recomendada): gestiona la instalación, las actualizaciones y las versiones de todos los IDE de JetBrains.
- **Instalador directo** desde [jetbrains.com/idea/download](https://www.jetbrains.com/idea/download/).

La primera vez que lo abras, elige el tema y el mapa de teclado, y deja el resto de opciones por defecto. Si tienes una licencia educativa de JetBrains, actívala desde *Help → Register*.

## Paso 3: Visual Studio Code

1. Descárgalo desde [code.visualstudio.com](https://code.visualstudio.com/) (o con `winget install Microsoft.VisualStudioCode`, `sudo snap install code --classic` o `brew install --cask visual-studio-code`).
2. Instala el paquete de extensiones **Extension Pack for Java** (de Microsoft): incluye el soporte del lenguaje, el depurador, la ejecución de pruebas y Maven.
3. Abre la paleta de comandos (++ctrl+shift+p++), ejecuta *Java: Configure Java Runtime* y comprueba que detecta el JDK 25.

## Sistema de actualización

Mantener el entorno actualizado corrige errores y vulnerabilidades, pero una actualización a mitad de una entrega puede romper algo. Conviene saber configurarlo.

| | IntelliJ IDEA | VS Code |
|---|---|---|
| **Dónde se configura** | *Settings → Appearance & Behavior → System Settings → Updates* (o en la Toolbox App) | *Settings* → buscar `update.mode` |
| **Opciones** | Canal *Stable*, *Beta* o *EAP*; comprobar automáticamente; actualizar *plugins* | `default` (automático), `start` (solo al arrancar), `manual`, `none` |
| **Extensiones y plugins** | *Settings → Plugins → ⚙ → Update plugins automatically* | `extensions.autoUpdate`: `true`, `onlyEnabledExtensions` o `false` |
| **Volver atrás** | La Toolbox App permite instalar versiones anteriores (*rollback*) | *Install Another Version…* en cada extensión |

```json title="settings.json de VS Code: actualizaciones bajo control"
{
  "update.mode": "manual",
  "extensions.autoUpdate": "onlyEnabledExtensions",
  "extensions.autoCheckUpdates": true
}
```

!!! note "EAP, Beta e Insiders"
    *EAP* (IntelliJ) e *Insiders* (VS Code) son versiones preliminares con las novedades antes que nadie, pero menos estables. Para el curso, usa siempre el canal **estable**.
