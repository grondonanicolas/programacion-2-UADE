package org.uade.exercise2;

import java.lang.reflect.Type;

public class GenericQueueWithPriority implements IGenericQueueWithPriority{
    private static final int LENGTH = 10000;
    private  Type[] array;
    private  int[] priorities;
    private int count;

    public GenericQueueWithPriority() {
        this.array = new Type[LENGTH];
        this.priorities = new int[LENGTH];
        this.count = 0;
    }

    @Override
    public void add(Type a, int priority) {
        int index = binarySearch(priority);

        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        this.array[index] = a;
        this.priorities[index] = priority;

        this.count++;
    }

    private int binarySearch(int priority) {
        int low = 0;
        int high = this.count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            } else if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
    @Override
    public void remove() {
        if(count == 0) {
            System.out.println("Error, you cant erase a value from a queque if it is empty");
            return;
        }
        for(int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i+1];
            this.priorities[i] = this.priorities[i+1];
        }
        this.count--;
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

    public Type[] getArray() {
        return array;
    }

    public void setArray(Type[] array) {
        this.array = array;
    }

    public int[] getPriorities() {
        return priorities;
    }

    public void setPriorities(int[] priorities) {
        this.priorities = priorities;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GenericQueueWithPriority{}";
    }
}
