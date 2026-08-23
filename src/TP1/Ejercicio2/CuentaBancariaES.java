package TP1.Ejercicio2;

public class CuentaBancariaES {
    public static void menu() {
        System.out.println("""
                
                -- MENU DE OPCIONES ----------------
                1.- Depositar
                2.- Retirar
                3.- Salir
                ------------------------------------""");
    }

    public static void avisoRetiro(boolean retiro) {
        if (retiro) System.out.println("\nRETIRO EXITOSO");
        else System.out.println("\nNO SE PUDO REALIZAR EL RETIRO");
    }

    public static double monto(String mensaje) {
        double entrada;
        while (true) {
            entrada = Entrada.decimal("\n" + mensaje);

            if (entrada > 0) return entrada;
            System.out.println("\nERROR: el monto debe ser mayor a 0");
        }
    }

    public static int opcion(String mensaje) {
        int entrada;
        while (true) {
            entrada = Entrada.entero("\n" + mensaje);

            if (entrada > 0) return entrada;
            System.out.println("\nERROR: la opción debe ser mayor que 0");
        }
    }
}
