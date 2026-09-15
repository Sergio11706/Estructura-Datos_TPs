package TP3.Ejercicio5;
import TP3.common.Stack;

public class GestorPedidos {

    // a) Agregar un nuevo pedido a la pila
    public static void cargarPedido(Stack<Pedido> pila, Pedido nuevo) {
        pila.push(nuevo);
    }

    // b) Marcar como pagado un pedido por su ID.
    // Se mantiene el orden original de la pila.
    public static void marcarComoPagado(Stack<Pedido> pila, String idPedido) {

        Stack<Pedido> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            Pedido pedido = pila.pop();

            if (pedido.getIdPedido().equals(idPedido)) {
                pedido.setEstaPago(true);
            }

            auxiliar.push(pedido);
        }

        // Restauramos la pila original.
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }
    }

    // c) Obtener la deuda total sin modificar la pila original.
    public static double obtenerDeudaTotal(Stack<Pedido> pila) {

        double deuda = 0;

        Stack<Pedido> auxiliar = new Stack<>();

        // Sacamos los elementos de la pila original
        // y los guardamos en una auxiliar.
        while (!pila.isEmpty()) {
            Pedido pedido = pila.pop();

            if (!pedido.isEstaPago()) {
                deuda += pedido.getMonto();
            }

            auxiliar.push(pedido);
        }

        // Restauramos la pila original.
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }

        return deuda;
    }

    // d) Eliminar los pedidos pagados.
    // Los pedidos pendientes mantienen su orden.
    public static void vaciarPagados(Stack<Pedido> pila) {

        Stack<Pedido> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            Pedido pedido = pila.pop();

            if (!pedido.isEstaPago()) {
                auxiliar.push(pedido);
            }
        }

        // Restauramos solamente los pedidos pendientes.
        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }
    }

    // Mostrar la pila sin modificarla.
    public static void mostrarPila(Stack<Pedido> pila) {
        System.out.println(pila);
    }
}