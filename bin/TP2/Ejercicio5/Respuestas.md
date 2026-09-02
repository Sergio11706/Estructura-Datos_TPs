**a) Para resolver este ejercicio ¿Sería conveniente crear un arreglo de 1000 posiciones? ¿Cuáles serían las ventajas y desventajas de esta implementación?**

No conviene. La única ventaja es que es fácil de programar, pero la desventaja es que desperdicio mucha memoria si guardo pocos libros, y me quedo corto si paso los 1000. Lo mejor es usar un `ArrayList` que ajusta su tamaño solo.

---

**b) ¿Qué ocurre si se intenta eliminar un libro cuyo ISBN no existe en la biblioteca? ¿Cómo debe responder el programa?**

El programa no tiene que romperse. Solo tengo que validar si existe el ISBN; si no está, simplemente muestro un mensaje de "Libro no encontrado" y vuelvo al menú principal.

---

**c) Si la biblioteca tiene 3 libros y se elimina el libro de la posición 1 (el del medio), sin ejecutar el programa: ¿Qué índice le corresponde al libro que antes estaba en la posición 2?**

Pasa a ocupar el **índice 1**. Al borrar un elemento del medio, los que están a la derecha se corren un lugar a la izquierda para no dejar huecos vacíos en la lista.

---

**d) Un compañero propone que para el punto c), en lugar de modificar el objeto existente, se elimine el libro viejo y se agregue uno nuevo con los datos actualizados. ¿Qué ventajas y desventajas tiene esta alternativa frente a usar los métodos `setAutor()` o `setAnio()`?**

Es mala idea porque es ineficiente: tendría que borrarlo (moviendo toda la lista), crear un objeto nuevo en memoria y volver a insertarlo. Es mucho más directo y rápido usar `setAutor()` o `setAnio()` para cambiar solo el dato que necesito del libro que ya tengo guardado.