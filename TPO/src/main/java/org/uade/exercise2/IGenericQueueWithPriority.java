package org.uade.exercise2;

import java.lang.reflect.Type;

public interface IGenericQueueWithPriority {
    /**
     * Postcondition: Stacks (adds in the final position) un valor.
     * @param a value to stack.
     */
    void add(Type a,int priority);

    /**
     * Precondition: The queue is not empty.
     * Postcondition: erase the first element.
     */
    void remove();

    /**
     * @return <code>true</code> if queue is empty, <code>false</code> in other case.
     */
    boolean isEmpty();

    /**
     * @return retuns the first value.
     */
    Type getFirst();
}
