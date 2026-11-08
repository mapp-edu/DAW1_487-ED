# 3. Personalización y extensiones

## Añadir y eliminar módulos

Los IDE modernos tienen un núcleo pequeño que se amplía con **plugins** (IntelliJ) o **extensiones** (VS Code).

| Acción | IntelliJ IDEA | VS Code |
|--------|---------------|---------|
| Buscar e instalar | *Settings → Plugins → Marketplace* | Vista *Extensions* (++ctrl+shift+x++) |
| Desactivar sin desinstalar | Desmarcar la casilla en *Installed* | *Disable* (o *Disable (Workspace)*) |
| Desinstalar | *Installed → ⚙ → Uninstall* | *Uninstall* |
| Desde la terminal | — | `code --install-extension vscjava.vscode-java-pack`<br>`code --uninstall-extension <id>`<br>`code --list-extensions` |
| Recomendar extensiones a un equipo | *Settings → Plugins → Required plugins* del proyecto | Fichero `.vscode/extensions.json` |

```json title=".vscode/extensions.json: extensiones recomendadas del proyecto"
{
  "recommendations": [
    "vscjava.vscode-java-pack",
    "editorconfig.editorconfig",
    "sonarsource.sonarlint-vscode",
    "jebbs.plantuml"
  ]
}
```

!!! warning "Instala solo lo que necesites"
    Cada extensión consume memoria, puede ralentizar el arranque y, si procede de una fuente poco fiable, es un riesgo de seguridad. Revisa el autor, el número de descargas y los permisos.

## Personalización

### Apariencia y edición

- **Tema** de color e iconos, tipografía (las fuentes con ligaduras, como JetBrains Mono o Fira Code, son populares) y tamaño.
- **Mapa de teclado** (*keymap*): puedes usar el de otro IDE si vienes de Eclipse o de VS Code.
- **Diseño**: paneles visibles, minimapa, modo de presentación o de concentración.

### Estilo de codificación

El **estilo de código** (sangría, llaves, longitud de línea, orden de los *imports*) debe ser el mismo en todo el equipo. La forma más portable de compartirlo es un fichero **`.editorconfig`** en la raíz del proyecto, que entienden IntelliJ, VS Code y la mayoría de los editores:

```ini title=".editorconfig"
root = true

[*]
charset = utf-8
end_of_line = lf
insert_final_newline = true
trim_trailing_whitespace = true

[*.java]
indent_style = space
indent_size = 4
max_line_length = 120

[*.{md,yml,yaml,json}]
indent_size = 2
```

En IntelliJ IDEA, el estilo detallado de Java se configura en *Settings → Editor → Code Style → Java* y se puede guardar en el proyecto (*Scheme: Project*) para versionarlo con Git.

### Configuración de usuario y de proyecto

| | IntelliJ IDEA | VS Code |
|---|---|---|
| Ajustes de usuario | *Settings* (globales) | `settings.json` de usuario |
| Ajustes de proyecto | Carpeta `.idea/` (se versionan algunas partes) | `.vscode/settings.json` |
| Sincronizar entre equipos | *Backup and Sync* con cuenta de JetBrains | *Settings Sync* con cuenta de GitHub o Microsoft |
| Exportar/importar | *File → Manage IDE Settings → Export/Import* | Perfiles (*Profiles*) exportables |

## Automatización

### Plantillas y fragmentos de código

Escribe `psvm` o `sout` en IntelliJ IDEA y pulsa ++tab++: son **Live Templates**. En VS Code, el equivalente son los **snippets**. Puedes crear los tuyos:

```json title="Fragmento de usuario en VS Code (java.json)"
{
  "Método de prueba JUnit": {
    "prefix": "testm",
    "body": [
      "@Test",
      "void ${1:nombreDelTest}() {",
      "    // Arrange",
      "    $2",
      "    // Act",
      "    // Assert",
      "}"
    ],
    "description": "Plantilla de prueba con Arrange-Act-Assert"
  }
}
```

### Tareas, acciones y macros

- **Configuraciones de ejecución** (*Run Configurations* en IntelliJ, `launch.json` en VS Code): guardan cómo se ejecuta o depura un programa (argumentos, variables de entorno, JDK).
- **Tareas** (`tasks.json` en VS Code, *External Tools* en IntelliJ): lanzan comandos (compilar, empaquetar, generar documentación) con un atajo.
- **Acciones al guardar** (*Actions on Save* en IntelliJ; `editor.formatOnSave` y `editor.codeActionsOnSave` en VS Code): formatean el código y ordenan los *imports* automáticamente.
- **Macros** (IntelliJ: *Edit → Macros*): graban una secuencia de acciones del editor para repetirla.

```json title=".vscode/tasks.json: compilar y empaquetar con una tarea"
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Empaquetar JAR",
      "type": "shell",
      "command": "javac -d out src/*.java && jar --create --file app.jar --main-class Main -C out .",
      "group": { "kind": "build", "isDefault": true },
      "problemMatcher": []
    }
  ]
}
```

Con ++ctrl+shift+b++ se ejecuta la tarea de construcción por defecto.
