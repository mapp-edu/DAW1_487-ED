package es.daw.ed;

import java.util.List;

/**
 * Versión de Notas con DOS defectos introducidos, para la tarea T4.3.
 * Copia esta clase en tu proyecto (sustituyendo a la tuya) y deja que tus pruebas los encuentren.
 *
 * Especificación:
 *  - calificar(nota): [0,5) Suspenso, [5,7) Aprobado, [7,9) Notable, [9,10] Sobresaliente;
 *    IllegalArgumentException si la nota está fuera de [0,10].
 *  - media(notas): media aritmética; IllegalArgumentException si la lista es null o está vacía.
 */
public class Notas {

    public static String calificar(double nota) {
        if (nota < 0) {
            throw new IllegalArgumentException("Nota fuera de rango: " + nota);
        }
        if (nota <= 5) {
            return "Suspenso";
        } else if (nota < 7) {
            return "Aprobado";
        } else if (nota < 9) {
            return "Notable";
        }
        return "Sobresaliente";
    }

    public static double media(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }
}
