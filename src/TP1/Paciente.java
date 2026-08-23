package TP1;

public class Paciente {
    private String nombre;
    private int dni;
    private double peso;
    private double altura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
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
