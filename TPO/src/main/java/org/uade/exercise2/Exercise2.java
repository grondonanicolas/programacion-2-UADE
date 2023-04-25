package org.uade.exercise2;

import org.uade.adt.GenericStack;
import org.uade.adt.Set;

public class Exercise2 {

    public Exercise2() {
    }

    /**
     * Ejercicio 2-1: Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
     *
     * @return
     */

    public static GenericStack revertStack(GenericStack stack) {
        GenericStack stackReverted = new GenericStack();
        while (stack.getFirst() != null) {
            stackReverted.add(stack.getTop());
            stack.remove();
        }

        return stackReverted;
    }

//    public static <T> Set<T> copy(Set<T> set){
//
//    }

    public static GenericStack generateStack() {
        GenericStack genericStack = new GenericStack();
        genericStack.add("Hello");
        genericStack.add("how");
        genericStack.add("you");
        genericStack.add("are");
        return genericStack;
    }

    @Override
    public String toString() {
        return "Exercise2{}";
    }
}
