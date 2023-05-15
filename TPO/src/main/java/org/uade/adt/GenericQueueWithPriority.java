package org.uade.adt;

import org.uade.adt.node.PriorityNode;

public class GenericQueueWithPriority<T, P extends Comparable> implements IGenericQueueWithPriority<T, P> {
    private PriorityNode<T, P> first;

    @Override
    public void add(T a, P priority) {
        if (this.first == null) {
            this.first = new PriorityNode(a, priority, null);
            return;
        }
        PriorityNode candidate = this.first;
        while (candidate.getNext() != null && candidate.getPriority().compareTo(priority) == 1) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new PriorityNode(a, priority, candidate.getNext()));
    }

    @Override
    public void remove() {
        if (this.first == null) {
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
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
        }
        return this.first.getValue();
    }

    public void setFirst(PriorityNode<T,P> first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "GenericQueueWithPriority{}";
    }
}
