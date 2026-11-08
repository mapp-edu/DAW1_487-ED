# 2. Analizadores de código

Un **analizador estático** examina el código **sin ejecutarlo** y detecta errores probables, vulnerabilidades, malos olores, incumplimientos de estilo y complejidad excesiva. Es una revisión automática que complementa (no sustituye) las pruebas y la revisión humana.

## Qué detectan

| Categoría | Ejemplos |
|-----------|----------|
| **Errores probables (*bugs*)** | Posible `NullPointerException`, recurso no cerrado, `equals` sin `hashCode`, comparar `String` con `==` |
| **Vulnerabilidades** | Inyección SQL, credenciales en el código, criptografía débil |
| **Mantenibilidad (*code smells*)** | Métodos demasiado complejos, código duplicado, variables sin usar, código muerto |
| **Estilo** | Nombres que no siguen las convenciones, longitud de línea, llaves, *imports* sin usar |
| **Métricas** | Complejidad ciclomática y cognitiva, líneas por método, duplicación (%) |

## Herramientas para Java

| Herramienta | Enfoque | Integración |
|-------------|---------|-------------|
| **Inspecciones de IntelliJ IDEA** | Muy amplias e integradas en el editor | *Code → Inspect Code…* |
| **SonarQube for IDE** (antes SonarLint) | Errores, vulnerabilidades y mantenibilidad, con explicaciones de cada regla | Extensión para IntelliJ IDEA, VS Code y Eclipse |
| **SonarQube Server / SonarQube Cloud** | Análisis del proyecto completo, histórico y **quality gates** | CI (GitHub Actions) y modo conectado con el IDE |
| **Checkstyle** | Estilo y convenciones (Google, Sun) | *Plugin* del IDE y de Maven |
| **PMD** | Malas prácticas, código muerto y duplicación (CPD) | *Plugin* del IDE y de Maven |
| **SpotBugs** | Errores en el *bytecode* | *Plugin* de Maven y del IDE |

## Analizar desde el IDE

=== "SonarQube for IDE"

    1. Instala la extensión **SonarQube for IDE** (IntelliJ IDEA: *Settings → Plugins*; VS Code: *Extensions*).
    2. Los problemas aparecen **subrayados mientras escribes**, y en la ventana o vista *SonarQube for IDE*.
    3. Cada incidencia enlaza a la **regla** (por ejemplo, `java:S3776` *Cognitive Complexity of methods should not be too high*) con una explicación y un ejemplo de corrección.

=== "Inspecciones de IntelliJ IDEA"

    1. *Code → Inspect Code…* y elige el alcance (proyecto, módulo, fichero).
    2. El informe agrupa los problemas por categoría y gravedad. Muchos tienen un *quick fix* (++alt+enter++).
    3. *Settings → Editor → Inspections* permite activar o desactivar reglas y cambiar su gravedad.

## Configurar un analizador

Ningún equipo usa todas las reglas con la configuración por defecto. Las posibilidades habituales son:

- **Activar o desactivar reglas** y agruparlas en **perfiles** (*quality profiles*, *inspection profiles*).
- Ajustar los **parámetros** de una regla: umbral de complejidad, longitud máxima de método, patrón de nombres.
- Cambiar la **gravedad** (*blocker, critical, major, minor, info*) o tratar los avisos como errores.
- **Excluir** ficheros o carpetas (código generado, pruebas).
- **Suprimir** un caso concreto justificándolo: `@SuppressWarnings("java:S106")` o `// NOSONAR`.
- **Compartir** la configuración en el repositorio para que todo el equipo use la misma.
- Definir un ***quality gate***: condiciones que el código nuevo debe cumplir para poder fusionarse (cobertura ≥ 80 %, 0 *bugs* nuevos, duplicación < 3 %).

### Ejemplo: Checkstyle en Maven con reglas personalizadas

```xml title="pom.xml (plugin)"
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.6.0</version>
    <configuration>
        <configLocation>config/checkstyle.xml</configLocation>
        <failOnViolation>true</failOnViolation>
        <violationSeverity>warning</violationSeverity>
    </configuration>
</plugin>
```

```xml title="config/checkstyle.xml (fragmento)"
<module name="Checker">
  <module name="TreeWalker">
    <module name="MethodLength">
      <property name="max" value="30"/>
    </module>
    <module name="CyclomaticComplexity">
      <property name="max" value="8"/>
    </module>
    <module name="MagicNumber">
      <property name="ignoreNumbers" value="-1, 0, 1, 2"/>
    </module>
    <module name="LocalVariableName"/>
    <module name="UnusedImports"/>
  </module>
</module>
```

```bash
mvn checkstyle:check
```

!!! tip "El analizador propone, la persona decide"
    No todas las advertencias son problemas reales. Revisa cada una: si la corriges, aprendes la regla; si no la corriges, **justifica** por qué (y suprímela de forma explícita). Así se trabaja en los equipos profesionales.
