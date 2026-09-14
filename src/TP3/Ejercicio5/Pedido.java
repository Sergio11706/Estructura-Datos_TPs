package TP3.Ejercicio5;

public class Pedido {

    private String idPedido;
    private double monto;
    private boolean estaPago;

    public Pedido(String idPedido, double monto, boolean estaPago) {
        this.idPedido = idPedido;
        this.monto = monto;
        this.estaPago = estaPago;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido='" + idPedido + '\'' +
                ", monto=" + monto +
                ", estaPago=" + estaPago +
                '}';
    }
}