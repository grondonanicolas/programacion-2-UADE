package org.uade.adt.node;

public class PriorityNode<T,P extends Comparable> {

    private T value;
    private P priority;
    private PriorityNode next;

    public PriorityNode(T value, P priority, PriorityNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public P getPriority() {
        return priority;
    }

    public void setPriority(P priority) {
        this.priority = priority;
    }

    public PriorityNode<T,P> getNext() {
        return next;
    }

    public void setNext(PriorityNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "PriorityNode{" +
                "value=" + value +
                ", priority=" + priority +
                ", next=" + next +
                '}';
    }
}
