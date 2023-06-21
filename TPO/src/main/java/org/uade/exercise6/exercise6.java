package org.uade.exercise6;
import org.uade.adt.dynamic.*;
import org.uade.adt.normal.*;

public class exercise6 {

    public static void main(String[] args) {

        // Ejercico 6.1
        LimitedStack pila_limitada = new LimitedStack(5);
        pila_limitada.add(1);
        pila_limitada.add(2);
        pila_limitada.add(3);
        pila_limitada.add(4);
        pila_limitada.add(5);
        pila_limitada.add(6);
        pila_limitada.add(7);

        // Ejercicio 6.2
        Set a1 = new Set();
        Set b2 = new Set();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);

        b2.add(1);
        b2.add(2);
        b2.add(3);

        ISet test = a1.conjunto_complemento(b2);
        while (!test.isEmpty()){
            int element = test.choose();
            test.remove(element);
            System.out.println(element);

        }
        // Ejercicio 6.3
        DupQueue queue = new DupQueue();


        queue.add(5);
        queue.add(10);
        queue.add(15);

        int firstElement = queue.getFirst();
        queue.remove();

        boolean empty = queue.isEmpty();

        System.out.print("Elementos de la cola: ");
        while (!queue.isEmpty()) {
            int element = queue.getFirst();
            System.out.print(element + " ");
            queue.remove();
        }


        // Ejercicio 6.4

        CountedSet newset = new CountedSet();
        newset.add(1);
        newset.add(1);
        newset.add(1);
        newset.add(2);
        newset.add(3);
        while (!newset.isEmpty()){
            CountedNode a2 = newset.choose();
            System.out.println(a2.getValue() + "..." + a2.getQty());
            newset.remove(a2.getValue());
        }

    }
}
