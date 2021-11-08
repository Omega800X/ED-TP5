package ed.tp5.punto5;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 * Árbol de ejemplo (A) (B) (C)
 */
public interface ArbolAVLExtInterfaz<T> {

    /**
     * Define un iterador en preorden inverso para el árbol AVL. Para el ejemplo
     * el iterador en preorden inverso devuelve: A, C, B.
     *
     * @return
     */
    public Iterador<T> iteradorPreOrdenInverso();

    /**
     * Define un iterador en inorden inverso para el árbol AVL. Para el ejemplo
     * el iterador en inorden inverso devolverá: C, A, B.
     *
     * @return
     */
    public Iterador<T> iteradorInordenInverso();

    /**
     * Define un iterador en posorden inverso para el árbol AVL. Para el ejemplo
     * el iterador en posorden inverso devuelve: C, B, A.
     *
     * @return
     */
    public Iterador<T> iteradorPosordenInverso();
}
