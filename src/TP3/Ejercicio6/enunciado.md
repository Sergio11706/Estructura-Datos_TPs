Ejercicio 6

Enunciado:
Desarrollar un método que reciba una pila de enteros y devuelva un arreglo con los elementos de la pila en el
mismo orden en que van a salir de la pila (el elemento de la cima debe ser el primer elemento del arreglo y el
de la base el último). La pila original debe quedar sin modificaciones.

Solución A:
public static int[] pilaAArregloA(Stack<Integer> pila) {
    Object[] auxiliar = pila.toArray(); //Investigar que hace el metodo toArray
    int[] arreglo = new int[auxiliar.length];
    for (int i = 0; i < auxiliar.length; i++) {
        arreglo[i] = (Integer) auxiliar[i];
}
    return arreglo;
}

El método toArray() se usa para convertir una colección en un array.

Solución B:
public static int[] pilaAArregloB(Stack<Integer> pila) {
    int[] arreglo = new int[pila.size()];
    Stack<Integer> auxiliar = new Stack<>();
    int i = 0;
    while (!pila.isEmpty()) {
        int valor = pila.pop();
        arreglo[i] = valor;
        i++;
        auxiliar.push(valor);
}
    while (!auxiliar.isEmpty()) {
        pila.push(auxiliar.pop());
}
    return arreglo;
}

.size() Crea un arreglo de int cuyo tamaño sea igual a la cantidad de elementos que hay en pila.

Preguntas sobre el problema
1. ¿Cuál de las dos soluciones respeta mejor las restricciones del ejercicio? Tener en cuenta la restricción de
que "la pila original debe quedar sin modificaciones" y el orden de los elementos.
2. ¿Cuál solución es más fácil de explicar a un compañero? Argumentar sobre la claridad del uso de pilas
auxiliares (Solución B) frente a los métodos nativos de Java (Solución A).
3. ¿Qué ventajas y desventajas tiene cada una?

Respuestas

1. De las dos soluciones podemos ver que la Solución B es la que respeta mejor las restricciones del ejercicio. Si bien vemos que en la 
Solución A se cumple el tema de no modificar la pila, no estaría cumpliendo con la condición del orden de los elementos, ya que vemos que la solución A crea un array en donde se guardan los elementos de la pila tal cual aparecen en ella y no como nos lo piden con el primer elemento del array siendo el último elemento de la pila.

2. La solución más fácil de explicar a un compañero, sería la Solución A, debido a que mientras en la Solución B se hace uso de una pila auxiliar y sus atributos, en A lo que hacemos es hacer de la pila un array, recorrer sus elementos y a estos guardarlos en otro array de tipo int, no cumpliendo con la consigna pero siendo el más fácil de explicar.

3. Ventajas y Desventajas:
    Solución A:
        - No modifica la pila
        - No se requiere una pila auxiliar
        - Más fácil de implementar y de explicar
        - No cumple con los requerimientos del enunciado
    
    Solución B:
        - Trabaja con métodos de la pila
        - Utiliza una pila auxiliar
        - Cumple con los requerimientos del enunciado
        - Modifica la pila temporalmente
