package  org.uade.exercise5;

import org.uade.adt.dynamic.*;

public class exercise5 {

    public static Stack eliminar_repetidos(Stack pila){
        ISet elementos_sin_repetir = new Set();
        while (!pila.isEmpty()) { // O(n)
            elementos_sin_repetir.add(pila.getTop());
            pila.remove();
        }
        while (!elementos_sin_repetir.isEmpty()) {  // O(n)
            int element = elementos_sin_repetir.choose();
            pila.add(element);
            elementos_sin_repetir.remove(element);
        }
        return pila;
    }
    public static Stack ordenarPila(Stack pila) {
        Stack pila_sin_repetidos = eliminar_repetidos(pila);
        // Crear una pila auxiliar
        Stack aux = new Stack();

        while (!pila_sin_repetidos.isEmpty()) {  // O(n)
            int elemento = pila_sin_repetidos.getTop();
            pila_sin_repetidos.remove();

            // Mover elementos mayores de la pila original a la pila auxiliar
            while (!aux.isEmpty() && aux.getTop() > elemento) {  // O(m)
                pila_sin_repetidos.add(aux.getTop());
                aux.remove();
            }

            // Agregar el elemento en orden a la pila auxiliar
            aux.add(elemento);
        }

        // Transferir elementos ordenados de la pila auxiliar a la pila original
        while (!aux.isEmpty()) {  // O(n)
            pila_sin_repetidos.add(aux.getTop());
            aux.remove();
        }
        return pila_sin_repetidos;
    }
    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static void main(String[] args) {
        // Ejercicio 5.1
        Stack pila = new Stack();
        pila.add(4);
        pila.add(2);
        pila.add(2);
        pila.add(3);
        pila.add(1);
        pila = ordenarPila(pila); // O(n*m) -> O(n)
        print(pila);
        // Ejercicio 5.2

        CoordSet b = new CoordSet();
        while (b.cardinality() < 1000) {
            double x = Math.random();
            double y = Math.random();
            b.add(x, y);
        }
        System.out.println(b.cardinality());
        Montecarlo mnt = new Montecarlo(0.73, 0.63, 0.43, 0);

        while (!b.isEmpty()) {
            Coord element = b.choose();
            mnt.add(element);
            b.remove(element.get_x(), element.get_y());
        }

        CoordSet total = mnt.obtener_coordenadas();
        System.out.println(total.cardinality());

        int long_coords = total.cardinality();
        int puntos_dentro_del_circulo = 0;
        while (!total.isEmpty()) {
            Coord coordenada = total.choose();
            total.remove(coordenada.get_x(), coordenada.get_y());
            double a = coordenada.get_x() * coordenada.get_x();
            double s = coordenada.get_y() * coordenada.get_y();
            double distancia = Math.sqrt(a + s);
            if (distancia <= 1) {
                puntos_dentro_del_circulo++;
            }

        }
        System.out.println(puntos_dentro_del_circulo);
        double a = puntos_dentro_del_circulo / long_coords;
        System.out.println(a);
        System.out.println(4.0 * (puntos_dentro_del_circulo / long_coords));
    }
}