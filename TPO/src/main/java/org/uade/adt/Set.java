package org.uade.adt;

import java.util.Arrays;
import java.util.Random;

public class Set<T> implements ISet {

    private final int[] array;
    private int count;

    public Set() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public ISet Add(int a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                return null;
            }
        }

        this.array[this.count] = a;
        this.count++;
        return this;
    }
    @Override
    public ISet AddAll(int[] values, ISet set) {
        for(int i = 0; i < values.length; i++) {
            set.Add(values[i]);
        }
        return set;
    }

    @Override
    public void remove(int a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                if(i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if(this.count == 0) {
            System.out.println("Error, you can't obtain a value from an empty set");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public String toString() {
        return "Set{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }
}
