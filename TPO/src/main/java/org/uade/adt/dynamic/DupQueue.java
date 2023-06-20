package org.uade.adt.dynamic;

import org.uade.adt.dynamic.*;


public class DupQueue implements IQueue {

    private DequeNode first;
    private DequeNode last;

    @Override
    public void add(int a) {
        DequeNode newNode = new DequeNode(a, null, null);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.setPrevious(this.last);
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            System.out.println("No se puede desacolar una cola vacía");
            return;
        }
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getData();
    }
}
