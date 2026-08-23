package TP1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paciente paciente = new Paciente();

        System.out.println("Ingresar nombre del paciente:");
        String nombre = sc.nextLine();
        paciente.setNombre(nombre);
        System.out.println("Ingresar dni del paciente:");
        int dni = sc.nextInt();
        paciente.setDni(dni);
        System.out.println("Ingresar peso del paciente:");
        double peso = validarNumero(sc);
        paciente.setPeso(peso);
        System.out.println("Ingresar altura del paciente:");
        double altura = validarNumero(sc);
        paciente.setAltura(altura);

        double imc = paciente.indiceMC(paciente.getPeso(), paciente.getAltura());

        System.out.println("Paciente: " + paciente.getNombre() + " dni: " + paciente.getDni() + " peso: " + paciente.getPeso() + " altura: " + paciente.getAltura());
        System.out.println("IMC: " + String.format("%.2f", imc));
        System.out.println("La condición del paciente es: " + paciente.estadoNutricional(imc));

        sc.close();
    }

    public static double validarNumero(Scanner sc) {
        double numero;

        do {
            while(!sc.hasNextDouble()) {
                System.out.println("Entrada invalida, ingrese nuevamente:");
                sc.next();
            }

            numero = sc.nextDouble();
            if (numero < 0) {
                System.out.println("Error, ingrese un número valido:");
            }
        } while (numero < 0);

        return numero;
    }
}
