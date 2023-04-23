package org.uade.exercise2;

import java.lang.reflect.Type;

public interface IGenericStack {

    //JavaDoc
    /**
     * Precondicion: Solo se puede agregar un elemento si la pila esta inicializada.
     * Postcondicion: el elemento se coloca como tope
     * @param a un numero arbitrario
     */

    void add(Type a); // apilar

    void remove(); //desapilar

    /**
     * Precodincion: La pila debe estar inicializada
     * Postcondicion: Se va a indicar si la pila esta vacia
     * @return true si la pila esta vacia
     */

    boolean isEmpty(); // es vacia

    Type getTop(); // obtener el tope
}
