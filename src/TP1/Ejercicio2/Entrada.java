package TP1.Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static String cadena(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextLine();
    }

    public static int entero(String mensaje) {
        int numero;
        while(true) {
            try {
                System.out.print(mensaje + " ");
                numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no corresponde a un numero entero.");
                scanner.nextLine();
            }
        }
    }

    public static double decimal(String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.print(mensaje + " ");
                numero = scanner.nextDouble();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no corresponde a un numero decimal.");
                scanner.nextLine();
            }
        }
    }
}
