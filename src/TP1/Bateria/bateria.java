package TP1.Bateria;


//Codigo FINAL 
class bateria {
    private int carga;
    public bateria(int cargaInicial) {
        if (cargaInicial < 0) cargaInicial = 0;
        if (cargaInicial > 100) cargaInicial = 100;
        this.carga = cargaInicial;
    }

    public void consumir(int cantidad) {
        this.carga -= cantidad;
        if (this.carga < 0) {
            this.carga = 0;
        }
    }

    public void cargar(int cantidad) {
        this.carga += cantidad;
        if (this.carga > 100) {
            this.carga = 100;
        }
    }

    public int getCarga() {
        return this.carga;
    }
}
/*

// SOLUCION A 
class Bateria {
public int carga;
public Bateria(int cargaInicial) {
if (cargaInicial < 0) cargaInicial = 0;
if (cargaInicial > 100) cargaInicial = 100;
this.carga = cargaInicial;
}
public void consumir(int cantidad) {
this.carga = this.carga - cantidad;
}
}
public class Main {
public static void main(String[] args) {
Bateria b = new Bateria(50);
// Consumir 60
if (b.carga - 60 < 0) {
b.carga = 0;
} else {
b.carga = b.carga - 60;
}
System.out.println("Carga final: " + b.carga + "%");
}
}



// SOLUCION B
class Bateria {
private int carga;
public Bateria(int cargaInicial) {
if (cargaInicial < 0) cargaInicial = 0;
if (cargaInicial > 100) cargaInicial = 100;
this.carga = cargaInicial;
}
public void consumir(int cantidad) {
this.carga -= cantidad;
if (this.carga < 0) {
this.carga = 0;
}
}
public int getCarga() {
return this.carga;
}
}
public class Main {
public static void main(String[] args) {
Bateria b = new Bateria(50);
// Consumir 60
b.consumir(60);
System.out.println("Carga final: " + b.getCarga() + "%");
}
}


*/