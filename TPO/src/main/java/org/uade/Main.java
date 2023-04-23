package org.uade;

import static org.uade.exercise1.Exercise1.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1a");
        System.out.println("The queue of stacks is: " + initiateQuequeMatrix());
        System.out.println("The trace is: " + calculateTrace(initiateQuequeMatrix()));

        System.out.println("Ejercicio 1b");
        System.out.println("The transposed is: " +  generateTransposed(initiateQuequeMatrix()));
        System.out.println();
        System.out.println("Ejercicio 1c");
        System.out.println("The sum of queues of stacks is: ");
        System.out.println(sumOfQuequeArrays(initiateQuequeMatrix(),initiateQuequeMatrix()));
    }
}