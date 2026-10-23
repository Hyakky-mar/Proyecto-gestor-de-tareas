package Sem_11;

public class Arreglos_Estaticos {
	private int[] arreglo;
    private int capacidad;
    private int tope; 

    public Arreglos_Estaticos(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.tope = -1; 
    }

    public void push(int elemento) {
        if (tope == capacidad - 1) {
            System.out.println("Error: La pila está llena (Rellenita). No se puede agregar " + elemento);
            return;
        }
        tope++;
        arreglo[tope] = elemento;
        System.out.println("Push: " + elemento);
    }

    public int pop() {
        if (tope == -1) {
            System.out.println("Error: La pila está vacía (Underflow).");
            return -1; 
        }
        int elementoExtraido = arreglo[tope];
        tope--;
        System.out.println("Pop: " + elementoExtraido);
        return elementoExtraido;
    }

    public void mostrar() {
        if (tope == -1) {
            System.out.println("Pila vacía.");
            return;
        }
        System.out.print("Estado de la Pila (Arreglo): [ ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("] <- Tope");
    }

    public static void main(String[] args) {
        Arreglos_Estaticos pilaArreglo = new Arreglos_Estaticos(3);

        pilaArreglo.push(10);
        pilaArreglo.push(20);
        pilaArreglo.push(30);
        pilaArreglo.push(40); 

        pilaArreglo.mostrar();

        pilaArreglo.pop();
        pilaArreglo.mostrar();
    }

}
