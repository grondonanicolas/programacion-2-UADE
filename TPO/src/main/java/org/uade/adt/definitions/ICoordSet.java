package org.uade.adt.definitions;

import org.uade.adt.dynamic.Coord;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ICoordSet {

    /**
     * Postcondicion: Agrega un valor al conjunto .
     *
     * @param a valor a agregar.
     */
    void add(double x, double y);

    /**
     * Postcondicion: Quita el elemento indicado si existe, de lo contrario no hace nada.
     *
     * @param a valor a quitar.
     */
    void remove(double x, double y);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();
    /**
     * @return Devuelve el un elemento del conjunto.
     */
    Coord choose();

}
