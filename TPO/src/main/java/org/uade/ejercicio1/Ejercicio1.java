package org.uade.ejercicio1;

import org.uade.adt.SpecialQueque;
import org.uade.adt.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {

    public Ejercicio1() {
    }

    /**
     * 1-a Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.
     *
     * @param specialQueque
     * @return trace of special queque array
     */
    public static int calculateTrace(SpecialQueque specialQueque) {
        int traceValue = 0;
        for (int i = 0; i < specialQueque.getCount(); i++) {
            for (int j = 0; j < specialQueque.getCount(); j++) {
                if (i == j) {
                    traceValue = traceValue + specialQueque.getArray()[i].getArray()[j];
                }
            }
        }

        return traceValue;
    }

    /**
     * 1-b Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.
     *
     * @param specialQueque
     * @return transposed of special queque array
     */

    public static List<Stack> generateListOfStacksFromSpecialQueque(SpecialQueque specialQueque) {
        List<Stack> stacks = new ArrayList<>();
        for (int i = 0; i < specialQueque.getCount(); i++) {
            Stack stack = new Stack();
            stacks.add(stack);
        }
        return stacks;
    }

    public static SpecialQueque generateTransposed(SpecialQueque specialQueque) {
        Stack[] specialQuequeStack = specialQueque.getArray();

        List<Stack> stacksTransposed = generateListOfStacksFromSpecialQueque(specialQueque);
        for (int i = 0; i < specialQueque.getCount(); i++) {
            int counter = 0;

            while (stacksTransposed.get(i) != null && counter < stacksTransposed.size()) {
                int basePosition = 0;
                stacksTransposed.get(basePosition + counter).add(specialQuequeStack[i].getTop());
                counter++;
            }

        }

        for (int j = 0; j < specialQueque.getCount(); j++) {
            System.out.println(specialQueque.getArray()[j]);
            specialQueque.getArray()[j] = stacksTransposed.get(j);
        }

        System.out.println();

        //print matrix to see the transposed
        for (int j = 0; j < specialQueque.getCount(); j++) {
            System.out.println(specialQueque.getArray()[j]);
        }
        return specialQueque;
    }

    /**
     * 1-c Desarrolle una función que reciba dos instancias de QueueOfStacks y devuelva una nueva instancia de
     * QueueOfStacks que represente la suma matricial.
     *
     * @return sum of special queques arrays
     * @params specialQueque1, specialQueque2
     */

    public static SpecialQueque sumOfQuequeArrays(SpecialQueque specialQueque1, SpecialQueque specialQueque2) {
        List<Stack> sumOfSpecialQueques = generateListOfStacksFromSpecialQueque(specialQueque1);
        List<Stack> stacksFromSpecialQueque1 = Arrays.asList(specialQueque1.getArray());
        List<Stack> stacksFromSpecialQueque2 = Arrays.asList(specialQueque2.getArray());

        try {
            if (stacksFromSpecialQueque1.size() == stacksFromSpecialQueque2.size()) {
                for (int i = 0; i < stacksFromSpecialQueque1.get(0).getCount(); i++) {
                    int counter = 0;

                    while (counter < stacksFromSpecialQueque1.get(i).getCount()) {
                        sumOfSpecialQueques.get(i).add(stacksFromSpecialQueque1.get(i).getTop() + stacksFromSpecialQueque2.get(i).getTop());
                        counter++;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

        SpecialQueque specialQueque = new SpecialQueque();

        for (int i = 0; i < sumOfSpecialQueques.size(); i++) {
            specialQueque.getArray()[i] = sumOfSpecialQueques.get(i);
            System.out.println(specialQueque.getArray()[i]);
        }

        return specialQueque;
    }

    public static SpecialQueque initiateQuequeMatrix() {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        SpecialQueque matrix = new SpecialQueque();

        stack1.add(1);
        stack1.add(1);
        stack1.add(1);

        stack2.add(2);
        stack2.add(2);
        stack2.add(2);

        stack3.add(3);
        stack3.add(3);
        stack3.add(3);

        matrix.add(stack1);
        matrix.add(stack2);
        matrix.add(stack3);

        return matrix;
    }


}
