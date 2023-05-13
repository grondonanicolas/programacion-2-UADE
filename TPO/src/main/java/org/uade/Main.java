package org.uade;

import org.uade.exercise1.Exercise1;
import org.uade.exercise2.Exercise2;
import org.uade.exercise3.Exercise3;

import static org.uade.exercise1.Exercise1.*;
import static org.uade.exercise2.Exercise2.*;
import static org.uade.exercise3.Exercise3.*;
public class Main {
    public static void main(String[] args) {
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
        Exercise3 exercise3 = new Exercise3();
        System.out.println("Exercise 3a");
        exercise3.demonstrateConcatenate();
        System.out.println("Exercise 3b");
        exercise3.demonstrateFlat();
        System.out.println("Exercise 3c");
        exercise3.demonstrateReverseWithDepth();

    }
}