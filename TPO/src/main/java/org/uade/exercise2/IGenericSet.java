package org.uade.exercise2;

import java.lang.reflect.Type;

public interface IGenericSet {

    /**
     * Postcondition: Adds a value to the set.
     * @param a value to add.
     */
    void add(Type a);

    /**
     * Postcondicion: Erase the indicated element if exists, in other case doesn't do anything.
     * @param a value to erase.
     */
    void remove(Type a);

    /**
     * @return <code>true</code> If set is empty, <code>false</code> in other case.
     */
    boolean isEmpty();

    /**
     * @return returns the element from set.
     */
    Type choose();

}
