package org.uade.adt.dynamic;

public class DequeNode {

    private int data;
    private DequeNode previous;
    private DequeNode next;

    public DequeNode(int data, DequeNode previous, DequeNode next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DequeNode getPrevious() {
        return previous;
    }

    public void setPrevious(DequeNode previous) {
        this.previous = previous;
    }

    public DequeNode getNext() {
        return next;
    }

    public void setNext(DequeNode next) {
        this.next = next;
    }
}
