package TP4.Ejercicio8;

public class Cliente {
    private int edad;
    private String nombre;
 
    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    @Override
    public String toString() {
        return nombre + "(" + edad + ")";
    }
}
