package logica;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String tipoCuenta;
    private static final double LIMITE_CORRIENTE = -50000.0;

    public CuentaBancaria() {
        this("Invitado",0,"ahorro");
    }

    public CuentaBancaria(String titular, double saldo, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public void depositar(double monto) {
        if (monto <= 0) System.out.println("\n ERROR: el monto a depositar no puede ser 0 o negativo");
        else saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("\nERROR: el monto a retirar no puede ser 0 o negativo");
            return false;
        } else if (monto > saldo && !tipoCuenta.equals("corriente")) {
            System.out.println("\nERROR: saldo insuficiente");
            return false;
        } else if (tipoCuenta.equals("corriente") && (saldo - monto < LIMITE_CORRIENTE)){
            System.out.println("\nERROR: saldo insuficiente");
            return false;
        } else {
            saldo -= monto;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%n-- DATOS DE LA CUENTA --------------" +
                "%nTitular: %s" +
                "%nSaldo: %.2f" +
                "%nTipo de Cuenta: %s" +
                "%n------------------------------------"
                ,getTitular(),getSaldo(),getTipoCuenta());
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
}