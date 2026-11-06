package Sem_13;

public class Arboles_Binarios {

    public static class Nodo {
        int valor;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(int valor) {
            this.valor = valor; 
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    private Nodo raiz; //La raiz dorada de el arbolito

    public Arboles_Binarios() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // Inserción BST convencional
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor); //Llama el siguiente metodo para ingresar los datos
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {//Para que no explote otra vez
            return new Nodo(valor);
        }

        if (valor < nodo.valor) { //Decide donde va el dato
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }


    // 1. Recorrido Preorden (Raíz -> Izquierda -> Derecha)
    public void preorden(Nodo nodo) {
        if (nodo == null) return; 
        System.out.print(nodo.valor + " ");
        preorden(nodo.izquierdo);
        preorden(nodo.derecho);
    }

    // 2. Recorrido Inorden (Izquierda -> Raíz -> Derecha)
    public void inorden(Nodo nodo) {
        if (nodo == null) return; 
        inorden(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        inorden(nodo.derecho);
    }

    // 3. Recorrido Postorden (Izquierda -> Derecha -> Raíz)
    public void postorden(Nodo nodo) {
        if (nodo == null) return; 
        postorden(nodo.izquierdo);
        postorden(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }
}