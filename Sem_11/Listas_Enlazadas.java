package Sem_11;

public class Listas_Enlazadas {
	
	private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo tope; 

    public Listas_Enlazadas() {
        this.tope = null;
    }

    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        System.out.println("Push: " + dato);
    }

    public int pop() {
        if (tope == null) {
            System.out.println("Error: La pila está vacía (Underflow).");
            return -1;
        }
        int elementoExtraido = tope.dato;
        tope = tope.siguiente; 
        System.out.println("Pop: " + elementoExtraido);
        return elementoExtraido;
    }

    public void mostrar() {
        if (tope == null) {
            System.out.println("Pila vacía.");
            return;
        }
        Nodo actual = tope;
        System.out.print("Estado de la Pila (Lista): Tope -> ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Listas_Enlazadas pilaLista = new Listas_Enlazadas();

        pilaLista.push(100);
        pilaLista.push(200);
        pilaLista.push(300);

        pilaLista.mostrar();

        pilaLista.pop();
        pilaLista.mostrar();
    }
}
