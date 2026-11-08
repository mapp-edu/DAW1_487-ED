# 5. Git en el IDE

Conocer los comandos te permite entender lo que pasa. Usar Git desde el IDE te hace más productivo: los cambios se ven marcados en el editor, las diferencias se comparan visualmente y los conflictos se resuelven en una vista de tres paneles. Lo profesional es dominar **ambas** formas.

## Equivalencias

| Operación | Terminal | IntelliJ IDEA | VS Code |
|-----------|----------|---------------|---------|
| Iniciar repositorio | `git init` | *VCS → Create Git Repository* | Vista *Source Control* → *Initialize Repository* |
| Clonar | `git clone url` | *File → New → Project from Version Control* | Paleta: *Git: Clone* |
| Ver cambios | `git status`, `git diff` | Ventana *Commit* (++alt+0++); marcas en el margen del editor | Vista *Source Control* (++ctrl+shift+g++) |
| Preparar y confirmar | `git add`, `git commit` | Marcar ficheros + mensaje → *Commit* (++ctrl+k++) | `+` en cada fichero + mensaje → ✓ *Commit* |
| Historial | `git log --graph` | Ventana *Git → Log* (++alt+9++) | *Timeline*, o la extensión *Git Graph* / *GitLens* |
| Ramas | `git switch -c` | Widget de rama en la barra superior → *New Branch* | Nombre de la rama en la barra de estado → *Create new branch* |
| Fusionar | `git merge` | Widget de rama → rama → *Merge into Current* | Paleta: *Git: Merge Branch…* |
| Resolver conflictos | Editar los marcadores | *Merge Conflicts → Merge…* (tres paneles) | *Merge Editor* (*Resolve in Merge Editor*) |
| Sincronizar | `git pull`, `git push` | *Update Project* (++ctrl+t++) / *Push* (++ctrl+shift+k++) | *Sync Changes* en la barra de estado |
| *Pull requests* | `gh pr create` | *Plugin* GitHub integrado: ventana *Pull Requests* | Extensión *GitHub Pull Requests* |
| Ver quién cambió una línea | `git blame` | Clic derecho en el margen → *Annotate with Git Blame* | Extensión *GitLens* |

## Buenas prácticas en el IDE

- Revisa el **diff** antes de cada *commit*: el IDE muestra exactamente qué se va a confirmar.
- En IntelliJ IDEA, las ***changelists*** permiten separar en *commits* distintos cambios que has hecho a la vez.
- Activa las comprobaciones previas al *commit* (*Commit → ⚙ → Reformat code, Optimize imports, Analyze code*). Así llegan menos errores al repositorio.
- No ignores los avisos de ficheros que no deberían versionarse: añádelos al `.gitignore`.
- Usa la terminal integrada para las operaciones avanzadas (`rebase -i`, `reflog`).
