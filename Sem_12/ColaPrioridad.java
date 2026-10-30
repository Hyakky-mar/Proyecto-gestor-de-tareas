package Sem_12;

import java.util.ArrayList;

public class ColaPrioridad {
    private class Elemento {
        int valor, prioridad;
        Elemento(int v, int p) { valor = v; prioridad = p; }
    }

    private ArrayList<Elemento> lista = new ArrayList<>();

    public void enqueue(int valor, int prioridad) {
        lista.add(new Elemento(valor, prioridad));
    }

    public int dequeue() {
        if (lista.isEmpty()) throw new RuntimeException("Cola vacia");
        
        int indiceMayor = 0;
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).prioridad < lista.get(indiceMayor).prioridad) {
                indiceMayor = i;
            }
        }
        return lista.remove(indiceMayor).valor;
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
}