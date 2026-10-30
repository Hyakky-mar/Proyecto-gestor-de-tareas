package Sem_12;

public class ColaArregloCircular {
    private int[] datos;
    private int frente = 0, fin = 0, tamano = 0, capacidad;

    public ColaArregloCircular(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
    }

    public void enqueue(int elemento) {
        if (tamano == capacidad) throw new RuntimeException("Cola llena");
        datos[fin] = elemento;
        fin = (fin + 1) % capacidad;
        tamano++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        int valor = datos[frente];
        frente = (frente + 1) % capacidad;
        tamano--;
        return valor;
    }

    public boolean isEmpty() {
        return tamano == 0;
    }
}