package TP4.common;

public class Queue<ELEMENT> {

    private final static Integer defaulDimension = 10;

    private ELEMENT[] data;
    private int head;
    private int tail;
    private int count;

    // Constructor con capacidad por defecto
    public Queue() {
        this(Queue.defaulDimension);
    }

    // Constructor con capacidad indicada
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    // Calcula la siguiente posición circular dentro del arreglo
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }

    // Encola un elemento al final de la cola
    public boolean add(ELEMENT element) {
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    // Devuelve el primer elemento de la cola sin sacarlo, o null si está vacía
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }

        return this.data[this.head];
    }

    // Saca y devuelve el primer elemento de la cola, o null si está vacía
    public ELEMENT poll() {
        if (this.size() <= 0) {
            return null;
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    // Saca y devuelve el primer elemento de la cola, lanza excepción si está vacía
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    // Devuelve el contenido de la cola como texto
    @Override
    public String toString() {
        if (this.size() <= 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }

    // Indica si la cola no tiene elementos
    public boolean isEmpty() {
        return this.count <= 0;
    }

    // Devuelve la cantidad de elementos en la cola
    public int size() {
        return this.count;
    }

    // Une dos colas en una nueva (estático)
    public static Queue<Object> union(Queue<?> cola1, Queue<?> cola2) {
        Queue<Object> result = new Queue<Object>(cola1.size() + cola2.size());

        for (int pos = cola1.head, cta = cola1.size(); cta > 0; pos = cola1.next(pos), --cta) {
            result.add(cola1.data[pos]);
        }
        for (int pos = cola2.head, cta = cola2.size(); cta > 0; pos = cola2.next(pos), --cta) {
            result.add(cola2.data[pos]);
        }

        return result;
    }

    // Une esta cola con otra (versión de instancia)
    public Queue<Object> union(Queue<?> cola2) {
        return Queue.union(this, cola2);
    }
}