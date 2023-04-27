package org.uade.exercise2;

import org.uade.adt.GenericSet;
import org.uade.adt.GenericStack;
import org.uade.adt.Set;
import org.uade.adt.Stack;

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

    /**
     * Ejercicio 2-2 2. Desarrolle una función que copie un Set genérico.
     *
     * @return stackOfSets
     */

    public static GenericStack<GenericSet> copySet(GenericSet set) {
        GenericSet setCopied = set;
        GenericStack<GenericSet> stackOfSets = new GenericStack<>();
        stackOfSets.add(set);
        stackOfSets.add(setCopied);

        return stackOfSets;
    }


    public static GenericStack generateStack() {
        GenericStack genericStack = new GenericStack();
        genericStack.add("Hello");
        genericStack.add("how");
        genericStack.add("you");
        genericStack.add("are");
        return genericStack;
    }

    public static GenericSet generateSet(){
        GenericSet set = new GenericSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        return set;
    }

    @Override
    public String toString() {
        return "Exercise2{}";
    }
}
