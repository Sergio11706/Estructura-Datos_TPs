package TP1.Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cilindro cilindro = new Cilindro();

        double radio = pedirDato(scanner, "Ingrese el radio");
        double altura = pedirDato(scanner, "Ingrese la altura");

        cilindro.setRadio(radio);
        cilindro.setAltura(altura);

        System.out.println("El volumen es: " + String.format("%.2f", cilindro.calcularVolumen()));
        System.out.println("El área de superficie es: " + String.format("%.2f", cilindro.calcularAreaSuperficie()));

        scanner.close();
    }

    public static double pedirDato(Scanner scanner, String mensaje) {
        double dato = 0;
        boolean esValido = false;

        while (!esValido) {
            System.out.print(mensaje);
            try {
                dato = scanner.nextDouble();

                if (dato > 0) {
                    esValido = true;
                } else {
                    System.out.println("Un cilindro no puede tener radio ni altura negativos o cero. Por favor, ingrese un valor positivo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }

        return dato;
    }
}