package TP3.Ejercicio3.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String mensaje) {
        System.out.printf("%n%s ",mensaje);
        return scanner.nextLine();
    }

    public static int getInt(String mensaje) {
        int number;
        while(true) {
            try {
                System.out.printf("%n%s ",mensaje);
                number = scanner.nextInt();
                scanner.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("\nError: El valor ingresado no corresponde a un numero entero.");
                scanner.nextLine();
            }
        }
    }

    public static int getPositiveInt(String mensaje) {
      int number;
      while (true) {
        number = getInt(mensaje);

        if (number > 0) return number;
        System.out.println("\nERROR: El valor ingresado NO es positivo");
      }
    }

    public static double getDouble(String mensaje) {
        double number;
        while (true) {
            try {
                System.out.printf("%n%s ",mensaje);
                number = scanner.nextDouble();
                scanner.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("\nError: El valor ingresado no corresponde a un numero decimal.");
                scanner.nextLine();
            }
        }
    }
}
