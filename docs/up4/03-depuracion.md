# 3. Depuración en el IDE

El compilador detecta los **errores de compilación** (sintaxis y tipos). Los **errores lógicos** (el programa compila pero hace algo distinto de lo esperado) hay que encontrarlos ejecutando el programa de forma controlada con el **depurador**.

## Herramientas del depurador

| Herramienta | Para qué |
|-------------|----------|
| **Punto de ruptura** (*breakpoint*) | Detener la ejecución en una línea |
| **Punto de ruptura condicional** | Detenerse solo si se cumple una expresión (`i == 3`) |
| **Punto de ruptura de excepción** | Detenerse cuando se lanza una excepción (por ejemplo, `NullPointerException`) |
| ***Logpoint*** / punto no suspensivo | Escribir un mensaje en la consola sin detenerse (sustituye a los `println` de depuración) |
| **Step Over** | Ejecutar la línea actual sin entrar en los métodos que llama |
| **Step Into** | Entrar en el método llamado |
| **Step Out** | Terminar el método actual y volver al que lo llamó |
| **Run to Cursor** | Continuar hasta la línea del cursor |
| **Resume** | Continuar hasta el siguiente punto de ruptura |
| **Variables** | Ver el valor de las variables locales y de los atributos |
| **Watches** | Vigilar expresiones elegidas |
| **Evaluate Expression** | Calcular cualquier expresión en el contexto actual |
| **Set Value** | **Modificar** el valor de una variable en tiempo de ejecución |
| **Call Stack** (pila de llamadas) | Ver la cadena de llamadas que ha llevado hasta el punto actual |

## Atajos

| Acción | IntelliJ IDEA | VS Code |
|--------|:-------------:|:-------:|
| Poner o quitar un punto de ruptura | ++ctrl+f8++ o clic en el margen | ++f9++ o clic en el margen |
| Iniciar la depuración | ++shift+f9++ | ++f5++ |
| Step Over | ++f8++ | ++f10++ |
| Step Into | ++f7++ | ++f11++ |
| Step Out | ++shift+f8++ | ++shift+f11++ |
| Resume | ++f9++ | ++f5++ |
| Evaluar una expresión | ++alt+f8++ | Consola de depuración |
| Condición del punto de ruptura | Clic derecho en el punto | Clic derecho → *Edit Condition* |

## Práctica guiada: `LlenarNumeros`

*Adaptada de la práctica «Debugger con VS Code» del curso 2025-26.*

```java title="LlenarNumeros.java" linenums="1"
public class LlenarNumeros {
    public static void main(String[] args) {
        int n = 5;
        int[] tabla = llenar(n);
        int suma = sumar(tabla);
        System.out.println("La suma es: " + suma);
    }

    private static int[] llenar(int n) {
        int[] tabla = new int[n];
        for (int i = 0; i < n; i++)
            tabla[i] = i * 10;
        return tabla;
    }

    public static int sumar(int[] tabla) {
        int suma = 0;
        for (int i = 0; i < tabla.length; i++)
            suma = suma + tabla[i];
        return suma;
    }
}
```

1. Pon un punto de ruptura en la línea 12 (`tabla[i] = i * 10;`) e inicia la depuración. Observa en *Variables* cómo cambian `i` y `tabla` en cada iteración (**Resume**).
2. Convierte ese punto de ruptura en **condicional** con `i == 3`. Reinicia la depuración: ahora solo se detiene una vez.
3. Detenido en `i == 3`, **modifica** `tabla[2]` a `1000` (*Set Value*). Continúa y comprueba que la suma final ha cambiado: has alterado el comportamiento del programa en tiempo de ejecución.
4. Pon un punto de ruptura en la línea 5 y usa **Step Into** para entrar en `sumar`. Observa la **pila de llamadas** (`main` → `sumar`).
5. Añade un *watch* con la expresión `suma / (i + 1)` dentro de `sumar`.
6. Provoca un error: cambia la condición del bucle de `sumar` a `i <= tabla.length`. Añade un **punto de ruptura de excepción** para `ArrayIndexOutOfBoundsException` y localiza el defecto.

!!! tip "Depurar las pruebas"
    Cualquier prueba de JUnit se puede lanzar en modo depuración (icono del insecto junto al método). Es la forma más rápida de entender por qué falla una prueba.
