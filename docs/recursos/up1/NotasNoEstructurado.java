import java.util.Scanner;

public class NotasNoEstructurado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la nota 1: ");
        double n1 = sc.nextDouble();

        System.out.print("Introduce la nota 2: ");
        double n2 = sc.nextDouble();

        System.out.print("Introduce la nota 3: ");
        double n3 = sc.nextDouble();

        // Media
        double media = (n1 + n2 + n3) / 3;
        System.out.println("La media es: " + media);

        // Máxima
        double max = n1;
        if (n2 > max) max = n2;
        if (n3 > max) max = n3;
        System.out.println("La nota máxima es: " + max);

        // Mínima
        double min = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;
        System.out.println("La nota mínima es: " + min);

        // Aprobado o suspenso
        if (media >= 5) {
            System.out.println("El alumno ha aprobado.");
        } else {
            System.out.println("El alumno ha suspendido.");
        }

        sc.close();
    }
}
