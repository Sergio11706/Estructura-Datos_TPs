package TP2.Ejercicio1;

import java.util.Scanner;
import java.util.random.RandomGenerator;

/**
 * Clase principal para el ejercicio 1 del TP2.
 * 
 * @author Sergio Acuña
 * 
 * Enunciado:
 *    Desarrollar un programa que solicite al usuario un valor entero N.
 *    - Generar N números aleatorios (entre -50 y 50) y cargarlos en un arreglo.
 *    - Luego el programa debe implementar:
 * 
 *      a) Un método que reciba el arreglo inicial y devuelva otro arreglo
 *         que contenga los elementos desplazados una posición hacia la izquierda
 *         (el primer elemento debe pasar a la última posición).
 * 
 *      b) Un método que calcule y muestre la suma de los números positivos
 *         y la suma de los números negativos por separado.
 * 
 *      c) Un método que invierta el orden de los elementos del arreglo original
 *         modificándolo directamente (sin crear un arreglo nuevo) y luego lo muestre.
 */


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar un numero hasta que sea mayor a 0
        int cantidadNumeros = 0;
        do{
            System.out.print("\nIngrese la cantidad de números a generar: ");
            cantidadNumeros = sc.nextInt();
        } while(cantidadNumeros<=0);

        System.err.println("\n**Arreglo generado**");
        int[] numeros = new int[cantidadNumeros];
        for(int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = RandomGenerator.getDefault().nextInt(-50, 50);
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\n\n**Arreglo desplazado una unidad a la izquierda**");
        int[] arregloDesplazado = arregloDesplazado(numeros);
        for(int i=0; i<arregloDesplazado.length; i++){
            System.out.print(arregloDesplazado[i] + " ");
        }

        int[] sumaPositivosNegativos = sumaPostivosYNegativos(numeros);
        System.out.println("\n\n**Suma de numeros positivos**");
        System.out.println(sumaPositivosNegativos[0]);

        System.out.println("\n**Suma de numeros negativos**");
        System.out.println(sumaPositivosNegativos[1]);

        invertirArreglo(numeros);
        System.out.println("\n**Arreglo invertido**");
        for(int i=0; i<numeros.length; i++){
            System.out.print(numeros[i] + " ");
        }

        sc.close();
    }

    private static int[] arregloDesplazado(int[] numeros) {
        int[] arregloDesplazado = new int[numeros.length];
        
        for (int i = 0; i < numeros.length; i++) {
            if (i == numeros.length - 1) { //Si es el ultimo elemento debe pasar a la primera posicion
                arregloDesplazado[i] = numeros[0];
            } else {
                arregloDesplazado[i] = numeros[i + 1];
            }
        }

        return arregloDesplazado;
    }


    private static int[] sumaPostivosYNegativos(int[] numeros){
        int[] sumaPositivosNegativos = new int[2]; 

        sumaPositivosNegativos[0]=0; // 0: Positivos
        sumaPositivosNegativos[1]=0; // 1: Negativos

        for(int i=0; i<numeros.length; i++){
            if(numeros[i]>0){
                sumaPositivosNegativos[0]+=numeros[i];
            }
            else{
                sumaPositivosNegativos[1]+=numeros[i];
            }
        }

        return sumaPositivosNegativos;
    }    

    private static void invertirArreglo(int[] numeros){
        int aux=0, j=numeros.length-1;
        for(int i=0; i<numeros.length/2; i++){
            aux=numeros[j]; // El auxiliar guarda el valor para no perderlo
            numeros[j]=numeros[i];
            numeros[i]=aux;
            j--;
        }

    }
}
