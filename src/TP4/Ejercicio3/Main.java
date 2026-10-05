package TP4.Ejercicio3;

import java.util.Scanner;
import util.Queue;
import util.ResizableQueue;

public class Main {

  public static void main(String[] args) {
    Queue<String> llamadas = new ResizableQueue<>();

    try (Scanner scanner = new Scanner(System.in)) {
      cargarLlamadas(scanner, llamadas);
    }

    Queue<String> cortos = new ResizableQueue<>();
    Queue<String> medianos = new ResizableQueue<>();
    Queue<String> largos = new ResizableQueue<>();

    clasificarLlamadas(llamadas, cortos, medianos, largos);

    System.out.println("\nCola original: " + llamadas);
    mostrarResultados("Nombres cortos (1 a 4 letras)", cortos);
    mostrarResultados("Nombres medianos (5 a 8 letras)", medianos);
    mostrarResultados("Nombres largos (9 o más letras)", largos);

    Queue<String> llamadasOrdenadas = new ResizableQueue<>();
    agregarElementos(cortos, llamadasOrdenadas);
    agregarElementos(medianos, llamadasOrdenadas);
    agregarElementos(largos, llamadasOrdenadas);

    System.out.println("\nCola unida (cortos, medianos y largos): " + llamadasOrdenadas);
  }

  private static void cargarLlamadas(Scanner scanner, Queue<String> llamadas) {
    System.out.println("Ingrese nombres de clientes, uno por línea. Escriba FIN para terminar.");

    while (scanner.hasNextLine()) {
      System.out.print("Nombre: ");
      String nombre = scanner.nextLine().trim();

      if (nombre.equalsIgnoreCase("FIN")) return;
      if (!esNombreValido(nombre)) {
        System.out.println("Ingrese un nombre no vacío formado solo por letras y espacios.");
        continue;
      }

      llamadas.add(nombre);
    }
  }

  private static boolean esNombreValido(String nombre) {
    if (nombre.isEmpty()) return false;

    for (int i = 0; i < nombre.length(); i++) {
      char caracter = nombre.charAt(i);
      if (!Character.isLetter(caracter) && !Character.isWhitespace(caracter)) return false;
    }
    return true;
  }

  private static void clasificarLlamadas(
      Queue<String> llamadas, Queue<String> cortos, Queue<String> medianos, Queue<String> largos) {
    for (Object elemento : llamadas.toArray()) {
      String nombre = (String) elemento;
      int cantidadLetras = contarLetras(nombre);

      if (cantidadLetras <= 4) cortos.add(nombre);
      else if (cantidadLetras <= 8) medianos.add(nombre);
      else largos.add(nombre);
    }
  }

  private static int contarLetras(String nombre) {
    int cantidad = 0;
    for (int i = 0; i < nombre.length(); i++) {
      if (Character.isLetter(nombre.charAt(i))) cantidad++;
    }
    return cantidad;
  }

  private static void mostrarResultados(String titulo, Queue<String> cola) {
    System.out.println("\n" + titulo + ": " + cola);
    System.out.println("Cantidad de llamadas: " + cola.size());

    String nombreMasLargo = buscarNombreMasLargo(cola);
    if (nombreMasLargo == null) {
      System.out.println("Nombre más largo: no hay clientes en esta cola.");
    } else {
      System.out.println("Nombre más largo: " + nombreMasLargo);
    }
  }

  private static String buscarNombreMasLargo(Queue<String> cola) {
    String nombreMasLargo = null;

    for (Object elemento : cola.toArray()) {
      String nombre = (String) elemento;
      if (nombreMasLargo == null || contarLetras(nombre) > contarLetras(nombreMasLargo)) {
        nombreMasLargo = nombre;
      }
    }
    return nombreMasLargo;
  }

  private static void agregarElementos(Queue<String> origen, Queue<String> destino) {
    for (Object elemento : origen.toArray()) {
      destino.add((String) elemento);
    }
  }

  /* 
    Respuestas sobre el problema:
    a) La cola original se conserva: toArray permite recorrerla sin desencolar elementos. poll() y remove() sí quitan el frente de la cola.
    b) Si una cola está vacía, se informa que no hay clientes y no se intenta buscar un nombre, evitando excepciones.
    c) Las tres colas originales se conservan y la cola unida recibe primero los cortos, luego los medianos y por último los largos. No hacen falta colas auxiliares para recorrerlas; sí se crea la cola destino.");
  */
}