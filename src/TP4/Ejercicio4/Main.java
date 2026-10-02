package TP4.Ejercicio4;

import util.*;

/**
 * Clase principal para el ejercicio 4 del TP4.
 * 
 * @author Sergio Acuña
 * 
 * Enunciado:
 *    Escribir un programa para gestionar una cola de tickets de soporte técnico.
 *    Cada ticket debe representarse mediante un objeto con los campos: idTicket,
 *    departamento (ej. "Redes", "Software", "Hardware") y nivelUrgencia (entre 1 y 5).
 *    
 *    a) A partir de una cola que contiene N tickets, generar una cola que contenga
 *       todos aquellos tickets cuyo departamento coincida con uno indicado por el usuario.
 *    b) Calcular el nivel promedio de urgencia de todos los tickets de la cola original.
 *    c) Identificar y mostrar (si existe) el primer ticket crítico de nivel 5.
 *    d) Generar un arreglo con los IDs de los tickets que tengan un nivel de urgencia 4 o 5.
 *    e) Cuando se recorran los elementos de la cola esta debe mantenerse sin modificaciones.
 *    
 *    En el programa principal (main) se debe:
 *    a) Cargar al menos 5 tickets en la cola con datos ingresados por el usuario.
 *    b) Solicitar al usuario el departamento a filtrar y ejecutar las operaciones,
 *       mostrando claramente los resultados de cada punto.
 */
public class Main {

    //Pide al usuario un departamento mediante un menú.
    private static String readDepartment() {
        System.out.println("1.Redes \n2.Software \n3.Hardware");
        int op = Helper.readMenuOption("Ingrese una opción: ", 1, 3);

        switch (op) {
            case 1:
                return "Redes";
            case 2:
                return "Software";
            default:
                return "Hardware";
        }
    }

    //Carga una cola de 5 tickets con datos ingresados por el usuario.
    private static Queue<Ticket> loadQueue() {
        Queue<Ticket> ticketQueue = new CountedQueue<>(5);
        for (int i = 0; i < 5; i++) {

            System.out.println("\n**Creando ticket " + (i + 1) + "**");
            System.out.println("Ingrese el departamento del ticket");

            String department = readDepartment();
            int urgencyLevel = Helper.readIntBetween("Ingrese el nivel de urgencia del ticket (1-5): ", 1, 5);

            ticketQueue.add(new Ticket(department, urgencyLevel));
        }

        return ticketQueue;
    }

    //Genera una copia de la cola. La copia contiene las mismas referencias a los tickets. La cola original queda sin modificaciones.
    private static Queue<Ticket> copyQueue(Queue<Ticket> original) {
        int size = original.size();
        Queue<Ticket> copy = new CountedQueue<>(Math.max(size, 1));

        for (int i = 0; i < size; i++) {
            Ticket ticket = original.poll();
            copy.offer(ticket);
            original.offer(ticket);
        }

        return copy;
    }

    //Genera una nueva cola con los tickets del departamento indicado.
    private static Queue<Ticket> filterQueue(Queue<Ticket> ticketQueue, String department) {
        Queue<Ticket> copy = copyQueue(ticketQueue);
        int size = copy.size();

        // La copia es la que se modifica; la original queda intacta.
        for (int i = 0; i < size; i++) {
            Ticket ticket = copy.poll();
            if (ticket.getDepartment().equals(department)) {
                copy.offer(ticket);
            }
        }

        return copy;
    }

    //Calcula el nivel promedio de urgencia de los tickets.
    private static double averageUrgency(Queue<Ticket> ticketQueue) {
        Queue<Ticket> copy = copyQueue(ticketQueue);

        int queueSize = copy.size();
        if (queueSize == 0) return 0;

        double sum = 0;
        while (!copy.isEmpty()) {
            sum += copy.poll().getUrgencyLevel();
        }

        return sum / queueSize;
    }

    //Busca el primer ticket crítico (nivel de urgencia 5).
    private static Ticket findFirstCriticalTicket(Queue<Ticket> ticketQueue) {
        Queue<Ticket> copy = copyQueue(ticketQueue);

        while (!copy.isEmpty()) {
            Ticket ticket = copy.poll();
            if (ticket.getUrgencyLevel() == 5) return ticket;
        }

        return null;
    }

    //Genera un arreglo con los IDs de los tickets con urgencia 4 o 5.
    private static int[] generateTicketArray(Queue<Ticket> ticketQueue) {
        Queue<Ticket> copy = copyQueue(ticketQueue);

        //Se eliminan los tickets con urgencia distinta de 4 o 5 de una copia de la cola.
        int matches = 0;
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            Ticket ticket = copy.poll();
            if (ticket.getUrgencyLevel() >= 4) matches++;
            copy.offer(ticket);
        }

        //Se guarda en un arreglo el id de los tickets con urgencia 4 o 5
        int[] ticketIDs = new int[matches];
        int index = 0;
        while (!copy.isEmpty()) {
            Ticket ticket = copy.poll();
            if (ticket.getUrgencyLevel() >= 4) {
                ticketIDs[index++] = ticket.getIdTicket();
            }
        }

        return ticketIDs;
    }

    public static void main(String[] args) {

        System.out.println("\n***Bienvenido al sistema de tickets***");

        Queue<Ticket> queueTickets = loadQueue();

        System.out.println("\n***Cola de Tickets cargada correctamente.***");

        //Filtrar por departamento (genera una cola nueva)
        System.out.println("\n*Ingrese un departamento para filtrar los tickets*");
        String department = readDepartment();

        Queue<Ticket> filteredQueue = filterQueue(queueTickets, department);

        //Promedio de urgencia de la cola original
        double averageUrgency = averageUrgency(filteredQueue);
        System.out.println("\nEl promedio del nivel de urgencia de los tickets es: " + averageUrgency);

        //Primer ticket crítico
        Ticket firstCriticalTicket = findFirstCriticalTicket(filteredQueue);

        if (firstCriticalTicket == null) System.out.println("\nNo se registró ningún ticket crítico.");
        else System.out.println("\nEl primer ticket crítico registrado es: \n" + firstCriticalTicket.toString());

        //IDs de tickets con urgencia 4 o 5
        int[] ticketIDs = generateTicketArray(filteredQueue);

        if (ticketIDs.length > 0) {
            System.out.println("\n*ID de los tickets con nivel de urgencia 4 o 5*");
            for (int id : ticketIDs) {
                System.out.println("ID: " + id);
            }
        } 
        else System.out.println("\nNo se registró ningún ticket con nivel de urgencia 5 o 4");

        
    }
}