package Arreglos_Estaticos;

public class Arreglos_Estaticos {
	private int[] arreglo;
    private int capacidad;
    private int contador;

    public Arreglos_Estaticos(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.contador = 0;
    }

    public void insertar(int elemento) {
        if (contador < capacidad) {
            arreglo[contador] = elemento;
            contador++;
            System.out.println("Elemento " + elemento + " insertado.");
        } else {
            System.out.println("Error: El arreglo estático está lleno.");
        }
    }

    public void mostrar() {
        System.out.print("Arreglo Estático: [ ");
        for (int i = 0; i < contador; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Arreglos_Estaticos miArreglo = new Arreglos_Estaticos(3);
        miArreglo.insertar(10);
        miArreglo.insertar(20);
        miArreglo.insertar(30);
        miArreglo.insertar(40); 

        miArreglo.mostrar();
    }

}
