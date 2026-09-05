package TP2.Ejercicio6;
import java.util.Scanner;

public class Main {

    // CARGA DE LA MATRIZ
    public static double[][] cargarMatriz(Scanner scanner, int vendedores, int dias) {
        double[][] ventas = new double[vendedores][dias];
        for (int i = 0; i < vendedores; i++) {
            System.out.println("\nVendedor " + (i+1));
            for (int j = 0; j < dias; j++) {
                System.out.print("Ingrese venta del dia " + (j+1) + ": ");
                ventas[i][j] = scanner.nextDouble();
                while (ventas[i][j] < 0) {
                    System.out.print("El monto no puede ser negativo. Ingrese nuevamente: ");
                    ventas[i][j] = scanner.nextDouble();
                }
            }
        }
        return ventas;
    }

    // a) TOTAL POR VENDEDOR
    public static void mostrarTotalPorVendedor(double[][] ventas) {
        System.out.println("\nTOTAL DE VENTAS POR VENDEDOR:");
        for (int i = 0; i < ventas.length; i++) {
            double total = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                total = total + ventas[i][j];
            }
            System.out.println("Vendedor " + (i+1) + ": $" + total);
        }
    }

    // b) PROMEDIO POR DiA
    public static void mostrarPromedioDias(double[][] ventas) {
        System.out.println("\nPROMEDIO DE VENTAS POR DiA:");
        for (int j = 0; j < ventas[0].length; j++) {
            double total = 0;
            for (int i = 0; i < ventas.length; i++) {
                total = total + ventas[i][j];
            }
            double promedio = total / ventas.length;
            System.out.println("Dia " + (j+1) + ": $" + promedio);
        }
    }

    // c) MAYOR Y MENOR VENTA
    public static void mostrarMayorYMenor(double[][] ventas) {
        double mayor = ventas[0][0];
        double menor = ventas[0][0];
        int filaMayor = 0;
        int columnaMayor = 0;
        int filaMenor = 0;
        int columnaMenor = 0;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (ventas[i][j] > mayor) {
                    mayor = ventas[i][j];
                    filaMayor = i;
                    columnaMayor = j;
                }
                if (ventas[i][j] < menor) {
                    menor = ventas[i][j];
                    filaMenor = i;
                    columnaMenor = j;
                }
            }
        }
        System.out.println("\nVENTA DE MAYOR MONTO:");
        System.out.println("Monto: $" + mayor);
        System.out.println("Vendedor: " + (filaMayor + 1));
        System.out.println("Dia: " + (columnaMayor + 1));
        System.out.println("\nVENTA DE MENOR MONTO:");
        System.out.println("Monto: $" + menor);
        System.out.println("Vendedor: " + (filaMenor + 1));
        System.out.println("Dia: " + (columnaMenor + 1));
    }

    // d) VENDEDORES QUE SUPERAN EL OBJETIVO
    public static int vendedoresQueSuperanObjetivo(double[][] ventas, double objetivo) {
        int cantidad = 0;
        for (int i = 0; i < ventas.length; i++) {
            double total = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                total = total + ventas[i][j];
            }
            if (total > objetivo) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // e) VENTAS QUE SUPERAN EL PROMEDIO DEL DiA
    public static int ventasSuperanPromedio(double[][] ventas, int dia) {
        double total = 0;

        // Calcular total del dia
        for (int i = 0; i < ventas.length; i++) {
            total = total + ventas[i][dia];
        }
        double promedio = total / ventas.length;
        int cantidad = 0;

        // Contar ventas que superan el promedio
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i][dia] > promedio) {
                cantidad++;
            }
        }

        System.out.println("Promedio del dia " + (dia + 1) + ": $" + promedio);
        return cantidad;
    }

    // f) PROMEDIO DE CADA VENDEDOR
    public static double[] promedioVendedores(double[][] ventas) {
        double[] promedios = new double[ventas.length];
        for (int i = 0; i < ventas.length; i++) {
            double total = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                total = total + ventas[i][j];
            }
            promedios[i] = total / ventas[i].length;
        }
        return promedios;
    }

    // MOSTRAR MATRIZ
    public static void mostrarMatriz(double[][] ventas) {
        System.out.println("\nMATRIZ DE VENTAS:");
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.print(ventas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // PROGRAMA PRINCIPAL
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar cantidad de vendedores
        System.out.print("Ingrese cantidad de vendedores: ");
        int vendedores = scanner.nextInt();

        while (vendedores <= 0) {
            System.out.print("Debe ser mayor a 0. Ingrese nuevamente: ");
            vendedores = scanner.nextInt();
        }

        // Ingresar cantidad de dias
        System.out.print("Ingrese cantidad de dias: ");
        int dias = scanner.nextInt();

        while (dias <= 0) {
            System.out.print("Debe ser mayor a 0. Ingrese nuevamente: ");
            dias = scanner.nextInt();
        }

        // Cargar matriz
        double[][] ventas = cargarMatriz(scanner, vendedores, dias);
        mostrarMatriz(ventas);

        // a) Total por vendedor
        mostrarTotalPorVendedor(ventas);

        // b) Promedio por dia
        mostrarPromedioDias(ventas);

        // c) Mayor y menor venta
        mostrarMayorYMenor(ventas);

        // d) Objetivo
        System.out.print("\nIngrese el monto objetivo: ");
        double objetivo = scanner.nextDouble();
        while (objetivo < 0) {
            System.out.print("El monto objetivo no puede ser negativo. Ingrese nuevamente: ");
            objetivo = scanner.nextDouble();
        }
        int cantidadObjetivo = vendedoresQueSuperanObjetivo(ventas, objetivo);
        System.out.println("Cantidad de vendedores que superan el objetivo: " + cantidadObjetivo);

        // e) Dia especifico
        System.out.print("\nIngrese el dia que desea consultar: ");
        int dia = scanner.nextInt()-1;
        while (dia < 0 || dia >= dias) {
            System.out.print("Dia invalido. Ingrese nuevamente: ");
            dia = scanner.nextInt()-1;
        }
        int cantidadSuperan = ventasSuperanPromedio(ventas, dia);
        System.out.println("Cantidad de ventas que superan el promedio: "+ cantidadSuperan);

        // f) Promedio de cada vendedor
        double[] promedios = promedioVendedores(ventas);
        System.out.println("\nPROMEDIO DE CADA VENDEDOR:");
        for (int i = 0; i < promedios.length; i++) {
            System.out.println("Vendedor " + (i + 1) + ": $" + promedios[i]);
        }
        scanner.close();
    }
}