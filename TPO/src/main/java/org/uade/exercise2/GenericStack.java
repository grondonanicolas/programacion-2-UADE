package org.uade.exercise2;

import java.lang.reflect.Type;

public class GenericStack<T> implements IGenericStack {

    private final T[] array;

    private int count;

    public GenericStack() {
        this.array = (T[]) new Type[10000];
        this.count = 0;
    }

    @Override
    public void add(Type a) {
        this.array[this.count] = (T) a;
        this.count++;
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
    public Type getTop() {
        return (Type) this.array[count - 1];
    }
}
