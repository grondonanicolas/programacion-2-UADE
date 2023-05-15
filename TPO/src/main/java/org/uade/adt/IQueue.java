package org.uade.adt;

public interface IQueue {

    //JavaDoc
    /**
     * Precondicion: Solo se puede agregar un elemento si la cola esta inicializada.
     * Postcondicion: el elemento se coloca como tope
     * @param a un numero arbitrario
     */

    void add(int a); // acolar

    void remove(); //desacolar

    /**
     * Precodincion: La cola debe estar inicializada
     * Postcondicion: Se va a indicar si la cola esta vacia
     * @return true si la cola esta vacia
     */

    boolean isEmpty();

    int getTop();
}
