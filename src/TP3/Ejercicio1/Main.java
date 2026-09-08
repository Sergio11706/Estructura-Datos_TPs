package TP3.Ejercicio1;

import TP3.common.Stack;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidad = pedirEnteroPositivo(scanner, "Ingrese la cantidad de números a generar (recomendado 15): ", 15);
        int minRango = -20;
        int maxRango = 20;

        Stack<Integer> pilaOriginal = generarPilaAleatoria(cantidad, minRango, maxRango);
        
        System.out.println("\n--- Pila Original Inicial ---");
        System.out.println("Cima -> Base: " + pilaOriginal);

        Stack<Integer> positivos = new Stack<>();
        Stack<Integer> negativos = new Stack<>();
        
        separarYRestaurar(pilaOriginal, positivos, negativos);

        System.out.println("\n--- Pila de Positivos (incluye el 0) ---");
        System.out.println("Cima -> Base: " + positivos);
        calcularYMostrarExtremos("Positivos", positivos);

        System.out.println("\n--- Pila de Negativos ---");
        System.out.println("Cima -> Base: " + negativos);
        calcularYMostrarExtremos("Negativos", negativos);

        System.out.println("\n--- Pila Original Restaurada ---");
        System.out.println("Cima -> Base: " + pilaOriginal);

        scanner.close();
    }

    public static int pedirEnteroPositivo(Scanner scanner, String mensaje, int valorPorDefecto) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            
            if (linea.isEmpty()) {
                return valorPorDefecto;
            }

            try {
                int valor = Integer.parseInt(linea);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("[Error] El valor debe ser un número entero mayor a cero.");
            } catch (NumberFormatException e) {
                System.out.println("[Error] Formato inválido. Ingrese un número entero.");
            }
        }
    }

    public static Stack<Integer> generarPilaAleatoria(int n, int min, int max) {
        Stack<Integer> pila = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNum = rand.nextInt(max - min + 1) + min;
            pila.push(randomNum);
        }
        return pila;
    }

    public static void separarYRestaurar(Stack<Integer> original, Stack<Integer> pos, Stack<Integer> neg) {
        Stack<Integer> aux = new Stack<>();

        while (!original.isEmpty()) {
            int val = original.pop();
            aux.push(val);

            if (val >= 0) {
                pos.push(val);
            } else {
                neg.push(val);
            }
        }

        while (!aux.isEmpty()) {
            original.push(aux.pop());
        }
    }

    public static void calcularYMostrarExtremos(String etiqueta, Stack<Integer> pila) {
        if (pila.isEmpty()) {
            System.out.println("La pila de " + etiqueta + " está vacía. No tiene máximo ni mínimo.");
            return;
        }

        Stack<Integer> aux = new Stack<>();
        int max = pila.peek();
        int min = pila.peek();

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (actual > max) max = actual;
            if (actual < min) min = actual;
            aux.push(actual);
        }

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }

        System.out.println("Máximo: " + max + " | Mínimo: " + min);
    }
}