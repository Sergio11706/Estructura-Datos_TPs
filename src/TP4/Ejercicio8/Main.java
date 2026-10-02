package TP4.Ejercicio8;

import util.*;

public class Main {
    
    /* Solucion con errores
    public static void eliminarMenores(Queue<Cliente> cola) {
        for (int i = 0; i < cola.size(); i++) {
            // ERROR: cola.size() se reevalúa en cada iteración,
            // y va disminuyendo a medida que se descartan menores.
            Cliente c = cola.poll();
            if (c.edad >= 18) {
                cola.add(c);
            }
        }
    }
    */

    //Codigo corregido
    public static void eliminarMenores(Queue<Cliente> cola) {
        // CORRECCIÓN: se fija el tamaño original ANTES del bucle, en vez de usar cola.size() dinámicamente.
        int tamanioOriginal = cola.size();
 
        // CORRECCIÓN: el for ahora usa la variable fija como límite, garantizando que se evalúen exactamente los elementos originales, uno por uno, sin importar cuántos se re-encolen.
        for (int i = 0; i < tamanioOriginal; i++) {
            Cliente c = cola.poll();
            if (c.getEdad() >= 18) {
                cola.add(c);
            }
            // Si es menor de edad, no se vuelve a agregar
        }
    }

    public static void main(String[] args) {
        Queue<Cliente> cola = new CountedQueue<>(5);
        cola.add(new Cliente("Ana", 15));
        cola.add(new Cliente("Luis", 20));
        cola.add(new Cliente("Marta", 17));
        cola.add(new Cliente("Pedro", 30));
        cola.add(new Cliente("Sofia", 16));
 
        System.out.println("Cola original: " + cola);
 
        eliminarMenores(cola);
 
        System.out.println("Cola sin menores de edad: " + cola);
    }

}

/*
1) La condición del for es "i < cola.size()", pero cola.size() se recalcula en CADA iteración, no se fija una sola vez al inicio.

2) Cada vez que se elimina un cliente menor de edad (no se vuelve a hacer add()), el tamaño de la cola disminuye en 1. Como el for recalcula cola.size() en cada vuelta, el límite del bucle va bajando junto con el tamaño real de la cola. Esto provoca que el bucle termine ANTES de haber evaluado todos los elementos originales, dejando clientes sin revisar.

3) Guardar el tamaño original en una variable ANTES de empezar el bucle, y usar esa variable fija como límite del for. Así se garantiza que se evalúan exactamente "tamañoOriginal" elementos, sin importar cuántos se vuelvan a encolar o se descarten.
*/