package  org.uade.exercise5;

import org.uade.adt.definitions.ISet;
import org.uade.adt.definitions.IStack;
import org.uade.adt.dynamic.*;

public class Exercise5 {

    public static Stack eliminarRepetidos(Stack pila){
        ISet elementosSinRepetir = new Set();
        while (!pila.isEmpty()) { // O(n)
            elementosSinRepetir.add(pila.getTop());
            pila.remove();
        }
        while (!elementosSinRepetir.isEmpty()) {  // O(n)
            int element = elementosSinRepetir.choose();
            pila.add(element);
            elementosSinRepetir.remove(element);
        }
        return pila;
    }
    public static Stack ordenarPila(Stack pila) {
        Stack pilaSinRepetidos = eliminarRepetidos(pila);
        // Crear una pila auxiliar
        Stack aux = new Stack();

        while (!pilaSinRepetidos.isEmpty()) {  // O(n)
            int elemento = pilaSinRepetidos.getTop();
            pilaSinRepetidos.remove();

            // Mover elementos mayores de la pila original a la pila auxiliar
            while (!aux.isEmpty() && aux.getTop() > elemento) {  // O(m)
                pilaSinRepetidos.add(aux.getTop());
                aux.remove();
            }

            // Agregar el elemento en orden a la pila auxiliar
            aux.add(elemento);
        }

        // Transferir elementos ordenados de la pila auxiliar a la pila original
        while (!aux.isEmpty()) {  // O(n)
            pilaSinRepetidos.add(aux.getTop());
            aux.remove();
        }
        return pilaSinRepetidos;
    }
    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static void exercise5a(){
        Stack pila = new Stack();
        pila.add(4);
        pila.add(2);
        pila.add(2);
        pila.add(3);
        pila.add(1);
        pila = ordenarPila(pila); // O(n*m) -> O(n)
        print(pila);
    }

    public static void exercise5b(){
        CoordSet b = new CoordSet();
        while (b.cardinality() < 1000) {
            double x = Math.random();
            double y = Math.random();
            b.add(x, y);
        }

        double max_coord = 1;
        double min_coord = 0;

        Montecarlo mnt = new Montecarlo(max_coord, max_coord, min_coord, min_coord);

        while (!b.isEmpty()) {
            Coord element = b.choose();
            mnt.add(element);
            b.remove(element.getX(), element.getY());
        }

        double aproximacionPi = mnt.obtenerPi();
        System.out.println(aproximacionPi);
    }
    public static void main(String[] args) {

    }
}