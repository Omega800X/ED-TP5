package ed.tp5.punto5;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolAVL;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author Fer
 */
public class ArbolAVLExt<T extends Comparable<T>> extends ArbolAVL<T> implements ArbolAVLExtInterfaz<T> {

    @Override
    public Iterador<T> iteradorPreOrdenInverso() {

        if (isEmpty()) {
            throw new IllegalStateException("Arbol vací­o");
        }

        return generarRecorridoPreOrdenInverso().iterador();
    }

    @Override
    public Iterador<T> iteradorInordenInverso() {

        if (isEmpty()) {
            throw new IllegalStateException("Arbol vací­o");
        }

        return generarRecorridoInOrdenInverso().iterador();
    }

    @Override
    public Iterador<T> iteradorPosordenInverso() {

        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacÃ­o");
        }

        return generarRecorridoPosOrdenInverso().iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorridoPreOrdenInverso() {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbolPreOrdeninverso(this.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbolPreOrdeninverso(NodoABB<T> nodoActual) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addToRear(nodoActual.getValor());

        if (nodoActual.tieneHijoDerecho()) {
            resultado.addAll(agregarSubArbolPreOrdeninverso(nodoActual.getHijoDerecho()));
        }

        if (nodoActual.tieneHijoIzquierdo()) {
            resultado.addAll(agregarSubArbolPreOrdeninverso(nodoActual.getHijoIzquierdo()));
        }

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorridoInOrdenInverso() {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarNodosInOrdenInverso(this.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarNodosInOrdenInverso(NodoABB<T> nodo) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if (nodo.tieneHijoDerecho()) {
            resultado.addAll(agregarNodosInOrdenInverso(nodo.getHijoDerecho()));
        }

        resultado.addToRear(nodo.getValor());

        if (nodo.tieneHijoIzquierdo()) {
            resultado.addAll(agregarNodosInOrdenInverso(nodo.getHijoIzquierdo()));
        }

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorridoPosOrdenInverso() {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbolPosOrdenInverso(this.getRaiz()));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbolPosOrdenInverso(NodoABB<T> nodoActual) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if (nodoActual.tieneHijoDerecho()) {
            resultado.addAll(agregarSubArbolPosOrdenInverso(nodoActual.getHijoDerecho()));
        }

        if (nodoActual.tieneHijoIzquierdo()) {
            resultado.addAll(agregarSubArbolPosOrdenInverso(nodoActual.getHijoIzquierdo()));
        }

        resultado.addToRear(nodoActual.getValor());

        return resultado;
    }
}
