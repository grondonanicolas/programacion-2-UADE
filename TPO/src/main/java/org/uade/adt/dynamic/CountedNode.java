package org.uade.adt.dynamic;

import java.util.Objects;

public class CountedNode {

    private Counted value;
    private CountedNode next;

    public CountedNode(int value, int qty, CountedNode next) {
        this.value = new Counted(value, qty);
        this.next = next;
    }

    public Counted getNode() {
        return value;
    }

    public void setValue(Counted value) {
        this.value = value;
    }


    public CountedNode getNext() {
        return next;
    }

    public void setNext(CountedNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedNode node = (CountedNode) o;
        return getNode().getValue() == node.getNode().getValue() && Objects.equals(getNext(), node.getNext());
    }
}
