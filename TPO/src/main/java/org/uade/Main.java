package org.uade;

import org.uade.exercise2.Exercise2;

import static org.uade.exercise1.Exercise1.*;
import static org.uade.exercise2.Exercise2.generateStack;
import static org.uade.exercise2.Exercise2.revertStack;

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

        System.out.println();

        System.out.println("Ejercicio 2a");
        System.out.println("The generic stack is: " + generateStack());
        System.out.println("The stack reverted is: " + revertStack(generateStack()));
    }
}