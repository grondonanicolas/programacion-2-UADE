package org.uade.adt.dynamic;

import org.uade.adt.dynamic.ILimitedStack;

public class LimitedStack implements ILimitedStack {

    private Node first;
    private int limit;
    public LimitedStack(int limit){
         this.limit = limit;
    }
    @Override
    public void add(int a) {
        int count = 0;
        if (this.first == null){
            count = 0;
        }
        else {
            Node candidate = this.first;
            while (candidate != null) {
                candidate = candidate.getNext();
                count++;
            }
        }
        if (count < this.limit){
            this.first = new Node(a, this.first);
        }
        else {
            System.out.println("La pila ha alcanzado su limite, para agregar un nuevo elemento elimine alguno");
        }
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
