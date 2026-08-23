package TP1.Ejercicio1;

public class Cilindro {
    private double radio;
    private double altura;

    public Cilindro() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    public Cilindro(double radio, double altura) {
        setRadio(radio);
        setAltura(altura);
    }

    // getters and setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    public double calcularAreaSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }

}