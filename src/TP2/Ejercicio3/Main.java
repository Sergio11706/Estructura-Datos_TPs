package TP2.Ejercicio3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //Carga de caracteres

    public static ArrayList<Character> cargarCaracteres(Scanner scanner) {
        ArrayList<Character> caracteres = new ArrayList<>();

        System.out.println("Ingrese caracteres uno por uno");
        System.out.println("Para finalizar escriba FIN");

        while (true) {
            System.out.print("Ingrese un carácter: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("FIN")) {
                break;
            }

            if (entrada.length() != 1) {
                System.out.println("Se debe ingresar un solo carácter");
            } else {
                caracteres.add(entrada.charAt(0));
            }
        }

        return caracteres;
    }

    // PUNTO A

    public static void mostrarDuplicados(ArrayList<Character> caracteres) {

        ArrayList<Character> duplicados = new ArrayList<>();

        for (int i = 0; i < caracteres.size(); i++) {

            char actual = caracteres.get(i);
            int cantidad = 0;

            for (int j = 0; j < caracteres.size(); j++) {

                if (Character.toLowerCase(actual) == Character.toLowerCase(caracteres.get(j))) {

                    cantidad++;
                }
            }

            if (cantidad > 1) {

                boolean yaAgregado = false;

                for (char duplicado : duplicados) {
                    if (Character.toLowerCase(duplicado) == Character.toLowerCase(actual)) {

                        yaAgregado = true;
                    }
                }

                if (!yaAgregado) {
                    duplicados.add(actual);
                }
            }
        }

        System.out.println("\nCantidad de caracteres duplicados: " + duplicados.size());

        System.out.println("Caracteres duplicados:");

        for (char caracter : duplicados) {
            System.out.println(caracter);
        }
    }

    // PUNTO B

    public static void buscarVocalYConsonante(ArrayList<Character> caracteres) {

        int primeraVocal = -1;
        int ultimaConsonante = -1;

        for (int i = 0; i < caracteres.size(); i++) {

            char caracter = caracteres.get(i);

            if (primeraVocal == -1 && esVocal(caracter)) {
                primeraVocal = i;
            }

            if (esConsonante(caracter)) {
                ultimaConsonante = i;
            }
        }

        if (primeraVocal != -1) {
            System.out.println(
                    "\nPosición de la primera vocal: " + primeraVocal);
        } else {
            System.out.println("\nNo se encontró ninguna vocal.");
        }

        if (ultimaConsonante != -1) {
            System.out.println(
                    "Posición de la última consonante: "
                    + ultimaConsonante);
        } else {
            System.out.println("No se encontró ninguna consonante.");
        }
    }

    //Modulos para chekear si es vocal o consonante

    public static boolean esVocal(char caracter) {

        char c = Character.toLowerCase(caracter);

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    public static boolean esConsonante(char caracter) {

        char c = Character.toLowerCase(caracter);

        return Character.isLetter(c) && !esVocal(c);
    }

    //Punto C

    public static ArrayList<Character> obtenerDigitos(ArrayList<Character> caracteres) {

        ArrayList<Character> digitos = new ArrayList<>();

        for (char caracter : caracteres) {

            if (Character.isDigit(caracter)) {
                digitos.add(caracter);
            }
        }

        return digitos;
    }

    //Punto D

    public static void intercambiarCaracteres(
            ArrayList<Character> caracteres) {

        int primeraMayuscula = -1;
        int ultimoSimbolo = -1;

        // Buscar la primera mayúscula
        for (int i = 0; i < caracteres.size(); i++) {

            if (Character.isUpperCase(caracteres.get(i))) {
                primeraMayuscula = i;
                break;
            }
        }

        // Buscar el último símbolo
        for (int i = 0; i < caracteres.size(); i++) {

            char caracter = caracteres.get(i);

            if (!Character.isLetterOrDigit(caracter)) {
                ultimoSimbolo = i;
            }
        }

        Random random = new Random();

        // Si no hay mayúscula, generar posición aleatoria
        if (primeraMayuscula == -1) {

            primeraMayuscula =
                    random.nextInt(caracteres.size());
        }

        // Si no hay símbolo, generar posición aleatoria
        if (ultimoSimbolo == -1) {

            ultimoSimbolo =
                    random.nextInt(caracteres.size());
        }

        // Intercambio usando variable auxiliar
        char aux = caracteres.get(primeraMayuscula);

        caracteres.set(
                primeraMayuscula,
                caracteres.get(ultimoSimbolo));

        caracteres.set(
                ultimoSimbolo,
                aux);
    }

    //Mostrar nuevos arreglos para puntos c y d

    public static void mostrarArreglo(
            ArrayList<Character> caracteres) {

        System.out.print("[");

        for (int i = 0; i < caracteres.size(); i++) {

            System.out.print(caracteres.get(i));

            if (i < caracteres.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    //Main

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Character> caracteres =
                cargarCaracteres(scanner);

        System.out.println("\nARREGLO CARGADO:");
        mostrarArreglo(caracteres);

        // Si el arreglo está vacío
        if (caracteres.isEmpty()) {

            System.out.println(
                    "\nEl arreglo está vacío. "
                    + "No se pueden realizar las operaciones.");

        } else {

            // Punto A
            mostrarDuplicados(caracteres);

            // Punto B
            buscarVocalYConsonante(caracteres);

            // Punto C
            ArrayList<Character> digitos =
                    obtenerDigitos(caracteres);

            System.out.println(
                    "\nArreglo de dígitos:");

            mostrarArreglo(digitos);

            // Punto D
            intercambiarCaracteres(caracteres);

            System.out.println(
                    "\nArreglo después del intercambio:");

            mostrarArreglo(caracteres);
        }

        scanner.close();
    }
}