**a) ¿Qué validaciones se deben contemplar al buscar un idEquipo en el punto a)? ¿Qué ocurre si el equipo no existe en el arreglo?**

Debo validar que el ID ingresado sea un número entero para evitar que el programa se rompa por un error de tipo de dato (`InputMismatchException`). Si el ID no existe en el arreglo, simplemente muestro un mensaje avisando que el equipo no fue encontrado y dejo que el programa continúe normalmente sin modificar nada.

---

**b) Compruebe el funcionamiento del programa cuando todos los equipos tengan exactamente el mismo puntajeAcumulado. ¿Qué debería mostrar el punto d) y el punto e) en este escenario?**

* **Punto d (El líder):** Me mostrará como líder al primer equipo que ingresé, ya que los siguientes tienen el mismo puntaje y no lo superan.
* **Punto e (Zona de descenso):** No me mostrará ningún equipo. Al tener todos el mismo puntaje, el promedio es igual a ese puntaje, y la condición exige que los puntos sean estrictamente menores al promedio para descender.

---

**c) El cálculo del promedio general (punto c) es necesario para resolver el punto e). ¿Por qué es conveniente crear un método `calcularPromedio()` en lugar de repetir el código?**

Para no repetir código innecesariamente. Al usar un método específico, mi código queda mucho más limpio y fácil de leer. Además, si en el futuro necesito cambiar cómo se calcula el promedio, solo lo modifico en un solo lugar y me sirve para reutilizarlo en otras partes del programa.

---

**d) Si se quisiera agregar el método `obtenerEquipoConMenosPuntos()`, ¿Se necesitaría crear un nuevo arreglo o solo recorrer el existente comparando valores?**

Solo necesito recorrer el arreglo que ya existe. No hace falta crear uno nuevo porque los datos ya están guardados; basta con usar una variable temporal que vaya guardando al equipo con el puntaje más bajo a medida que voy recorriendo la lista.