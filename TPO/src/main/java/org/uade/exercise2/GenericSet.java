package org.uade.exercise2;

import java.lang.reflect.Type;
import java.util.Random;

public class GenericSet implements IGenericSet{

    private Type[] array;
    private int count;

    public GenericSet() {
        this.array = new Type[10000];
        this.count = 0;
    }

    @Override
    public void add(Type a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                return;
            }
        }

        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove(Type a) {
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
    public Type choose() {
        if(this.count == 0) {
            System.out.println("Error, you can't obtain a value from an empty set");
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public String toString() {
        return "GenericSet{}";
    }
}
