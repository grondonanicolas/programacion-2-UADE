package org.uade.adt.definitions;

import org.uade.adt.dynamic.Counted;
import org.uade.adt.dynamic.CountedNode;
/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ICountedSet {

    /**
     * Postcondicion: Agrega un valor al conjunto o si existe aumenta en 1 su cantidad.
     *
     * @param a valor a agregar.
     */
    void add(int a);

    /**
     * Postcondicion: Agrega un valor al conjunto junto con la cantidad que se le quiere asignar.
     *
     * @param a valor a agregar.
     */

    void add(int a, int quantityToAdd);


    /**
     * Postcondicion: Quita el elemento indicado si su cantidad es 0, caso contrario elimina 1 de la cantidad del valor.
     *
     * @param a valor a quitar.
     */

    void remove(int a);

    /**
     * Postcondicion: Quita el elemento indicado si su cantidad es 0, caso contrario elimina una N cantidad del valor.
     *
     * @param a valor a quitar.
     */

    void remove(int a, int quantityToRemove);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el un elemento del conjunto.
     */
    Counted choose();
    /**
     * @return Devuelve el tamano del conjunto.
     */
    int size();
}