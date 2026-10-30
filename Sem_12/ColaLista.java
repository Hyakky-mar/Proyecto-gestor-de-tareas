package Sem_12;

public class ColaLista {
    private class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int d) { dato = d; }
    }

    private Nodo frente, fin;

    public void enqueue(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (isEmpty()) frente = nuevo;
        else fin.siguiente = nuevo;
        fin = nuevo;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacia");
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return valor;
    }

    public boolean isEmpty() {
        return frente == null;
    }
}