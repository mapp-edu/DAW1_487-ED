# Entorno de trabajo

Todo el software del módulo es gratuito y funciona en Linux, Windows y macOS. Prepara el entorno durante la UP2: a partir de ahí se usa en todas las unidades.

## Software necesario

| Herramienta | Para qué | Unidades |
|-------------|----------|:--------:|
| **JDK 25** (Eclipse Temurin u OpenJDK) | Compilar y ejecutar Java. Es la versión LTS actual. | Todas |
| **IntelliJ IDEA** | IDE principal para Java. Desde la versión 2025.3 se distribuye en una única edición, gratuita en sus funciones básicas. | UP2 en adelante |
| **Visual Studio Code** + *Extension Pack for Java* | Segundo IDE: comparación de entornos y trabajo con varios lenguajes. | UP2 en adelante |
| **Git** | Control de versiones. | UP3 en adelante |
| **Cuenta de GitHub** | Repositorios remotos, *pull requests*, GitHub Actions y GitHub Pages. | UP3 en adelante |
| **Maven** | Construcción del proyecto y gestión de dependencias (JUnit, Mockito). IntelliJ IDEA ya lo incluye. | UP4 y UP5 |
| **SonarQube for IDE** (antes SonarLint) | Analizador de código integrado en el IDE. | UP5 |
| **PlantUML** (extensión del IDE) | Diagramas UML como texto. | UP6 y UP7 |
| **Visual Paradigm Community Edition** | Generación de código e ingeniería inversa UML. Gratuito para uso educativo y no comercial. | UP6 |
| **Python 3** + **Zensical** | Documentación técnica en Markdown publicada como web. | UP5 |

## Comprobación rápida

Después de instalar, abre una terminal y comprueba las versiones:

```bash
java --version     # debe mostrar 25.x
javac --version
git --version
mvn --version      # opcional si usas el Maven de IntelliJ IDEA
python3 --version  # o «python --version» en Windows
```

Configura tu identidad en Git (solo una vez):

```bash
git config --global user.name "Nombre Apellido"
git config --global user.email "tu-correo@ejemplo.com"
git config --global init.defaultBranch main
```

## Convenciones de entrega

- Un **repositorio por tarea** (o uno por unidad si la tarea lo indica), llamado `ed-<unidad>-<tarea>-<usuario>`, por ejemplo `ed-up3-t31-lgarcia`.
- Cada repositorio incluye un **README.md** que explica qué contiene, cómo se ejecuta y qué decisiones se han tomado.
- En Aules se entrega el **enlace** al repositorio (y, si la tarea lo pide, un PDF con capturas y respuestas).
- Los repositorios pueden ser privados; en ese caso, añade al docente como colaborador.
