package TP1.Ejercicio5;
public class main {
    public static void main(String[] args) {
        bateria b = new bateria(50);
        
        b.consumir(60);
        
        System.out.println("Carga final: " + b.getCarga() + "%");
    }
}

/*
***************RESPUESTAS************
1) La Solución B. Al usar private, protege el atributo carga y respeta el encapsulamiento.
2) En la Solución B, la batería controla sus propios límites automáticamente. 
En la A, obligás al programa principal a hacer los controles, 
lo que te lleva a repetir el código cada vez que la usás.
3)La Solución B es la más robusta. Con b.consumir(200)
La Solución A restaría sin límite dejando la carga en -150%. 
La Solución B hace el control interno y frena en 0%.
4)VENTAJAS 
Solucion A: Es un código más rápido de escribir para pruebas simples.
Solucion B: Garantiza que los datos nunca sean inválidos.
A futuro, la B es mejor porque si cambia una regla , solo cambiás una línea dentro de la clase Bateria. 
Con la A, tendrías que modificar todos los if por todo el programa.

*/