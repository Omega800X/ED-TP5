package ed.tp5.punto4;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ed.tp5.punto3.ArbolABBExt;

public class ClienteArbolABBExt {

    public static void main(String[] args) {
        ArbolABBExt<Integer> arbol = new ArbolABBExt();
        arbol.add(25);
        arbol.add(20);
        arbol.add(36);
        arbol.add(10);
        arbol.add(22);
        arbol.add(30);
        arbol.add(40);
        arbol.add(5);
        arbol.add(12);
        arbol.add(28);
        arbol.add(38);
        arbol.add(48);

        System.out.println("arbol: " + arbol);
        System.out.println("max(): " + arbol.max());
        System.out.println("min(): " + arbol.min());

        System.out.println("menorAntecesorComun(new NodoABB<Integer>(10), new NodoABB<Integer>(22)):");
        System.out.println(arbol.menorAntecesorComun(new NodoABB<Integer>(10), new NodoABB<Integer>(22)));

        System.out.println("eliminarRama(new NodoABB(36)): ");
        arbol.eliminarRama(new NodoABB(36));
        System.out.println(arbol);

    }
}
