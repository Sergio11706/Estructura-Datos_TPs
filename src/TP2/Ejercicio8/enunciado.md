# ✏️ Ejercicio 8

Leer atentamente el enunciado presentado a continuación y luego, analizar la solución propuesta. ¡Cuidado!
La solución contiene errores.

## 📌 Enunciado:
Diseñar un programa que cargue 3 objetos de la clase Empleado (con legajo, nombre y sueldo) en un arreglo.
Luego, buscar un empleado por su número de legajo e informar su nombre. Finalmente, encontrar e informar el
nombre del empleado con el mayor sueldo.
Solución propuesta (¡Contiene errores!):

```java
class Empleado {
    int legajo;
    String nombre;
    double sueldo;
    
    public Empleado(int legajo, String nombre, double sueldo) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
}
public class GestionRRHH {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[3];
        
        empleados[0] = new Empleado(101, "Ana", 500.0);
        empleados[1] = new Empleado(102, "Beto", 700.0);
        empleados[2] = new Empleado(103, "Carla", 600.0);
        
        int legajoBuscado = 102;
        
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].legajo == legajoBuscado) {
                System.out.println("Encontrado: " + empleados[i].nombre);
            } else {
                System.out.println("Legajo no encontrado.");
            }
        }
        
        Empleado mayorSueldo = empleados[0];
        
        for (int i = 1; i < empleados.length; i++) {
            if (empleados[i].sueldo > mayorSueldo.sueldo) {
                mayorSueldo.sueldo = empleados[i].sueldo;
            }
        }
        
        System.out.println("Mayor sueldo: " + mayorSueldo.nombre);
    }
}
```
## ❓ Actividad
1. Analice el código línea por línea e identifique los errores lógicos y conceptuales.
2. Argumente por qué constituyen errores. (Ayuda: Hay un error en el mensaje de "no encontrado", un
   error al actualizar el empleado de mayor sueldo y un posible error si el arreglo estuviera vacío).
3. ¿La solución responde completamente a lo solicitado por la consigna?
4. Reescriba los bloques de código necesarios para que la solución sea correcta y robusta.

---

## ❗ Respuestas

## 1 y 2. Análisis e identificación de errores en la solución propuesta

* **Error 1: Falso negativo iterativo en la búsqueda (Líneas 23-29)**
  * **Identificación:** La estructura condicional `if-else` dentro del ciclo `for` imprime `"Legajo no 
  encontrado."` en cada iteración donde el legajo evaluado no coincida con `legajoBuscado`.
  * **Argumentación:** Si se busca un legajo ubicado en la segunda posición (por ejemplo, `102`), la 
  primera iteración imprimirá que el legajo no existe antes de llegar a la posición correcta. El mensaje 
  de "no encontrado" únicamente debe mostrarse tras haber inspeccionado la totalidad del arreglo sin 
  haber hallado coincidencias.

* **Error 2: Mutación no deseada de un objeto existente (Línea 34)**
  * **Identificación:** En la instrucción `mayorSueldo.sueldo = empleados[i].sueldo;` se modifica la 
  propiedad `sueldo` del objeto referenciado por `mayorSueldo`.
  * **Argumentación:** Dado que `mayorSueldo` apunta inicialmente a `empleados[0]` (Ana), la condición 
  sobrescribe el sueldo de Ana con el valor del mayor sueldo encontrado, en lugar de reasignar la 
  referencia para que apunte al nuevo objeto `Empleado`. Como resultado, la variable `mayorSueldo` 
  sigue haciendo referencia a `empleados[0]` e imprime un nombre incorrecto ("Ana") con un sueldo 
  alterado.

* **Error 3: Vulnerabilidad ante arreglos vacíos o nulos (Líneas 21 y 31)**
  * **Identificación:** Acceso directo al índice `0` (`empleados[0]`) e iteración inmediata basada en 
  `empleados.length`.
  * **Argumentación:** Si el arreglo es `null` o no contiene elementos (`length == 0`), intentar 
  acceder a `empleados[0]` desencadena una excepción en tiempo de ejecución (`ArrayIndexOutOfBoundsException` 
  o `NullPointerException`), provocando la interrupción abrupta del programa al no contemplar validaciones previas.

---

## 3. Evaluación respecto a los requerimientos del enunciado

La solución propuesta **no responde de manera correcta ni completa** a lo solicitado por la consigna. 

Si bien implementa la estructura general para recorrer el arreglo y realizar comparaciones, la 
lógica actual distorsiona la salida por consola con falsos negativos y corrompe el estado de los datos 
en memoria al modificar el sueldo del primer empleado en lugar de identificar al empleado correspondiente.
