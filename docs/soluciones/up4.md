# UP4 · Soluciones

## T4.1 · Errores de `EstadisticasNotas.java`

| # | Método | Defecto | Síntoma | Cómo localizarlo con el depurador |
|:-:|--------|---------|---------|-----------------------------------|
| 1 | `sumar` | El bucle empieza en `i = 1`: no suma la primera nota | Media 4,83 en lugar de 6,0 | Punto de ruptura en `suma += notas[i]` y observar que `i` nunca vale 0. Modificar `suma` a 7.0 en la primera parada y comprobar que la media pasa a 6,0. |
| 2 | `maxima` | La comparación es `<` en lugar de `>` | Máxima 2,0 en lugar de 9,5 | Punto de ruptura condicional `notas[i] == 9.5` y comprobar que no se actualiza `max`. |
| 3 | `contarAprobados` | `n > 5` en lugar de `n >= 5` | 3 aprobados en lugar de 4 | Punto de ruptura condicional `n == 5.0` y evaluar la condición del `if`. |

## T4.3 · Defectos de `defectos/Notas.java`

| # | Defecto | Prueba que lo detecta | Severidad / prioridad sugeridas |
|:-:|---------|-----------------------|---------------------------------|
| 1 | `nota <= 5` en lugar de `nota < 5`: un 5 se califica como «Suspenso» | Valor límite `calificar(5)` → «Aprobado» | Alta / alta (afecta directamente a la nota del alumno) |
| 2 | No se valida el límite superior: `calificar(10.01)` devuelve «Sobresaliente» en vez de lanzar `IllegalArgumentException` | Clase de equivalencia no válida `nota > 10` | Media / media |

## T4.2 · Complejidad ciclomática de `calcularPrecio`

La complejidad depende de la implementación del alumnado. Con una implementación típica (validación de la base, validación de la edad con `||`, descuento por edad con `||` y descuento de socio), V(G) = 5 si se cuentan las decisiones y 7 si se desdoblan las condiciones compuestas. Lo importante es que el cálculo sea coherente con su grafo.
