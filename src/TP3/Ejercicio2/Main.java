package TP3.Ejercicio2;

/**
 * Clase principal para el ejercicio 2 del TP4.
 * 
 * @author Sergio Acuña
 * 
 * Enunciado:
 *    Dado un arreglo de números enteros, se desea invertir únicamente
 *    los números que son múltiplos de 3.
 *    
 *    - Para realizar la inversión se debe utilizar una pila.
 *    - El resto de los elementos del arreglo deben mantenerse sin modificaciones.
 */


import TP3.common.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos a generar: ");
        int n = sc.nextInt();
        while(n <= 0) {
            System.out.print("\nPor favor, ingrese un número mayor a cero: ");
            n = sc.nextInt();
        }

        int[] arreglo = new int[n];
        for(int i=0; i<n; i++) {
            System.out.print("\nIngrese el °"+(i+1)+" elemento del arreglo: ");
            arreglo[i] = sc.nextInt();
        }

        System.out.println("\n***Arreglo original***");
        System.out.print("[ ");
        for(int i=0; i<n; i++){
            System.out.print(arreglo[i]+" ");
        }
        System.out.println("]");

        invertirMultiplosDeTres(arreglo);

        System.out.println("\n***Arreglo con los multiplos de 3 invertidos***");
        System.out.print("[ ");
        for(int i=0; i<n; i++){
            System.out.print(arreglo[i]+" ");
        }
        System.out.println("]");

        sc.close();

    }

    private static void invertirMultiplosDeTres(int[] arreglo) {
        Stack<Integer> pila = new Stack<>();

        for(int i=0; i<arreglo.length; i++){
            if(arreglo[i]%3==0)
                pila.push(arreglo[i]);
        }

        for(int i=0; i<arreglo.length; i++){
            if(arreglo[i]%3==0){
                arreglo[i]=pila.pop();
            }
        }

    }
}
