package TP2.Ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

class Equipo {
    private int idEquipo;
    private String nombre;
    private int puntajeAcumulado;
    private int partidosJugados;

    public Equipo(int idEquipo, String nombre, int puntajeAcumulado, int partidosJugados) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.puntajeAcumulado = puntajeAcumulado;
        this.partidosJugados = partidosJugados;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    public void sumarPuntaje(int puntos) {
        this.puntajeAcumulado += puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    @Override
    public String toString() {
        return "ID: " + idEquipo + " | Nombre: " + nombre + " | Puntos: " + puntajeAcumulado + " | Partidos: " + partidosJugados;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE GESTIÓN DE LIGA ===");
        int cantidadEquipos = leerEntero(scanner, "Ingrese la cantidad de equipos a gestionar: ");
        while (cantidadEquipos <= 0) {
            System.out.println("Error: La cantidad debe ser mayor a 0.");
            cantidadEquipos = leerEntero(scanner, "Ingrese la cantidad de equipos a gestionar: ");
        }

        Equipo[] liga = new Equipo[cantidadEquipos];

        for (int i = 0; i < liga.length; i++) {
            System.out.println("\n--- Ingresando datos del equipo " + (i + 1) + " ---");
            int id = leerEntero(scanner, "ID del equipo: ");
            String nombre = leerString(scanner, "Nombre del equipo: ");
            int puntaje = leerEntero(scanner, "Puntaje acumulado: ");
            int partidos = leerEntero(scanner, "Partidos jugados: ");
            
            liga[i] = new Equipo(id, nombre, puntaje, partidos);
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Actualizar puntaje de un equipo");
            System.out.println("2. Total de partidos jugados en la liga");
            System.out.println("3. Promedio general de puntajes");
            System.out.println("4. Mostrar el equipo líder");
            System.out.println("5. Listar equipos en zona de descenso");
            System.out.println("6. Mostrar todos los equipos");
            System.out.println("7. Salir");
            
            int opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    int idBuscar = leerEntero(scanner, "Ingrese el ID del equipo a actualizar: ");
                    int puntosSumar = leerEntero(scanner, "Ingrese los puntos a sumar: ");
                    actualizarPuntaje(liga, idBuscar, puntosSumar);
                    break;
                case 2:
                    int totalPartidos = calcularTotalPartidos(liga);
                    System.out.println("Total de partidos jugados entre todos los equipos: " + totalPartidos);
                    break;
                case 3:
                    double promedio = calcularPromedio(liga);
                    System.out.printf("El promedio general de puntajes es: %.2f\n", promedio);
                    break;
                case 4:
                    puntero(liga); // ¡Aquí actualizamos el nombre de tu función!
                    break;
                case 5:
                    mostrarZonaDescenso(liga);
                    break;
                case 6:
                    mostrarTodos(liga);
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void actualizarPuntaje(Equipo[] liga, int idEquipo, int puntosSumar) {
        for (Equipo eq : liga) {
            if (eq.getIdEquipo() == idEquipo) {
                eq.sumarPuntaje(puntosSumar);
                System.out.println("Puntaje actualizado con éxito. Nuevo puntaje: " + eq.getPuntajeAcumulado());
                return;
            }
        }
        System.out.println("Error: No se encontró ningún equipo con el ID " + idEquipo);
    }

    private static int calcularTotalPartidos(Equipo[] liga) {
        int total = 0;
        for (Equipo eq : liga) {
            total += eq.getPartidosJugados();
        }
        return total;
    }

    private static double calcularPromedio(Equipo[] liga) {
        if (liga.length == 0) return 0;
        double sumaTotal = 0;
        for (Equipo eq : liga) {
            sumaTotal += eq.getPuntajeAcumulado();
        }
        return sumaTotal / liga.length;
    }

    private static void puntero(Equipo[] liga) {
        if (liga.length == 0) return;
        
        Equipo lider = liga[0];
        for (int i = 1; i < liga.length; i++) {
            if (liga[i].getPuntajeAcumulado() > lider.getPuntajeAcumulado()) {
                lider = liga[i];
            }
        }
        System.out.println("El equipo líder es:");
        System.out.println(lider.toString());
    }

    // e) Listar equipos con puntaje inferior al promedio
    private static void mostrarZonaDescenso(Equipo[] liga) {
        double promedio = calcularPromedio(liga);
        System.out.printf("Promedio actual: %.2f\n", promedio);
        System.out.println("Equipos en zona de descenso:");
        
        boolean hayDescenso = false;
        for (Equipo eq : liga) {
            if (eq.getPuntajeAcumulado() < promedio) {
                System.out.println("- " + eq.getNombre() + " (Puntos: " + eq.getPuntajeAcumulado() + ")");
                hayDescenso = true;
            }
        }
        
        if (!hayDescenso) {
            System.out.println("No hay ningún equipo en zona de descenso en este momento.");
        }
    }

    private static void mostrarTodos(Equipo[] liga) {
        for (Equipo eq : liga) {
            System.out.println(eq.toString());
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un valor numérico entero válido.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    private static String leerString(Scanner scanner, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        }
        return texto;
    }
}