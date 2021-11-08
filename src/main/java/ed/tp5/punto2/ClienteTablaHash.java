package ed.tp5.punto2;

import ed.tp5.punto1.MetodoColisionEnum;
import ed.tp5.punto1.TablaHash;

public class ClienteTablaHash {

    public static void main(String[] args) {
        TablaHash<Integer, Integer> tabla = new TablaHash(10, MetodoColisionEnum.LINEAL); //para realizar pruebas cuadráticas cambiar LINEAL por CUADRATICO

        System.out.println("put(99, 222): ");
        tabla.put(99, 222);

        System.out.println("put(199, 22): "); //colisión;
        tabla.put(199, 22);

        System.out.println("put(299, 32): "); //colisión;
        tabla.put(299, 32);

        System.out.println("put(399, 42): "); //colisión;
        tabla.put(399, 42);

        System.out.println("tabla: " + tabla);

        System.out.println("isFull():" + tabla.isFull());

        System.out.println("get(299): " + tabla.get(299));

        System.out.println("contains(399): " + tabla.contains(399));

        System.out.println("size(): " + tabla.size());

        System.out.println("remove(99): ");
        tabla.remove(99);
        System.out.println("tabla: " + tabla);

        
        System.out.println("makeEmpty(): ");
        tabla.makeEmpty();
        System.out.println("tabla: " + tabla);
    }
}
