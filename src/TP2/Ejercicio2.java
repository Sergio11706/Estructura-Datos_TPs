package TP2;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar cantidad de vuelos a gestionar: ");
        int cantidadVuelos = sc.nextInt();

        int[] vuelos = new int[cantidadVuelos];
        String[] estados = new String[cantidadVuelos];

        for (int i = 0; i < cantidadVuelos; i++) {
        System.out.println("Ingrese número de vuelo:");
        int numeroDeVuelo = sc.nextInt();
        sc.nextLine();

        System.out.println("Estado actual:");
        String estadoDelVuelo = sc.nextLine();

        vuelos[i] = numeroDeVuelo;
        estados[i] = estadoDelVuelo;
        }

        // Prueba funcion buscarNumeroDeVuelo()
        buscarNumeroDeVuelo(sc, vuelos, estados);

        // Prueba funcion cantidadVuelosEnEstadoX
        cantidadVuelosEnEstadoX(sc, vuelos, estados);

        //Reorganizar arreglos
        reorganizarArreglo(sc, vuelos, estados);

        sc.close();
    }

    public static void buscarNumeroDeVuelo(Scanner sc, int[] vuelos, String[] estados) {
        System.out.println("Ingresar número de vuelo a buscar:");
        int numero = sc.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] == numero) {
                System.out.println("Vuelo encontrado, su estado actual es: " + estados[i]
                        + ", su posición en el arreglo es: " + i);

                encontrado = true;

                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vuelo no encontrado");
        }

        presionarParaContinuar(sc);

    }

    public static void cantidadVuelosEnEstadoX(Scanner sc, int[] vuelos, String[] estados) {
        System.out.println("Ingresar estado de vuelo a buscar:");
        String buscar = sc.nextLine();

        int contador = 0;
        for (int i = 0; i < estados.length; i++) {
            if (estados[i].equals(buscar)) {
                contador += 1;
            }
        }

        System.out.println("La cantidad de vuelos en estado: " + buscar + ", es: " + contador);
        presionarParaContinuar(sc);
    }

    public static void numeroDeVuelosConEstadoX(Scanner sc, int[] vuelos, String[] estados) {
        System.out.println("Ingresar estado de vuelo a buscar:");
        String buscar = sc.nextLine();

        int[] numeroVuelos = new int[vuelos.length];
        int indiceAuxiliar = 0;

        for (int i = 0; i < estados.length; i++) {
            System.out.println(estados[i]);
            if (estados[i].equals(buscar)) {
                numeroVuelos[indiceAuxiliar] = vuelos[i];
                indiceAuxiliar++;
            }
        }

        System.out.println("Número de vuelos con estado:" + buscar + " es: " + Arrays.toString(numeroVuelos));
        presionarParaContinuar(sc);
    }

    public static void reorganizarArreglo(Scanner sc, int[] vuelos, String[] estados) {

        for (int i = 0; i < vuelos.length; i++) {
            if (estados[i].equals("Cancelado")) {
                int j = i + 1;

                while (j < estados.length && estados[j].equals("Cancelado")) {
                    j++;
                }

                if (j < estados.length) {
                    int auxNumero = vuelos[i];
                    vuelos[i] = vuelos[j];
                    vuelos[j] = auxNumero;

                    String auxEstado = estados[i];
                    estados[i] = estados[j];
                    estados[j] = auxEstado;
                }
            }
        }

        System.out.println(Arrays.toString(vuelos));
        System.out.println(Arrays.toString(estados));

        presionarParaContinuar(sc);
    }

    public static void presionarParaContinuar(Scanner sc) {
        sc.nextLine();
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }

}

// Datos de prueba
/*
    int[] numerosVuelo = {
    1234,
    4521,
    7812,
    3056,
    5678,
    9012,
    3456,
    7890,
    2468,
    1357,
    8642,
    9753,
    1122,
    3344,
    5566,
    7788,
    9900,
    1235,
    6789,
    4321
};

String[] estados = {
    "Programado",
    "En Vuelo",
    "Aterrizado",
    "Cancelado",
    "Programado",
    "Aterrizado",
    "En Vuelo",
    "Cancelado",
    "En Vuelo",
    "Programado",
    "Aterrizado",
    "Programado",
    "Cancelado",
    "En Vuelo",
    "Aterrizado",
    "Programado",
    "Cancelado",
    "Aterrizado",
    "En Vuelo",
    "Programado"
};
*/
