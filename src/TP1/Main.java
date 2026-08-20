package TP1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Paciente paciente = new Paciente("Pepe", 20456732, 105, 1.70);
        double imc = paciente.indiceMC(paciente.peso, paciente.altura);

        System.out.println("Paciente: " + paciente.nombre + " dni: " + paciente.dni + " peso: " + paciente.peso + " altura: " + paciente.altura);
        System.out.println("IMC: " + imc);
        System.out.println("La condición del paciente es: " + paciente.estadoNutricional(imc));

        sc.close();
    }
}
