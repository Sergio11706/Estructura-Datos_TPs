package TP2;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Ingresar cantidad de vuelos a gestionar: ");
        // int cantidadVuelos = sc.nextInt();
        //int cantidadVuelos = 3;

        int[] vuelos = { 101, 205, 310, 415, 520 };

        String[] estadoVuelos = {
                "Programado",
                "En Vuelo",
                "Cancelado",
                "Aterrizado",
                "Programado"
        };
        // int[] vuelos = new int[cantidadVuelos];
        // String[] estadoVuelos = new String[cantidadVuelos];

        // for (int i = 0; i < cantidadVuelos; i++) {
        // System.out.println("Ingrese número de vuelo:");
        // int numeroDeVuelo = sc.nextInt();
        // sc.nextLine();

        // System.out.println("Estado actual:");
        // String estadoDelVuelo = sc.nextLine();

        // vuelos[i] = numeroDeVuelo;
        // estadoVuelos[i] = estadoDelVuelo;
        // }

        System.out.println();
        // System.out.println(Arrays.toString(vuelos));
        System.out.println(Arrays.toString(estadoVuelos));

        cantidadVuelosEnEstadoX(sc, estadoVuelos, vuelos);

        sc.close();
    }

    public static void cantidadVuelosEnEstadoX(Scanner sc, String[] estadoVuelos, int[] numeroVuelos) {
        System.out.println("Ingresar estado de vuelo a buscar:");
        String estadoVueloABuscar = sc.nextLine();
        int contador = 0;
        for (int i = 0; i < estadoVuelos.length; i++) {
            System.out.println(estadoVuelos[i]);
            if (estadoVuelos[i].equals(estadoVueloABuscar)) {
                contador += 1;
            }
        }

        System.out.println("La cantidad de vuelos en estado: " + estadoVueloABuscar + ", es: " + contador);

        numeroDeVuelosConEstadoX(sc, estadoVuelos, numeroVuelos, contador);
    }

    public static void numeroDeVuelosConEstadoX(Scanner sc, String[] estadoVuelos, int[] numeroVuelos, int cantidad) {
        System.out.println("Ingresar estado de vuelo a buscar:");
        String estadoVueloABuscar = sc.nextLine();
        int[] numeroVuelosConEstadoX = new int[cantidad];
        int indiceAuxiliar = 0;
        for (int i = 0; i < estadoVuelos.length; i++) {
            System.out.println(estadoVuelos[i]);
            if (estadoVuelos[i].equals(estadoVueloABuscar)) {
                numeroVuelosConEstadoX[indiceAuxiliar] = numeroVuelos[i];
                indiceAuxiliar++;
            }
        }

        System.out.println("Número de vuelos con un estado especifico es: " + Arrays.toString(numeroVuelosConEstadoX));
    }

}
