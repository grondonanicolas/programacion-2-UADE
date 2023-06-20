package org.uade;

import org.uade.adt.ISet;
import org.uade.adt.node.Node;
import org.uade.exercise1.Exercise1;
import org.uade.exercise2.Exercise2;

import java.util.ArrayList;
import org.uade.adt.*;


import static org.uade.exercise1.Exercise1.*;
import static org.uade.exercise2.Exercise2.*;
import static org.uade.exercise4.Exercise4.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Exercise1 exercise = new Exercise1();
        System.out.println("Exercise 1a");
        System.out.println("The queue of stacks is: " + initiateQuequeMatrix());
        System.out.println("The trace is: " + exercise.calculateTrace(initiateQuequeMatrix()));

        System.out.println("Exercise 1b");
        System.out.println("The transposed is: " + exercise.generateTransposed(initiateQuequeMatrix()));
        System.out.println();
        System.out.println("Exercise 1c");
        System.out.println("The sum of queues of stacks is: ");
        System.out.println(sumOfQuequeArrays(initiateQuequeMatrix(), initiateQuequeMatrix()));

        System.out.println();

        System.out.println("Exercise 2a");
        System.out.println("The generic stack is: " + generateStack());
        System.out.println("The stack reverted is: " + revertStack(generateStack()));
        System.out.println("Exercise 2b");
        System.out.println("The generic set is: " + generateSet());
        System.out.println("The generic set and his copy is: " + copySet(generateSet()));

        System.out.println();

        System.out.println("Exercise 4a");
        System.out.println("The builder set adding 1,2,423: " + generateBuilderSet().Add(1).Add(2).Add(423));
        System.out.println("Exercise 4b");
        System.out.println("The builder stack adding 5,4,3,2: " + generateBuilderStack().add(5).add(4).add(3).add(2));
        System.out.println("Exercise 4c");
        System.out.println("The builder set adding 9,2,94 with addAll: " + generateSetWithAddAll());
        System.out.println("Exercise 4d");
        System.out.println("The GenericQueue constructor with optional args 14,9,11: " + new GenericQueue(14, 9, 11));
        System.out.println("The GenericQueue constructor with optional args 9,23: " + new GenericQueue(9, 23));
    }
}