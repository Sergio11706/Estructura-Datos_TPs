1) ¿Cuál de las dos respeta mejor las restricciones del ejercicio? Tenga en cuenta que la cola debe quedar "sin modificaciones". ¿Mantiene la Solución A el orden original de los elementos? 
¿Mantiene la Solución B el orden original?

- Ambas dejan la cola con el mismo contenido y en el mismo orden al finalizar, porque las dos respetan el orden FIFO a la hora de remover e ingreesar los datos, por lo tanto, el resultado final es idéntico al original en ambos casos.


2) Explique qué ocurre internamente con los índices head y tail en la Solución B al momento de desencolar de la cola original y encolar en la auxiliar.

- En la Solución B, al desencolar los elementos de la cola original con remove(), el índice head avanza una posición por cada llamada hasta alcanzar la posición donde se encontraba tail, dejando la cola vacía (head == tail), pero en un índice físico distinto al que tenía head originalmente. Mientras tanto, en la cola auxiliar el índice tail avanza en cada add() a medida que se van insertando los elementos removidos. Finalmente, al volver a insertar esos elementos en la cola original mediante add(), el tail de la cola original avanza nuevamente desde la posición donde quedó, N veces más. Por lo tanto, head y tail no vuelven a sus posiciones físicas originales dentro del arreglo interno (salvo coincidencia si N es múltiplo del tamaño del arreglo); lo que sí se conserva es el orden lógico y el contenido de la cola, que es lo relevante desde el punto de vista del usuario de la estructura.


3) ¿Qué ventajas y desventajas tiene cada una? Mencione el consumo de memoria

- La principal ventaja de la solución A es que consume menos memoria debido a que no realizar autoboxing, esto ocurre porque se implementa un arreglo de enteros (int es un tipo de dato primitivo). 
Por otro lado, en la solución B se produce overhead de memoria, dado que la cola se implementa con objetos Integer boxeados, además de que su estructura interna se compone de indices head y tail.