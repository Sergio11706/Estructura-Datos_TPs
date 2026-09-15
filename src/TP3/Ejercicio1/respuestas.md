### a) Pilas auxiliares necesarias
Uso **1 sola pila auxiliar**. Cuando saco los números de la original y los paso a la auxiliar quedan al revés, y al volver a pasarlos a la original recuperan el orden exacto en el que estaban.

---

### b) Si todos son negativos y manejo de pila vacía
* La pila `positivos` queda vacía (`isEmpty() == true`). Si intento hacer un `pop()` o `peek()` me va a tirar un error `EmptyStackException` y se me cierra el programa.
* Lo controlo poniendo un `if (positivos.isEmpty())` antes de buscar el máximo/mínimo para mostrar un cartel avisando que no hay elementos, en vez de desapilar directamente.

---

### c) Pila con [-30, 10, -5, 3]
* **No se ejecutó bien**, porque el `-30` no entra en el rango de -20 a 20 que pedía el enunciado.
* Si igual lo procesara, de cima a base quedarían así:
  * `positivos`: `[3, 10]`
  * `negativos`: `[-5, -30]`

---

### d) ¿Por qué pilas y no ArrayList o for?
Porque la consigna pide trabajar con el **TAD Pila** (LIFO). Si uso un `for` o un `ArrayList` estoy accediendo a los datos por índice y rompiendo la gracia de la pila, donde la única forma válida de tocar los datos es por el tope (`pop` y `push`).