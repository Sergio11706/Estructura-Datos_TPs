package TP3;

import java.util.Scanner;
import TP3.common.Stack;
import TP3.Ejercicio4.Tarea;

public class Main {
    public static void agregarTarea(Tarea tarea, Stack<Tarea> pilaTareas){
        pilaTareas.push(tarea);
    }

    public static void eliminarTareaPorPrioridad(String prioridad, Stack<Tarea> pilaTareas){
        Stack<Tarea> pilaAux = new Stack<>();
        

        while(!pilaTareas.isEmpty()){
            // Si la tarea NO tiene la prioridad que queremos eliminar, se guarda en la pilaAuxiliar
            // Si la tarea SI tiene esa prioridad, se ignora y no se guarda en ningún lado
            Tarea tarea = pilaTareas.pop();
            if(!tarea.getPrioridad().equals(prioridad)){
                pilaAux.push(tarea);
            }
        }
        
        while(!pilaAux.isEmpty()){
            pilaTareas.push(pilaAux.pop());
        }
    }

    public static void buscarTareaPorId(String idTarea, Stack<Tarea> pilaTareas){
        Stack<Tarea> pilaAux = new Stack<>();
        boolean encontrado = false;

        while(!pilaTareas.isEmpty()){
            Tarea tarea = pilaTareas.pop();
            if(tarea.getIdTarea().equals(idTarea)){
                System.out.println("Tarea encontrada: " + tarea.getDescripcion());
                encontrado = true;
            }
            pilaAux.push(tarea);
        }

        while(!pilaAux.isEmpty()){
            pilaTareas.push(pilaAux.pop());
        }

        if(!encontrado){
            System.out.println("No se encontró ninguna tarea con el ID: " + idTarea);
        }

    }

    public static void contarTareasAlta(Stack<Tarea> pilaTareas){
        Stack<Tarea> pilaAux = new Stack<>();
        int cont = 0;

        while(!pilaTareas.isEmpty()){
            Tarea tarea = pilaTareas.pop();
            if(tarea.getPrioridad().equals("alta")){
                cont++;
            }
            pilaAux.push(tarea);
        }

        while(!pilaAux.isEmpty()){
            pilaTareas.push(pilaAux.pop());
        }

        System.out.println("Número de tareas con prioridad alta: " + cont);

    }

    public static void mostrarTareas(Stack<Tarea> pilaTareas){
        Stack<Tarea> pilaAux = new Stack<>();

        while(!pilaTareas.isEmpty()){
            Tarea tarea = pilaTareas.pop();
            System.out.println("ID: " + tarea.getIdTarea() + ", Prioridad: " + tarea.getPrioridad() + ", Descripcion: " + tarea.getDescripcion());
            pilaAux.push(tarea);
        }

        while(!pilaAux.isEmpty()){
            pilaTareas.push(pilaAux.pop());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Tarea> pilaTareas = new Stack<>();

        agregarTarea(new Tarea("1", "alta", "Tarea 1"), pilaTareas);
        agregarTarea(new Tarea("2", "media", "Tarea 2"), pilaTareas);
        agregarTarea(new Tarea("3", "baja", "Tarea 3"), pilaTareas);
        agregarTarea(new Tarea("4", "alta", "Tarea 4"), pilaTareas);
        agregarTarea(new Tarea("5", "media", "Tarea 5"), pilaTareas);

        System.out.println("ESTADO INCIAL DE LA PILA: ");
        mostrarTareas(pilaTareas);

        System.out.println("\nBuscar tarea por ID... 3");
        buscarTareaPorId("3", pilaTareas);
        mostrarTareas(pilaTareas);

        System.out.println("\nContar tareas con prioridad alta...");
        contarTareasAlta(pilaTareas);
        mostrarTareas(pilaTareas);

        System.out.println("\nEliminar tareas con prioridad... baja");
        eliminarTareaPorPrioridad("baja", pilaTareas);
        mostrarTareas(pilaTareas);

        scanner.close();
    }
}
