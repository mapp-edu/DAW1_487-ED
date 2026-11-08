/**
 * Programa para la tarea T4.1 (depuración).
 * Contiene TRES errores lógicos: compila y se ejecuta, pero los resultados no son correctos.
 * Localízalos con el depurador, sin añadir println.
 *
 * Salida esperada con las notas de ejemplo:
 *   Media: 6.0   Máxima: 9.5   Mínima: 2.0   Aprobados: 4
 */
public class EstadisticasNotas {

    public static void main(String[] args) {
        double[] notas = {7.0, 5.0, 2.0, 9.5, 4.5, 8.0};
        System.out.println("Media: " + media(notas)
                + "   Máxima: " + maxima(notas)
                + "   Mínima: " + minima(notas)
                + "   Aprobados: " + contarAprobados(notas));
    }

    static double sumar(double[] notas) {
        double suma = 0;
        for (int i = 1; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma;
    }

    static double media(double[] notas) {
        return sumar(notas) / notas.length;
    }

    static double maxima(double[] notas) {
        double max = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < max) {
                max = notas[i];
            }
        }
        return max;
    }

    static double minima(double[] notas) {
        double min = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < min) {
                min = notas[i];
            }
        }
        return min;
    }

    static int contarAprobados(double[] notas) {
        int aprobados = 0;
        for (double n : notas) {
            if (n > 5) {
                aprobados++;
            }
        }
        return aprobados;
    }
}
