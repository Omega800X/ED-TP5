package ed.tp5.punto3;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;
import java.util.ArrayList;
import java.util.List;

public class ArbolABBExt<T extends Comparable<T>> extends ArbolABB<T> implements ArbolABBExtInterfaz<T> {

    @Override
    public T min() {

        if (this.isEmpty()) {
            throw new IllegalStateException("La estructura no puede estar vacía.");
        }

        NodoABB<T> nodoAux = this.getRaiz();

        while (nodoAux.tieneHijoIzquierdo()) {
            nodoAux = nodoAux.getHijoIzquierdo();
        }

        return nodoAux.getValor();
    }

    @Override
    public T max() {

        if (this.isEmpty()) {
            throw new IllegalStateException("La estructura no puede estar vacía.");
        }

        NodoABB<T> nodoAux = this.getRaiz();

        while (nodoAux.tieneHijoDerecho()) {
            nodoAux = nodoAux.getHijoDerecho();
        }

        return nodoAux.getValor();
    }

    @Override
    public void eliminarRama(NodoABB<T> nodo) {

        if (this.isEmpty()) {
            throw new IllegalStateException("La estructura no puede estar vacía.");
        }

        if (!this.contiene(nodo.getValor())) {
            throw new IllegalArgumentException("La estructura no contiene al nodo.");
        }

        if (nodo.equals(this.getRaiz())) {
            this.raiz = null;
        }

        NodoABB<T> aux = this.getRaiz();

        while (aux.getCantidadHijos() != 0) {

            if (aux.tieneHijoDerecho() && aux.getHijoDerecho().equals(nodo)) {
                aux.setHijoDerecho(null);
                break;
            }

            if (aux.tieneHijoIzquierdo() && aux.getHijoIzquierdo().equals(nodo)) {
                aux.setHijoIzquierdo(null);
                break;
            }

            if (nodo.getValor().compareTo(aux.getValor()) > 0) {
                aux = aux.getHijoDerecho();
            }

            if (nodo.getValor().compareTo(aux.getValor()) < 0) {
                aux = aux.getHijoIzquierdo();
            }
        }
    }

    @Override
    public NodoABB<T> menorAntecesorComun(NodoABB<T> x, NodoABB<T> y) {
        if (this.isEmpty()) {
            throw new IllegalStateException("La estructura no puede estar vacía.");
        }

        if (!this.contiene(x.getValor()) || !this.contiene(y.getValor())) {
            throw new IllegalArgumentException("La estructura no contiene alguno de los nodos.");
        }

        List<NodoABB<T>> listaAuxX = recorridoHasta(x);
        List<NodoABB<T>> listaAuxY = recorridoHasta(y);

        listaAuxX.retainAll(listaAuxY);

        return listaAuxX.get(listaAuxX.size() - 1);
    }

    private boolean contiene(T valor) {

        Iterador<T> iterador = this.iteradorEnPosOrden();
        List<T> listaAux = new ArrayList();

        while (iterador.existeSiguiente()) {
            listaAux.add(iterador.siguiente());
        }

        return listaAux.contains(valor);
    }

    private List<NodoABB<T>> recorridoHasta(NodoABB<T> nodo) {

        List<NodoABB<T>> resultado = new ArrayList();
        resultado.add(this.getRaiz());
        NodoABB<T> aux = this.getRaiz();

        while (!aux.equals(nodo)) {

            if (nodo.getValor().compareTo(aux.getValor()) > 0) {
                aux = aux.getHijoDerecho();
                resultado.add(aux);
            }

            if (nodo.getValor().compareTo(aux.getValor()) < 0) {
                aux = aux.getHijoIzquierdo();
                resultado.add(aux);
            }
        }

        return resultado;
    }
}
