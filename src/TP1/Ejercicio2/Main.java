package TP1.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Perez", 50000.0, "corriente");

        int opcion;
        do {
            CuentaBancariaES.menu();
            opcion = CuentaBancariaES.opcion("Ingrese una opción");
            switch (opcion) {
                case 1:
                    cuenta1.depositar(CuentaBancariaES.monto("Ingrese el monto a depositar"));
                    System.out.println(cuenta1);
                    break;
                case 2:
                    boolean retiro = cuenta1.retirar(CuentaBancariaES.monto("Ingrese el monto a retirar"));
                    CuentaBancariaES.avisoRetiro(retiro);
                    System.out.println(cuenta1);
                    break;
                case 3:
                    System.out.println("\nFIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("\nERROR: la opción ingresada no es valida");
                    break;
            }
        } while (!(opcion == 3));
    }
}
