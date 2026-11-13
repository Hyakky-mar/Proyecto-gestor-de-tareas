package Sem_14;

public class Main {

    // Estructura del arbolito de navidad XD
    static class Nodo {
        int dato;
        Nodo izquierda;
        Nodo derecha;

        public Nodo(int valor) {
            this.dato = valor;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    //El root del arbolito
    static class ArbolBinarioBusqueda {
        private Nodo raiz;
        
        
        //Los metodos u bolitas de navidad del arbolito
        public ArbolBinarioBusqueda() {
            this.raiz = null;
        }
        
        public void insertar(int valor) {
            raiz = insertarRecursivo(raiz, valor);
        }

        private Nodo insertarRecursivo(Nodo actual, int valor) {
            if (actual == null) {
                return new Nodo(valor);
            }

            if (valor < actual.dato) {
                actual.izquierda = insertarRecursivo(actual.izquierda, valor);
            } else if (valor > actual.dato) {
                actual.derecha = insertarRecursivo(actual.derecha, valor);
            }
            return actual;
        }

        // Busqueda pi
        public boolean buscar(int valor) {
            return buscarRecursivo(raiz, valor);
        }

        private boolean buscarRecursivo(Nodo actual, int valor) {
            if (actual == null) {
                return false;
            }
            if (actual.dato == valor) {
                return true;
            }
            return valor < actual.dato
                    ? buscarRecursivo(actual.izquierda, valor)
                    : buscarRecursivo(actual.derecha, valor);
        }

        public void eliminar(int valor) {
            raiz = eliminarRecursivo(raiz, valor);
        }

        private Nodo eliminarRecursivo(Nodo actual, int valor) {
            if (actual == null) {
                return null;
            }

            if (valor < actual.dato) {
                actual.izquierda = eliminarRecursivo(actual.izquierda, valor);
            } else if (valor > actual.dato) {
                actual.derecha = eliminarRecursivo(actual.derecha, valor);
            } else {
                // Caso 1: Un solo Hijito
                if (actual.izquierda == null) {
                    return actual.derecha;
                } else if (actual.derecha == null) {
                    return actual.izquierda;
                }

                // Caso 2: Nodo con dos Hijitos
                actual.dato = encontrarMinimo(actual.derecha);
                actual.derecha = eliminarRecursivo(actual.derecha, actual.dato);
            }
            return actual;
        }

        private int encontrarMinimo(Nodo nodo) {
            int minimo = nodo.dato;
            while (nodo.izquierda != null) {
                minimo = nodo.izquierda.dato;
                nodo = nodo.izquierda;
            }
            return minimo;
        }

        // Calculo de seguridad
        // Altura: aristas desde la raíz hasta la hoja más lejana 
        public int calcularAltura() {
            return calcularAlturaRecursivo(raiz);
        }

        private int calcularAlturaRecursivo(Nodo actual) {
            if (actual == null) {
                return -1;
            }
            int alturaIzq = calcularAlturaRecursivo(actual.izquierda);
            int alturaDer = calcularAlturaRecursivo(actual.derecha);
            return 1 + Math.max(alturaIzq, alturaDer);
        }

        // Profundidad: aristas desde la raíz hasta el nodo buscado
        public int calcularProfundidad(int valor) {
            return calcularProfundidadRecursivo(raiz, valor, 0);
        }

        private int calcularProfundidadRecursivo(Nodo actual, int valor, int nivelActual) {
            if (actual == null) {
                return -1;
            }
            if (actual.dato == valor) {
                return nivelActual;
            }
            if (valor < actual.dato) {
                return calcularProfundidadRecursivo(actual.izquierda, valor, nivelActual + 1);
            }
            return calcularProfundidadRecursivo(actual.derecha, valor, nivelActual + 1);
        }

        // Método auxiliar para verificar ordenamiento
        public void mostrarInorden() {
            mostrarInordenRecursivo(raiz);
            System.out.println();
        }

        private void mostrarInordenRecursivo(Nodo actual) {
            if (actual != null) {
                mostrarInordenRecursivo(actual.izquierda);
                System.out.print(actual.dato + " ");
                mostrarInordenRecursivo(actual.derecha);
            }
        }

        public void limpiarArbol() {
            this.raiz = null; 
        }
    }

    // Probar operaciones con diferentes casos
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        //Insercion en el arbolito
        System.out.println("1. INSERCION DE NODOS");
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            abb.insertar(v);
        }
        System.out.print("Recorrido Inorden (ordenado): ");
        abb.mostrarInorden();

        //Busqueda en el arbolito
        System.out.println("\n2. BUSQUEDA ");
        System.out.println("Buscar 40: " + (abb.buscar(40) ? "Encontrado" : "No encontrado"));
        System.out.println("Buscar 99: " + (abb.buscar(99) ? "Encontrado" : "No encontrado"));

        //Altura del arbol
        System.out.println("\n3. ALTURA Y PROFUNDIDAD ");
        System.out.println("Altura total del arbol: " + abb.calcularAltura());
        System.out.println("Profundidad de la raiz (50): " + abb.calcularProfundidad(50));
        System.out.println("Profundidad del nodo (20): " + abb.calcularProfundidad(20));

        //Eliminacion en los 3 casos
        //-----------------------------------------------------------------------------------------
        System.out.println("\n 4. ELIMINACION (DIFERENTES CASOS) ");
        // Caso A: Eliminar hoja (20)
        System.out.println("Eliminando hoja (20)...");
        abb.eliminar(20);
        System.out.print("Inorden: ");
        abb.mostrarInorden();

        // Caso B: Eliminar nodo con un hijo (insertamos 25 bajo 30 y eliminamos 30)
        abb.insertar(25);
        System.out.println("Insertado 25. Eliminando nodo con un hijo (30)...");
        abb.eliminar(30);
        System.out.print("Inorden: ");
        abb.mostrarInorden();

        // Caso C: Eliminar nodo con dos hijos (la raiz 50)
        System.out.println("Eliminando nodo con dos hijos (50)...");
        abb.eliminar(50);
        System.out.print("Inorden: ");
        abb.mostrarInorden();

        // Caso D: Seguridad con arbol vacio (prevencion de NullPointerException)
        abb.limpiarArbol();
        System.out.println("\n 5. PRUEBA CON ARBOL VACIO ");
        System.out.println("Altura arbol vacio: " + abb.calcularAltura());
        System.out.println("Buscar en arbol vacio: " + (abb.buscar(10) ? "Si" : "No"));
        //----------------------------------------------------------------------------------------
    }
}