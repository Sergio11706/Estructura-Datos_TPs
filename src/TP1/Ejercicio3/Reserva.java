package TP1.Ejercicio3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa una reserva de hotel.
 * 
 * @author Sergio Acuña
 * 
 *          Enunciado del ejercicio 3 del TP1:
 * 
 *          Desarrollar un programa que simule la gestión de una reserva de hotel con fecha de check-in y fecha de
 *          check-out, incorporando funcionalidades de verificación y modificación.
 *          El programa debe incluir:
 *              Una Clase Reserva con los atributos: codigoReserva (String único), nombreHuesped, fechaCheckIn y
 *              fechaCheckOut.
 *              Constructor predeterminado que inicializa codigoReserva en "000", nombreHuesped en "Porconfirmar", 
 *              fechaCheckIn con la fecha actual y fechaCheckOut igual a un día después de la fecha actual.
 *              Constructor parametrizado que permite establecer todos los atributos mediante argumentos.
 *              Método toString() para retornar una representación textual completa y legible del objeto Reserva.
 *              Método auxiliar para validar fechas que comprueba si las fechas de check-in y check-out son válidas (la
 *              fecha de check-in debe ser estrictamente anterior a la fecha de check-out). Si las fechas no son válidas,
 *              se ajustan automáticamente asignando la fecha actual al check-in y el día siguiente al check-out.
 *              Un método estaActiva(LocalDate fechaConsulta) para determinar si la reserva está vigente en una fecha
 *              dada por el usuario. Debe retornar true si la fechaConsulta es igual o posterior a fechaCheckIn y
 *              estrictamente anterior a fechaCheckOut. De lo contrario, retorna false.
 *              Método calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta). Si la fecha de consulta es
 *              anterior al check-in, debe retornar un valor positivo que represente los días faltantes para el check-in. Si
 *              la fecha de consulta está dentro de la estadía, retornar 0. Si la fecha de consulta es posterior al
 *              check-out, debe retornar un valor negativo que represente los días que han transcurrido desde el
 *              check-out hasta la fechaConsulta.
 *              Método simularProrroga(int cantidadDias) que calcula y retorna la nueva fecha de check-out si la
 *              estadía se extendiera por una cantidad específica de días a partir de la fecha de check-out actual.
 */

public class Reserva {
    private String codigoReserva;
    private String nombreHuesped;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;

    public Reserva() {
        this.codigoReserva = "000";
        this.nombreHuesped = "Por confirmar";
        this.fechaCheckIn = LocalDate.now();
        this.fechaCheckOut = LocalDate.now().plusDays(1);
    }
    
    public Reserva(String codigoReserva, String nombreHuesped, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        validarFechas(); // Asegura que el objeto nazca siempre consistente
    }

    @Override
    public String toString() {
    return "\nCódigo de reserva: " + codigoReserva + "\n"
         + "Nombre del huésped: " + nombreHuesped + "\n"
         + "Fecha de check-in: " + fechaCheckIn + "\n"
         + "Fecha de check-out: " + fechaCheckOut;
    }

    public void validarFechas() {
        // checkIn debe ser estrictamente anterior a checkOut
        // Si checkIn NO es anterior a checkOut, es igual o posterior por lo que se ajustan automáticamente las fechas
        if(!fechaCheckIn.isBefore(fechaCheckOut)) {
            fechaCheckIn = LocalDate.now();
            fechaCheckOut = LocalDate.now().plusDays(1);
        }
    }

    public boolean estaActiva(LocalDate fechaConsulta) {
        // Rango [checkIn, checkOut): incluye checkIn, excluye checkOut
        if(fechaConsulta.isBefore(fechaCheckIn)) return false;
        if(fechaConsulta.isBefore(fechaCheckOut)) return true;
        return false;
    }

    public long calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta) {
        if(fechaConsulta.isBefore(fechaCheckIn)){
            return ChronoUnit.DAYS.between(fechaConsulta, fechaCheckIn);  // Positivo: faltan días
        }
        else if(fechaConsulta.isBefore(fechaCheckOut)){ 
            return 0;// Dentro de la estadía
        }
        else{
            return ChronoUnit.DAYS.between(fechaCheckOut, fechaConsulta) * -1; // Negativo: ya pasaron días
        }
    }

    public String simularProrroga(int cantidadDias) {
        // No modifica el objeto actual, solo calcula y retorna la nueva fecha de check-out simulada
        LocalDate fechaNueva = fechaCheckOut.plusDays(cantidadDias);
        return fechaNueva.toString();
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }
}
