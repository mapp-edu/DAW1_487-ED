import java.util.Scanner;

public class NotasEstructurado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n1 = pedirNota(sc, 1);
        double n2 = pedirNota(sc, 2);
        double n3 = pedirNota(sc, 3);

        double media = calcularMedia(n1, n2, n3);
        double max = calcularMaximo(n1, n2, n3);
        double min = calcularMinimo(n1, n2, n3);

        mostrarResultados(media, max, min);

        sc.close();
    }

    static double pedirNota(Scanner sc, int numNota) {
        System.out.print("Introduce la nota " + numNota + ": ");
        return sc.nextDouble();
    }

    static double calcularMedia(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    static double calcularMaximo(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    static double calcularMinimo(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    static void mostrarResultados(double media, double max, double min) {
        System.out.println("La media es: " + media);
        System.out.println("La nota máxima es: " + max);
        System.out.println("La nota mínima es: " + min);

        if (media >= 5) {
            System.out.println("El alumno ha aprobado.");
        } else {
            System.out.println("El alumno ha suspendido.");
        }
    }
}
