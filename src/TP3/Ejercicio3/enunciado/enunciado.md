# ✏️ Ejercicio 3

## ❗ Enunciado

Dada una pila cargada con `N` números enteros generados de manera aleatoria, implementar lo siguiente:

1. Un método que reciba como parámetro una pila de enteros y un número `X`. El método debe eliminar
todos los elementos que sean divisores exactos de `X`. Los demás elementos deben mantenerse en la
pila en el mismo orden original.
2. Un método que reemplace todos los números impares de la pila por el número `0`, manteniendo la
posición de los elementos.
3. Un método que cuente la cantidad de elementos que son mayores al elemento que se encuentra en la
cima de la pila. La pila original no debe modificarse.
4. Un método que intercambie el elemento que se encuentra en la cima con el elemento que se
encuentra justo en la mitad de la pila.

### En el programa principal (main) se debe:

1. Solicitar al usuario la cantidad N de elementos, generarlos en forma aleatoria y cargarlos en la pila.
2. Mostrar la pila original por consola.
3. Ejecutar cada uno de los métodos implementados (solicitando al usuario el número X cuando
corresponda). Se debe mostrar el resultado o el estado de la pila antes y después de cada operación
para verificar que el orden y los valores se comportan según lo solicitado.

## 📌 Indicaciones

Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.\
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio. También necesita del objeto random para
generar valores de manera aleatoria.

## ❓ Preguntas sobre el problema

1. En el punto `4`, ¿qué sucede si la pila tiene un número par de elementos? ¿Cuál se considera la
"mitad"? ¿Qué pasa si la pila tiene 1 elemento o está vacía?
2. Si la pila (de base a cima) contiene `8, 2, 5 y 1;` sin ejecutar el programa: ¿Cuál es el resultado de
`contarMayoresQueCima`? ¿Cómo queda la pila después de intercambiar la cima con la mitad?
3. Para el punto `3`, se exige que la pila no se modifique. Si un compañero hace un `pop()` de todos los
elementos para contarlos y los mete en una pila auxiliar, ¿qué paso le falta para cumplir con la
consigna?
4. Si se quisiera agregar un método `ordenarPilaAscendente()`, que devuelva otra pila con los elementos
ordenados ascendentemente y que la pila original no se modifique ¿Se podría hacerlo usando una sola
pila auxiliar? Justifique.
