// Exercise3.java

package org.uade.exercise3;

import org.uade.adt.GenericQueue;
import org.uade.adt.GenericQueueOfQueue;

public class Exercise3 {
    public static GenericQueueOfQueue<Integer> generateQueueOfQueue() {
        GenericQueueOfQueue<Integer> queueOfQueue = new GenericQueueOfQueue<>();

        GenericQueue<Integer> queue1 = new GenericQueue<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        GenericQueue<Integer> queue2 = new GenericQueue<>();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        queueOfQueue.add(queue1);
        queueOfQueue.add(queue2);

        return queueOfQueue;
    }

    public void demonstrateConcatenate() {
        GenericQueueOfQueue<Integer> queueOfQueue1 = generateQueueOfQueue();
        GenericQueueOfQueue<Integer> queueOfQueue2 = generateQueueOfQueue();
        System.out.println("QueueOfQueue 1: " + queueOfQueue1);
        System.out.println("QueueOfQueue 2: " + queueOfQueue2);
        queueOfQueue1.concatenate(queueOfQueue2);
        System.out.println("Concatenated QueueOfQueue: " + queueOfQueue1);
    }

    public void demonstrateFlat() {
        GenericQueueOfQueue<Integer> queueOfQueue = generateQueueOfQueue();
        System.out.println("Flat Queue: " + queueOfQueue.flat());
    }

    public void demonstrateReverseWithDepth() {
        GenericQueueOfQueue<Integer> queueOfQueue = generateQueueOfQueue();
        queueOfQueue.reverseWithDepth();
        System.out.println("Reversed QueueOfQueue: " + queueOfQueue);
    }
}
