package ed.tp5.punto6;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import ed.tp5.punto5.ArbolAVLExt;

public class ClienteArbolAVLExt {

    public static void main(String[] args) {
        ArbolAVLExt<Integer> arbol = new ArbolAVLExt();
        arbol.add(25);
        arbol.add(20);
        arbol.add(36);

        System.out.println("arbol: " + arbol);

        String aux = "";

        Iterador<Integer> iteradorPreOrden = arbol.iteradorEnPreOrden();
        Iterador<Integer> iteradorPreOrdenInverso = arbol.iteradorPreOrdenInverso();
        Iterador<Integer> iteradorInOrden = arbol.iteradorEnInOrden();
        Iterador<Integer> iteradorInOrdenInverso = arbol.iteradorInordenInverso();
        Iterador<Integer> iteradorPosOrden = arbol.iteradorEnPosOrden();
        Iterador<Integer> iteradorPosOrdenInverso = arbol.iteradorPosordenInverso();
        
        System.out.println("Iterador preorden:");
        while (iteradorPreOrden.existeSiguiente()) {
            aux += iteradorPreOrden.siguiente() + " ";
        }
        System.out.println(aux);

        aux = "";

        System.out.println("Iterador preorden inverso:");
        while (iteradorPreOrdenInverso.existeSiguiente()) {
            aux += iteradorPreOrdenInverso.siguiente() + " ";
        }
        System.out.println(aux);
        
        aux = "";
        
        System.out.println("Iterador inorden:");
        while (iteradorInOrden.existeSiguiente()) {
            aux += iteradorInOrden.siguiente() + " ";
        }
        System.out.println(aux);
        
        aux = "";
        
        System.out.println("Iterador inorden inverso:");
        while (iteradorInOrdenInverso.existeSiguiente()) {
            aux += iteradorInOrdenInverso.siguiente() + " ";
        }
        System.out.println(aux);
        
        aux = "";
        
        System.out.println("Iterador posorden:");
        while (iteradorPosOrden.existeSiguiente()) {
            aux += iteradorPosOrden.siguiente() + " ";
        }
        System.out.println(aux);
        
        aux = "";
        
        System.out.println("Iterador posorden inverso:");
        while (iteradorPosOrdenInverso.existeSiguiente()) {
            aux += iteradorPosOrdenInverso.siguiente() + " ";
        }
        System.out.println(aux);
    }
}
