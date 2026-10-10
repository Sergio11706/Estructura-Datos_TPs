package TP4.Ejercicio7;

/**
 * Clase principal para el ejercicio 7 del TP4.
 * 
 * @author Sergio Acuña
 * 
 * Enunciado:
 *    Desarrollar un método estático que reciba una Cola de enteros y
 *    devuelva la cantidad de elementos que son números pares.
 *    
 *    - La cola original debe quedar sin modificaciones al finalizar el método.
 */

import util.*;

public class Main {
    /*SOLUCIÓN NO ELEGIDA (Solución B)
    public static int contarParesB(Queue<Integer> cola) {
        int contador = 0;
        int tamanioOriginal = cola.size();
        Queue<Integer> colaAuxiliar = new LinkedList<>();
 
        while (!cola.isEmpty()) {
            int num = cola.remove();
            if (num % 2 == 0) {
                contador++;
            }
            colaAuxiliar.add(num);
        }
 
        while (!colaAuxiliar.isEmpty()) {
            cola.add(colaAuxiliar.remove());
        }
 
        return contador;
    }
    */
    
    public static int contarPares(Queue<Integer> cola) {
        int contador = 0;
        int tamanioOriginal = cola.size();
        int[] arregloAuxiliar = new int[tamanioOriginal];
        int i = 0;
 
        while (!cola.isEmpty()) {
            int num = cola.remove();
            if (num % 2 == 0) {
                contador++;
            }
            arregloAuxiliar[i] = num;
            i++;
        }
 
        for (int j = 0; j < tamanioOriginal; j++) {
            cola.add(arregloAuxiliar[j]);
        }
 
        return contador;
    }
    
    public static void main(String[] args) {
        Queue<Integer> cola = new CountedQueue<>(5);
        cola.add(3);
        cola.add(8);
        cola.add(15);
        cola.add(4);
        cola.add(7);
 
        System.out.println("Cola original: " + cola);
 
        int pares = contarPares(cola);
 
        System.out.println("Cantidad de pares: " + pares);
        System.out.println("Cola luego del método (debe ser igual): " + cola);
    }

}
