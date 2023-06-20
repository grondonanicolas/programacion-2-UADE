package org.uade.adt.dynamic;

import java.util.Objects;

public class CountedNode {

    private int value;
    private int qty;
    private CountedNode next;

    public CountedNode(int value, int qty, CountedNode next) {
        this.value = value;
        this.qty = qty;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public int getQty() {
        return qty;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public void setQty(int qty) {
        this.qty = qty;
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
        return getValue() == node.getValue() && Objects.equals(getNext(), node.getNext());
    }
}
