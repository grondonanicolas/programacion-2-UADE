package org.uade.adt.dynamic;

import org.uade.adt.definitions.ILimitedStack;

public class LimitedStack implements ILimitedStack {

    private Node first;
    private int limit;

    private int count;
    public LimitedStack(int limit){
         this.limit = limit;
    }
    @Override
    public void add(int a) {
        if (this.first == null){
            this.count = 0;
        }
        if (this.count < this.limit){
            this.first = new Node(a, this.first);
            this.count++;
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
        this.count--;
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
