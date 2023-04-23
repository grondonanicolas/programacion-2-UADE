package org.uade.exercise2;

import java.lang.reflect.Type;

public interface IGenericQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     * @param a valor a acolar.
     */
    void add(Type a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    Type getFirst();
}
