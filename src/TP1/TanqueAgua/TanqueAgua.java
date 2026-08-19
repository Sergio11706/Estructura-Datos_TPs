package TP1.TanqueAgua;

//Codigo corregido:
class TanqueAgua {
    private double capacidadMaxima;
    private double cantidadActual;
    public TanqueAgua() {
        this.capacidadMaxima = 100;
        this.cantidadActual = 0;
    }
    public TanqueAgua(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = cantidadActual;
        if (this.cantidadActual > this.capacidadMaxima) {
            this.cantidadActual = this.capacidadMaxima;
            System.out.println("La cantidad actual no puede exceder la capacidad maxima. Se ajusto a la capacidad maxima");
        }
    }
    public void agregarAgua(double litros) {
        this.cantidadActual = this.cantidadActual + litros;
        if (this.cantidadActual > this.capacidadMaxima) {
            System.out.println("Se excedio la capacidad maxima. El tanque quedara lleno.");
            this.cantidadActual = this.capacidadMaxima;
        }
    }
    public void retirarAgua(double litros) {
        this.cantidadActual = this.cantidadActual - litros;
        if (this.cantidadActual < 0) {
            this.cantidadActual = 0;
            System.out.println("La cantidad actual no puede ser negativa. El tanque quedara vacio.");
        }
    }
    public void mostrarEstado() {
        System.out.println("Actual: " + this.cantidadActual + " / Maxima: " +this.capacidadMaxima);
    }
    public double getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
    public double getCantidadActual() {
        return this.cantidadActual;
    }
    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}

/* Hay varias errores conceptuales en el codigo en cada uno de sus metodos, excepto el constructor por defecto y mostrarEstado.
1) En el constructor con parametros, no se valida que la cantidad actual no sea mayor a la capacidad maxima.
2) En el metodo agregarAgua, no hace que el tanque quede lleno, sino que permite que la cantidad actual exceda la capacidad maxima.
3) En el metodo retirarAgua, no hace que el tanque quede vacio, sino que permite que la cantidad actual sea menor que cero.

Por estos errores, no se cumple losolicitado en el enunciado y tampoco se cumple la regla de que el tanque "debe quedar lleno" o "debe quedar vacio" en los casos limites

CODIGO ORIGINAL:

class TanqueAgua {
    public double capacidadMaxima;
    public double cantidadActual;
    public TanqueAgua() {
        this.capacidadMaxima = 100;
        this.cantidadActual = 0;
    }
    public TanqueAgua(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = cantidadActual;
    }
    public void agregarAgua(double litros) {
        this.cantidadActual = this.cantidadActual + litros;
        if (this.cantidadActual > this.capacidadMaxima) {
            System.out.println("Advertencia: Se excedio la capacidad.");
        }
    }
    public void retirarAgua(double litros) {
        this.cantidadActual = this.cantidadActual - litros;
    }
    public void mostrarEstado() {
        System.out.println("Actual: " + this.cantidadActual + " / Maxima: " +this.capacidadMaxima);
    }
}

*/