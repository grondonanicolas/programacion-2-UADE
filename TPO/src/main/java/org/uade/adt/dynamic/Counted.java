package org.uade.adt.dynamic;

import java.util.Objects;

public class Counted {
    private int value;
    private int qty;

    public Counted(int value, int qty){
        this.value = value;
        this.qty = qty;
    }

    public int getValue(){
        return this.value;
    }
    public int getQty(){
        return this.qty;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counted counted)) return false;
        return getValue() == counted.getValue() && getQty() == counted.getQty();
    }
}
