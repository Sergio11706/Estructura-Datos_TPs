package TP2.Ejercicio1;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números a generar: ");
        int cantidadNumeros = sc.nextInt();
        int[] numeros = new int[cantidadNumeros];
        for(int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = RandomGenerator.getDefault().nextInt(-50, 50);
            System.out.println("Número generado: " + numeros[i]);
        }

        sc.close();
    }
    
}
