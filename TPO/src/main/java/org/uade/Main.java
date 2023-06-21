package org.uade;

import org.uade.exercise1.Exercise1;
import org.uade.exercise3.Exercise3;
import org.uade.exercise5.Exercise5;
import org.uade.exercise6.Exercise6;

import static org.uade.exercise1.Exercise1.*;
import static org.uade.exercise2.Exercise2.*;

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

        System.out.println();
        Exercise5 exercise5 = new Exercise5();
        System.out.println("Exercise 5a");
        exercise5.exercise5a();
        System.out.println("Exercise 5b");
        exercise5.exercise5b();

        System.out.println();
        Exercise6 exercise6 = new Exercise6();
        System.out.println("Exercise 6a");
        exercise6.exercise6a();
        System.out.println("Exercise 6b");
        exercise6.exercise6b();
        System.out.println("Exercise 6c");
        exercise6.exercise6a();
        System.out.println("Exercise 6d");
        exercise6.exercise6b();
        System.out.println("Exercise 6e");
        exercise6.exercise6a();

    }
}