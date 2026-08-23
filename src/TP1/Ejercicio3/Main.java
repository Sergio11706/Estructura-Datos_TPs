package TP1.Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Clase principal para el ejercicio 3 del TP1.
 * 
 * @author Sergio Acuña
 * 
 *          En el programa principal (main) se debe:
 *              Solicitar al usuario los datos para crear al menos dos objetos Reserva diferentes, por ejemplo: 
 *              una reserva futura y una reserva ya finalizada. Se deben realizar las validaciones correspondientes.
 *              Después de crear las reservas, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,año) 
 *              para verificar el estado de las mismas. Esta fecha también debe ser validada.
 * 
 *          Para cada objeto Reserva creado, el programa debe:
 *              Mostrar sus detalles utilizando el método toString().
 *              Llamar al método estaActiva() pasándole la "fecha de consulta" y mostrar el resultado.
 *              Llamar al método calcularDiasRestantesOTranscurridos() pasándole la misma "fecha de consulta" y
 *              mostrar la cantidad de días.
 *              Solicitar al usuario una cantidad de días para simular una prórroga, llamar al método simularProrroga()
 *              y mostrar la nueva fecha de check-out calculada.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Reserva> reservas = cargarReservas(sc);

        // Solicita al usuario una fecha de consulta y valida el formato
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
                error = true; // Repite el pedido de fecha
            }
        }while(error);

        // Muestra la información de cada reserva y realiza las consultas
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

        // Bucle para permitir al usuario agregar múltiples reservas
        boolean agregarReserva = true;
        while(agregarReserva) {
            try {
                System.out.print("\nIngrese el código de la reserva: ");
                String codigoReserva = sc.nextLine();

                 // Valida que el código de reserva sea único
                boolean existe = false;
                for (Reserva r : reservas) {
                    if (r.getCodigoReserva().equals(codigoReserva)) {
                        System.out.println("El código de reserva ya existe. Intente nuevamente.");
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    continue; // Si el codigo ya existe, vuelve a pedir el código desde cero
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
                    
                    // Si las fechas ingresadas no son validas, se ajustan automáticamente en el constructor
                    // En esta seccion no vuelve a modificar las fecbas, solo se informa al usuario que se asignarán fechas por defecto
                    if(!fechaCheckIn.isBefore(fechaCheckOut)) {
                        System.out.println("\n*Fechas inválidas. Se asignarán fechas por defecto.*");
                    }

                    System.out.println("\nReserva ingresada correctamente");
                    reservas.add(reserva);
                    
                    System.out.println("¿Desea agregar otra reserva?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    String opcion = sc.nextLine();

                    // Si el usuario ingresa "1", se agrega otra reserva. Cualquier otra opción termina el bucle
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
        if(!codigoReserva.matches("\\d{3}")){ // Valida que el codigo sea exactamente 3 dígitos "000"
            return false;
        }
        if(!nombreHuesped.matches("[a-zA-ZñÑ ]+")){ // Valida que el nombre solo contenga letras y espacios
            return false;
        }
        return true;
    }
}
