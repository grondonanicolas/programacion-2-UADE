package org.uade.adt.dynamic;

import org.uade.adt.dynamic.CountedNode;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ICountedSet {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     *
     * @param a valor a agregar.
     */
    void add(int a);

    /**
     * Postcondicion: Quita el elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(int a);
    void remove(int a, int quantity_to_remove);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el un elemento del conjunto.
     */
    CountedNode choose();

}
