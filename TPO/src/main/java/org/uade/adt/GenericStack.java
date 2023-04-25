package org.uade.adt;

import org.uade.adt.node.Node;

import java.lang.reflect.Type;
import java.util.Arrays;

public class GenericStack<T> implements IGenericStack<T> {
    private Node<T> first;

    public GenericStack() {
    }

    @Override
    public void add(T a) {
        this.first = new Node(a, this.first);
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
    public T getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
        }
        return this.first.getValue();
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "first=" + first +
                +
                        '}';
    }
}
