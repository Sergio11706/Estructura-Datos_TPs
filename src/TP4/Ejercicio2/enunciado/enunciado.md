# ✏️ Ejercicio 2

## 📌 Enunciado

Implementar una clase `ColaCircular` que utilice un arreglo para gestionar una cola de tamaño fijo de manera
circular que priorice velocidad. Usando la cola anterior, simule que la misma está cargada con códigos de
documentos pendientes de impresión. Varias impresoras atienden la cola, para ello toman el primer
documento disponible y lo procesan (sacar de la cola). Si el código del documento es un número par,
significa que es de alta prioridad y debe ser enviado a una segunda cola para ser impreso en una impresora
a color. Si es impar, se imprime en blanco y negro y se descarta del proceso.
Procesar la segunda cola cuando esté disponible. Contar cuántos documentos tienen un código par y se
encuentran en la segunda cola.

### En el programa principal (main) se debe:
1. Solicitar al usuario el tamaño de la cola circular y cargarla con códigos numéricos.

2. Simular el procesamiento de las impresoras, mostrando qué documentos van a la cola de color y cuáles
se descartan.

3. Mostrar el total de documentos encolados en la segunda impresora (color).

4. Cuando se recorran los elementos de la cola esta debe mantenerse sin modificaciones.

---

## ❗ Indicaciones
Este ejercicio necesita del objeto `scanner` para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado./
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.

---

## ❓ Preguntas sobre el problema a resolver
1. ¿Por qué se utiliza un arreglo circular en lugar de un arreglo común para implementar una Cola? ¿Qué
problema de desplazamiento de elementos resuelve?

2. En una cola circular de tamaño 5, si el frente (head) está en el índice 4 y se desencola un elemento, ¿en
qué índice queda el nuevo frente? ¿Qué método se utiliza para lograr esto sin salirse del arreglo?

3. Un compañero propone implementar la cola circular moviendo todos los elementos un lugar hacia
adelante cada vez que se saca uno. ¿Qué ventajas y desventajas tiene esta alternativa frente al uso de
los indices head y tail?
