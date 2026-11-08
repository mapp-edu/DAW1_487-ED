# 4. Herramientas, generación de código e ingeniería inversa

## Tipos de herramientas

| Tipo | Ejemplos | Ventajas | Inconvenientes |
|------|----------|----------|----------------|
| **Diagramas como texto** | **PlantUML**, **Mermaid** | Se versionan con Git, se revisan en los PR y se integran en la documentación | Menos control sobre la disposición |
| **Editores gráficos** | draw.io (diagrams.net), Lucidchart | Rápidos y visuales | No entienden la semántica UML |
| **Herramientas CASE / de modelado** | **Visual Paradigm** (Community Edition), StarUML, Modelio, Papyrus | Validan UML, **generan código** y hacen **ingeniería inversa** | Más complejas; algunas de pago |
| **Integradas en el IDE** | *Plugins* de PlantUML; diagramas de IntelliJ IDEA (con suscripción) | Diagrama y código en el mismo sitio | Funcionalidad variable |

## PlantUML

PlantUML genera diagramas a partir de un texto entre `@startuml` y `@enduml`. Hay *plugins* para IntelliJ IDEA (*PlantUML Integration*) y VS Code (*PlantUML*, de jebbs) con vista previa en directo.

```text title="biblioteca.puml"
@startuml
skinparam classAttributeIconSize 0

enum TipoLibro {
  NOVELA
  TEATRO
  POESIA
  TECNICO
}

class Libro {
  - titulo : String
  - tejuelo : String
  - tipo : TipoLibro
}

class Autor {
  - nombre : String
  - nacionalidad : String
  - fechaNacimiento : LocalDate
}

class Copia {
  - id : int
  - editorial : String
  - anyo : int
  - estado : EstadoCopia
}

class Lector {
  - numSocio : int
  - nombre : String
  - telefono : String
  + {static} MAX_PRESTAMOS : int = 3
  + puedePrestar() : boolean
}

class Prestamo {
  - inicio : LocalDate
  - fin : LocalDate
  + diasRetraso() : int
}

Libro "1..*" -- "1..*" Autor : escrito por >
Libro "1" *-- "1..*" Copia
Lector "1" --> "0..3" Prestamo
Prestamo "0..*" --> "1" Copia
@enduml
```

### Equivalencias de flechas

| Relación | PlantUML | Mermaid |
|----------|----------|---------|
| Asociación navegable | `A --> B` | `A --> B` |
| Agregación | `A o-- B` | `A o-- B` |
| Composición | `A *-- B` | `A *-- B` |
| Herencia | <code>Padre &lt;&#124;-- Hija</code> | <code>Padre &lt;&#124;-- Hija</code> |
| Realización | <code>Interfaz &lt;&#124;.. Clase</code> | <code>Interfaz &lt;&#124;.. Clase</code> |
| Dependencia | `A ..> B` | `A ..> B` |
| Multiplicidad | `A "1" -- "0..*" B` | `A "1" -- "0..*" B` |

## Ingeniería directa: del diagrama al código

La **generación de código** produce el esqueleto de las clases (atributos, firmas de métodos, relaciones como atributos y colecciones, herencia e interfaces) a partir del modelo. La lógica de los métodos la escribe el programador.

Con **Visual Paradigm Community Edition** (gratuito para uso no comercial y educativo):

1. Crea un proyecto y un **Class Diagram**; dibuja las clases y las relaciones.
2. *Tools → Code → Instant Generator…* → lenguaje **Java** → carpeta de salida → *Generate*.
3. Revisa el código: ¿cómo ha traducido cada multiplicidad, la composición y la herencia?

## Ingeniería inversa: del código al diagrama

La **ingeniería inversa** obtiene el diagrama a partir del código existente. Es muy útil para entender un proyecto heredado o para mantener la documentación actualizada.

- **Visual Paradigm**: *Tools → Code → Instant Reverse…* → Java → selecciona la carpeta `src` → arrastra las clases al diagrama.
- **IntelliJ IDEA**: el *plugin* de diagramas integrado requiere suscripción (gratuita con licencia educativa): clic derecho en un paquete → *Diagrams → Show Diagram*; puede exportarse a PlantUML. Sin suscripción, hay *plugins* del Marketplace que generan PlantUML desde el código (búscalos por «PlantUML generator»).
- **Desde la línea de comandos**: hay herramientas libres que generan PlantUML a partir de fuentes Java (por ejemplo, *doclets* de Javadoc con PlantUML).

!!! warning "Lo que la herramienta no sabe"
    La ingeniería inversa no puede distinguir por sí sola entre asociación, agregación y composición (en el código todas son atributos), ni deducir siempre las multiplicidades. Hay que **revisar y completar** el diagrama generado.

## Ida y vuelta (*round-trip*)

Las herramientas CASE pueden mantener sincronizados el modelo y el código: se cambia uno y se actualiza el otro. En la práctica, en los equipos ágiles se usan los diagramas sobre todo para **pensar y comunicar**, y se generan de nuevo desde el código cuando se necesita documentación actualizada.
