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
