package TP1.Ejercicio3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
        validarFechas();
    }

    @Override
    public String toString() {
    return "\nCódigo de reserva: " + codigoReserva + "\n"
         + "Nombre del huésped: " + nombreHuesped + "\n"
         + "Fecha de check-in: " + fechaCheckIn + "\n"
         + "Fecha de check-out: " + fechaCheckOut;
    }

    public void validarFechas() {
        if(!fechaCheckIn.isBefore(fechaCheckOut)) {
            fechaCheckIn = LocalDate.now();
            fechaCheckOut = LocalDate.now().plusDays(1);
        }
    }

    public boolean estaActiva(LocalDate fechaConsulta) {
        if(fechaConsulta.isBefore(fechaCheckIn)) return false;
        if(fechaConsulta.isBefore(fechaCheckOut)) return true;
        return false;
    }

    public long calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta) {
        if(fechaConsulta.isBefore(fechaCheckIn)){
            return ChronoUnit.DAYS.between(fechaConsulta, fechaCheckIn);
        }
        else if(fechaConsulta.isBefore(fechaCheckOut)){
            return 0;
        }
        else{
            return ChronoUnit.DAYS.between(fechaCheckOut, fechaConsulta) * -1;
        }
    }

    public String simularProrroga(int cantidadDias) {
        LocalDate fechaNueva = fechaCheckOut.plusDays(cantidadDias);
        return fechaNueva.toString();
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }
}
