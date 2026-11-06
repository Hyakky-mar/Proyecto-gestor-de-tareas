package Sem_13;

public class main {
	public static void main(String[] args) {
		long t1;
    	long t2;
        Arboles_Binarios arbolB = new Arboles_Binarios();
        int[] datosB = {50, 30, 70, 20, 40, 60, 80};

        for (int v : datosB) {arbolB.insertar(v);}

        System.out.println("PRUEBA 1: Árbol Binario");
        System.out.println("La raiz es ["+arbolB.getRaiz().valor+"]");
        System.out.println("Los valores son:");
        for (int i : datosB) {System.out.print("["+i+"]");}
        System.out.println();
        System.out.println("_____________________________________________");
        
        System.out.print("Preorden : ");
        t1=System.nanoTime();
        arbolB.preorden(arbolB.getRaiz());
        t2=System.nanoTime();
        System.out.println();
        System.out.println("El tiempo es de:"+(t2-t1)+"ms");
        System.out.println();

        System.out.print("Inorden  : ");
        t1=System.nanoTime();
        arbolB.inorden(arbolB.getRaiz());
        t2=System.nanoTime();
        System.out.println();
        System.out.println("El tiempo es de:"+(t2-t1)+"ms");
        System.out.println();

        System.out.print("Postorden: ");
        t1=System.nanoTime();
        arbolB.postorden(arbolB.getRaiz());
        t2=System.nanoTime();
        System.out.println();
        System.out.println("El tiempo es de:"+(t2-t1)+"ms");
        System.out.println("\n");
	}

}
