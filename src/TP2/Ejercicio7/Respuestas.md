## Respuestas del Punto 7

### 1. ¿Cuál de las dos soluciones respeta mejor las restricciones del ejercicio? Piense específicamente en la instrucción "devolver un nuevo arreglo". ¿Qué sucede con la Solución A si el arreglo original tiene 30 elementos y solo 2 son pares? ¿Qué contiene el arreglo devuelto por A en las posiciones no usadas?
La **Solución B** respeta mejor las restricciones del ejercicio.

La Solución A crea un arreglo con el mismo tamaño que el arreglo original (`nuevo = new int[arr.length]`). Si de 30 elementos solo 2 son pares, el arreglo devuelto tendrá una longitud de 30 posiciones, de las cuales solo las primeras 2 contendrán los números pares. Las 28 posiciones sobrantes contendrán el número `0`. La consigna dice "devuelva un nuevo arreglo que contenga únicamente los números pares del arreglo original", osea q si hay solo 2 pares tiene que devolver un arreglo SOLO con esos 2 pares.
---

### 2. ¿Cuál solución es más fácil de explicar a un compañero? Argumente sobre la claridad del código.
Para mi, la **Solución B** es más sencilla de explicar. Ya que divide el código en 2 partes y puedo explicar qué hace en cada parte y luego qué hace en conjunto.

---

### 3. ¿Qué ventajas y desventajas presenta cada solución? Haga referencia al consumo de memoria y la exactitud del tamaño del arreglo resultante.

#### Solución A
* **Ventajas:** 
  * Mayor rendimiento en tiempo de ejecución (hace una sola pasada al arreglo original, $O(N)$).
  * Código más corto, claro y conciso.
* **Desventajas:** 
  * Devuelve un arreglo cuya longitud no coincide con la cantidad real de elementos pares.
  * Desperdicia espacio en memoria para posiciones que no se utilizarán.

#### Solución B
* **Ventajas:** 
  * El arreglo resultante tiene exactamente la dimensión necesaria para almacenar los números pares encontrados.
  * No desperdicia memoria en el arreglo final devuelto.
* **Desventajas:** 
  * Mayor costo computacional al recorrer dos veces el arreglo original.
  * Redundancia de código en los bucles.

---

### 4. Si la consigna permitiera usar ArrayList en lugar de arreglo estático, ¿cuál de los dos problemas de diseño se resolvería automáticamente? Explique por qué.
Se resolvería automáticamente el problema del tamaño de la **Solución A** y el problema de redundancia en la **Solución B**. ArrayList ajusta automaticamente su tamaño a medida que se agregan elementos, por lo tanto podríamos utilizar la **Solucion A** con ArrayList y sería la mejor opcion.
