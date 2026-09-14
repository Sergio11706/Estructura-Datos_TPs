package TP3.Ejercicio5;
import TP3.common.Stack;
import java.util.Scanner;

public class Main {

    // Método para leer y validar un ID.
    public static String leerId(Scanner scanner) {

        while (true) {
            System.out.print("Ingrese el ID del pedido: ");
            String id = scanner.nextLine().trim();
            if (!id.isEmpty()) {
                return id;
            }
            System.out.println("Error: el ID no puede estar vacío.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // e) Crear pila de pedidos
        Stack<Pedido> pila = new Stack<>();

        // Cargar 5 pedidos
        GestorPedidos.cargarPedido(pila, new Pedido("P001", 15000, false));
        GestorPedidos.cargarPedido(pila, new Pedido("P002", 8500, true));
        GestorPedidos.cargarPedido(pila, new Pedido("P003", 12000, false));
        GestorPedidos.cargarPedido(pila, new Pedido("P004", 20000, true));
        GestorPedidos.cargarPedido(pila, new Pedido("P005", 7500, false));

        // f) Mostrar estado inicial
        System.out.println("=================================");
        System.out.println("ESTADO INICIAL DE LA PILA");
        System.out.println("=================================");

        GestorPedidos.mostrarPila(pila);

        double deudaInicial = GestorPedidos.obtenerDeudaTotal(pila);
        System.out.printf("Deuda total: $%.2f%n", deudaInicial);

        // g) Pedir ID al usuario
        String idBuscado = leerId(scanner);
        double deudaAntes = GestorPedidos.obtenerDeudaTotal(pila);
        
        GestorPedidos.marcarComoPagado(pila, idBuscado);
        double deudaDespues =GestorPedidos.obtenerDeudaTotal(pila);

        System.out.println("=================================");
        System.out.println("RESULTADO");
        System.out.println("=================================");

        if (deudaDespues < deudaAntes) {
            System.out.println("El pedido fue marcado como pagado.");
        } else {
            System.out.println("El pedido no existe o ya estaba pagado.");
        }
        System.out.printf("Deuda anterior: $%.2f%n",deudaAntes);
        System.out.printf("Deuda actual: $%.2f%n",deudaDespues);

        // h) Eliminar pedidos pagados
        GestorPedidos.vaciarPagados(pila);
        System.out.println("=================================");
        System.out.println("PILA DESPUÉS DE VACIAR PAGADOS");
        System.out.println("=================================");
        GestorPedidos.mostrarPila(pila);
        scanner.close();
    }
    //Por aclaracion, este programa no tiene un menú interactivo, sino que realiza las operaciones de manera secuencial para demostrar el funcionamiento de la pila de pedidos.
}