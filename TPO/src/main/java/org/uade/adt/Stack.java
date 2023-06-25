package org.uade.adt;

import java.util.Arrays;

public class Stack implements IStack {

    private int[] array;
    private int count;

    public Stack() {
        this.array = new int[10];
        this.count = 0;
    }

    @Override
    public IStack add(int a) {
        this.array[this.count] = a;
        this.count++;
        return this;
    }

    @Override
    public void remove() {
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        return this.array[count - 1];
    }


    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }
}
