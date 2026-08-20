package TP1;

public class Paciente {
    String nombre;
    int dni;
    double peso;
    double altura;

    public Paciente(String nombre, int dni, double peso, double altura){ 
        this.nombre = nombre;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double indiceMC (double peso, double altura) {
        double masaCorporal = peso / (altura * altura);
        return masaCorporal;
    }

    public String estadoNutricional(double imc) {
        String mensaje = "";
        if (imc < 18.5) {
            mensaje = "Bajo peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            mensaje = "Normal";
        } else if (imc > 24.9 && imc < 29.9) {
            mensaje = "Sobrepeso";
        } else {
            mensaje = "Obesidad";
        }
        return mensaje;
    }
}
