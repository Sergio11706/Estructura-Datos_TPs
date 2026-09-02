package TP2.Ejercicio7;

public class Ejercicio7 {
    //Solución elegida: B
    /* Solución A:
    public static int[] obtenerParesA(int[] arr) {
        int[] nuevo = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                nuevo[j] = arr[i];
                j++;
            }
        }
        return nuevo;
    } */

    //Solución B:

    public static int[] obtenerParesB(int[] arr) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                contador++;
            }
        }
        int[] nuevo = new int[contador];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                nuevo[j] = arr[i];
                j++;
            }
        }
        return nuevo;
    }

}
