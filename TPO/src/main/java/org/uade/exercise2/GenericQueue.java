package org.uade.exercise2;

import org.uade.adt.Stack;

import java.lang.reflect.Type;
import java.util.Arrays;

public class GenericQueue implements IGenericQueue {

    private Type[] array;

    private int count;

    public GenericQueue() {
        this.array = new Type[10000];
        this.count = 0;
    }


    @Override
    public void add(Type a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        Type newArray[] = new Type[this.array.length - 1];
        for (int i = 1; i < this.array.length; i++) {
            newArray[i - 1] = this.array[i];
        }
        this.count --;
        this.array = newArray;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Type getFirst() {
        if(count == 0) {
            System.out.println("Error, you can't obtain a value from an empty queue");
        }
        return this.array[0];
    }

    public int getCount() {
        return count;
    }

    public Type[] getArray() {
        return array;
    }

    public void setArray(Type[] array) {
        this.array = array;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SpecialRow{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }

}
