package TP4.Ejercicio5; 

public class Envio {
    private String codigoSeguimiento;
    private double peso;
    private Destino destino;
    private Estado estado;

    public Envio(String codigoSeguimiento, double peso,
                 Destino destino, Estado estado) {

        this.codigoSeguimiento = codigoSeguimiento;
        this.peso = peso;
        this.destino = destino;
        this.estado = estado;
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public double getPeso() {
        return peso;
    }

    public Destino getDestino() {
        return destino;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setCodigoSeguimiento(String codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
    return "\nEnvio{" +
                "codigoSeguimiento='" + codigoSeguimiento + '\'' +
                ", peso=" + peso + " kg" +
                ", destino=" + destino +
                ", estado=" + estado +
                '}';
    }
}