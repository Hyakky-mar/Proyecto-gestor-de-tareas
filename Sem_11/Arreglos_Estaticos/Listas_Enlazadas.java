package Arreglos_Estaticos;

public class Listas_Enlazadas {
	
    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public Listas_Enlazadas() {
        this.cabeza = null;
    }

    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Elemento " + dato + " agregado a la lista.");
    }

    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("Lista Enlazada: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Listas_Enlazadas miLista = new Listas_Enlazadas();
        miLista.agregar(100);
        miLista.agregar(200);
        miLista.agregar(300);

        miLista.mostrar();
    }

}
