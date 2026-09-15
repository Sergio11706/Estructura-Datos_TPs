Enunciado:

Desarrollar un método que reciba una pila de objetos Producto (atributos: id y precio) y un String que
representa un id buscado. El método debe buscar el producto con el id indicado por parámetro y aplicarle un
descuento del 10% a su precio. La pila debe conservar el mismo orden tras la operación. Si el producto no
existe, no hace nada.
Solución propuesta por un alumno (¡Contiene errores!):

class Producto {
    String id;
    double precio;
    // Constructor y getters
}
public class Gestion {
    public static void aplicarDescuento(Stack<Producto> pila, String idBuscado) {
        Stack<Producto> aux = new Stack<>();
        while (!pila.isEmpty()) {
            Producto p = pila.pop();
            if (p.id == idBuscado) {
                p.precio = p.precio * 0.90;
            }
            aux.push(p);
        }

        // Devolver a la pila original
        pila.push(aux.pop());
    }
}

Actividad:
1. Analizar el código e identificar los errores conceptuales y lógicos.
2. Argumentar por qué constituyen errores. (Ayuda: Hay un error al comparar Strings, un error de falta de
encapsulamiento, y un error en el bucle de restauración de la pila).
3. ¿La solución responde completamente a lo solicitado por la consigna? ¿Qué le pasa a la pila original
después de ejecutar este método?
4. Reescribir el método aplicarDescuento para que la solución sea correcta, garantizando que se revise
toda la pila, se aplique el descuento y se restaure el orden original.

Respuestas

1 y 2. Errores:
    - if (p.id == idBuscado); compara si dos referencias apuntan al mismo objeto, para comparar si su contenido es igual se usa .equals().
    - String id; double precio; estos atributos no estan declarados como privados ya que no respeta el principio de encapsulamiento al poder acceder directamente a ellos mediante p.id y p.precio.
    - pila.push(aux.pop()); tener esto afuera del while causa que la pila no vuelva a su estado original, sino que solo devuelve un solo elemento.

3. La solución no responde completamente a lo solicitado por la consigna ya que después de ejecutar el método la pila no queda con su estado anterior.

4. 
class Producto {
    private String id;
    private double precio;
    // Constructor y getters
}
public class Gestion {
    public static void aplicarDescuento(Stack<Producto> pila, String idBuscado) {
        Stack<Producto> aux = new Stack<>();
        while (!pila.isEmpty()) {
            Producto p = pila.pop();
            if (idBuscado.equals(p.getId())) {
                p.setPrecio = p.getPrecio * 0.90;
            }
            aux.push(p);
        }

        // Devolver a la pila original
        while (!aux.isEmpty()) {
            pila.push(aux.pop())
        }
    }
}