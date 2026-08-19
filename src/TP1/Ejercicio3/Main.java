package TP1.Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Reserva> reservas = cargarReservas(sc);

        boolean error = false;
        LocalDate fechaConsulta = null;
        do{
            try {
                System.out.print("\nIngrese fecha de consulta (YYYY-MM-DD): ");
                String fechaString = sc.nextLine();
                fechaConsulta = LocalDate.parse(fechaString);
                error = false;
            }
            catch(Exception e) {
                System.out.println("Error al ingresar los datos. Intente nuevamente.");
                error = true;
            }
        }while(error);

        for(Reserva reservaActual: reservas) {
            System.out.println(reservaActual.toString());

            if(reservaActual.estaActiva(fechaConsulta)){
                System.out.println("La reserva está activa.");
            }
            else{
                System.out.println("La reserva no está activa.");
            }

            long diasTranscurridos = reservaActual.calcularDiasRestantesOTranscurridos(fechaConsulta);
            System.out.println("Días restantes o transcurridos: " + diasTranscurridos);

            System.out.print("\nIngrese la cantidad de días para simular la prórroga: ");
            int diasProrroga = sc.nextInt();
            System.out.println("Nueva fecha de check-out simulada: " + reservaActual.simularProrroga(diasProrroga));
        }

        sc.close();

    }

    private static ArrayList<Reserva> cargarReservas(Scanner sc) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        boolean agregarReserva = true;
        while(agregarReserva) {
            try {
                System.out.print("\nIngrese el código de la reserva: ");
                String codigoReserva = sc.nextLine();

                boolean existe = false;
                for (Reserva r : reservas) {
                    if (r.getCodigoReserva().equals(codigoReserva)) {
                        System.out.println("El código de reserva ya existe. Intente nuevamente.");
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    continue;
                }

                System.out.print("Ingrese el nombre del huésped: ");
                String nombreHuesped = sc.nextLine();

                System.out.print("Ingrese la fecha de check-in (YYYY-MM-DD): ");
                String fechaString = sc.nextLine();
                LocalDate fechaCheckIn = LocalDate.parse(fechaString);

                System.out.print("Ingrese la fecha de check-out (YYYY-MM-DD): ");
                fechaString = sc.nextLine();
                LocalDate fechaCheckOut = LocalDate.parse(fechaString);

                if(validarDatos(codigoReserva, nombreHuesped)) {
                    Reserva reserva = new Reserva(codigoReserva, nombreHuesped, fechaCheckIn, fechaCheckOut);
                    
                    if(!fechaCheckIn.isBefore(fechaCheckOut)) {
                        System.out.println("\n*Fechas inválidas. Se asignarán fechas por defecto.*");
                    }

                    System.out.println("\nReserva ingresada correctamente");
                    reservas.add(reserva);
                    
                    System.out.println("¿Desea agregar otra reserva?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    String opcion = sc.nextLine();

                    if(opcion.equals("1")) {
                        agregarReserva = true;
                    } else {
                        agregarReserva = false;
                    }
                } else {
                    System.out.println("Datos inválidos. Intente nuevamente.");
                }

            } catch(Exception e) {
                System.out.println("Error al ingresar los datos. Intente nuevamente.");
            }
        }

        return reservas;
    }

    private static boolean validarDatos(String codigoReserva, String nombreHuesped) {
        if(!codigoReserva.matches("\\d{3}")){
            return false;
        }
        if(!nombreHuesped.matches("[a-zA-Z ]+")){
            return false;
        }
        return true;
    }
}
