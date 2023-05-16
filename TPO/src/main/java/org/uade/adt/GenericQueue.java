package org.uade.adt;

import org.uade.adt.node.Node;

public class GenericQueue<T> implements IGenericQueue<T> {

    private Node<T> first;

    public GenericQueue(Node<T> first) {
        for (int i = 0; i < nodes.length; i++) {
            this.add(nodes[i]);
        }
    }

    @Override
    public void add(T a) {
        Node<T> node = new Node<>(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
        }
        return this.first.getValue();
    }

    @Override
    public String toString() {
        return "GenericQueue{" +
                "first=" + first +
                '}';
    }
}
