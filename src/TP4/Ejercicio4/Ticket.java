package TP4.Ejercicio4;

public class Ticket {
    private static int ticketCounter = 1;
    private int idTicket;
    private String department;
    private int urgencyLevel;

    public Ticket(String departamento, int nivelUrgencia) {
        this.idTicket = ticketCounter++;
        this.department = departamento;
        this.urgencyLevel = nivelUrgencia;
    }

    public int getIdTicket() {
        return idTicket;
    }
    
    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + idTicket + "\n"
            + "Departamento: " + department + "\n"
            + "Nivel de urgencia: " + urgencyLevel;
    }

}
