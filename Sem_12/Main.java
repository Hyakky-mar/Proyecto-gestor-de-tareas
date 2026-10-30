package Sem_12;

import java.util.Iterator;

public class Main {public static void main(String[] args) {
    int n = 10000;
    long a = 0;
    long b = 0;
    long c = 0;
    
    ColaArregloCircular arrCir = new ColaArregloCircular(n);
    long t1 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) arrCir.enqueue(n);
    for (int i = 0; i < n; i++) arrCir.dequeue();
    a = System.currentTimeMillis() - t1;
    System.out.println("El rapidin del Circular termina en "+a+"ms");
    
    ColaLista L1 = new ColaLista();
    long t2 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) L1.enqueue(n);
    for (int i = 0; i < n; i++) L1.dequeue();
    b = System.currentTimeMillis() - t2; 
    System.out.println("El rapidin de la Lista termina en "+b+"ms");
    
    ColaPrioridad L2 = new ColaPrioridad();
    long t3 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) L2.enqueue(i, (int)(Math.random() * n));
    for (int i = 0; i < n; i++) L2.dequeue();
    c = System.currentTimeMillis() - t3;
    System.out.println("El rapidin de la Lista con Prioridad termina en "+c+"ms");
    
    long menor;
    if (a <= b && a <= c) {
        menor = a;
    } else if (b <= a && b <= c) {
        menor = b;
    } else {
        menor = c;
    }

    System.out.println("El menor tiempo de ejecución fue: " + menor + " ms");
}
}