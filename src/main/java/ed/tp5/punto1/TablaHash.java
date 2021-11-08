package ed.tp5.punto1;

import java.lang.reflect.Array;
import java.util.Objects;

public class TablaHash<K, T> implements TablaHashInterfaz<K, T> {

    private Entrada<K, T>[] entradas;
    private MetodoColisionEnum metodo;

    public TablaHash(int tamanio, MetodoColisionEnum metodo) {
        this.entradas = (Entrada<K, T>[]) Array.newInstance(Entrada.class, tamanio);
        this.metodo = metodo;
    }

    @Override
    public void put(K clave, T valor) {

        if (clave == null || valor == null) {
            throw new IllegalArgumentException("La clave o el valor no puede ser una referencia nula.");
        }

        if (this.isFull()) {
            return;
        }

        int direccionBase = Objects.hashCode(clave) % entradas.length;

        if (entradas[direccionBase] == null) {
            entradas[direccionBase] = new Entrada(clave, valor);
        } else {
            if (metodo.equals(MetodoColisionEnum.LINEAL)) {
                entradas[pruebaLineal(direccionBase)] = new Entrada(clave, valor);
            } else {
                entradas[pruebaCuadratica(direccionBase)] = new Entrada(clave, valor);
            }
        }
    }

    @Override
    public void remove(K clave) {

        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser una referencia nula.");
        }

        if (!contains(clave)) {
            throw new IllegalArgumentException("La clave no existe en la estructura.");
        }

        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i] != null && entradas[i].getClave().equals(clave)) {
                entradas[i] = null;
            }
        }

    }

    @Override
    public T get(K clave) {

        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser una referencia nula.");
        }

        if (!contains(clave)) {
            throw new IllegalArgumentException("La clave no existe en la estructura.");
        }

        T resultado = null;

        for (var entrada : entradas) {
            if (entrada != null) {
                if (entrada.getClave().equals(clave)) {
                    resultado = entrada.getValor();
                }
            }
        }

        return resultado;
    }

    @Override
    public boolean contains(K clave) {

        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser una referencia nula.");
        }

        for (var entrada : entradas) {
            if (entrada != null) {
                if (entrada.getClave().equals(clave)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < entradas.length; i++) {
            entradas[i] = null;
        }
    }

    @Override
    public int size() {
        return entradas.length;
    }

    @Override
    public boolean isFull() {
        boolean isFull = true;

        for (var valor : entradas) {
            if (valor == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private int pruebaLineal(int direccionBase) {

        int j = 0;
        int direccionPrueba = 0;

        while (entradas[direccionPrueba] != null) {
            direccionPrueba = direccionBase;
            j += 1;
            direccionPrueba += j;
            direccionPrueba = direccionPrueba % entradas.length;
        }

        return direccionPrueba;
    }

    private int pruebaCuadratica(int direccionBase) {

        int j = 0;
        int direccionPrueba = 0;

        while (entradas[direccionPrueba] != null) {
            direccionPrueba = direccionBase;
            j += 1;
            direccionPrueba += j * j;
            direccionPrueba = direccionPrueba % entradas.length;

        }
        return direccionPrueba;
    }

    @Override
    public String toString() {
        String texto = "";

        for (var entrada : entradas) {
            texto += entrada + " ";
        }

        return texto;
    }

}
