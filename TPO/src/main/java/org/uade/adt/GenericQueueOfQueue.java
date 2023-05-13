package org.uade.adt;

public class GenericQueueOfQueue<T> implements IGenericQueueOfQueue<T> {
    private final GenericQueue<GenericQueue<T>> queue;

    public GenericQueueOfQueue() {
        queue = new GenericQueue<>();
    }

    @Override
    public void add(GenericQueue<T> q) {
        this.queue.add(q);
    }

    @Override
    public void remove() {
        this.queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public GenericQueue<T> getFirst() {
        return this.queue.getFirst();
    }

    @Override
    public void concatenate(IGenericQueueOfQueue<T> q) {
        while (!q.isEmpty()) {
            this.queue.add(q.getFirst());
            q.remove();
        }
    }

    @Override
    public IGenericQueue<T> flat() {
        IGenericQueue<T> result = new GenericQueue<>();
        GenericQueue<GenericQueue<T>> tmp = this.queue;
        while (!tmp.isEmpty()) {
            GenericQueue<T> q = tmp.getFirst();
            while (!q.isEmpty()) {
                result.add(q.getFirst());
                q.remove();
            }
            tmp.remove();
        }
        return result;
    }

    @Override
    public void reverseWithDepth() {
        IGenericStack<GenericQueue<T>> stack = new GenericStack<>();
        while (!this.queue.isEmpty()) {
            GenericQueue<T> q = this.queue.getFirst();
            GenericStack<T> stackInner = new GenericStack<>();
            while (!q.isEmpty()) {
                stackInner.add(q.getFirst());
                q.remove();
            }
            GenericQueue<T> qReversed = new GenericQueue<>();
            while (!stackInner.isEmpty()) {
                qReversed.add(stackInner.getTop());
                stackInner.remove();
            }
            stack.add(qReversed);
            this.queue.remove();
        }
        while (!stack.isEmpty()) {
            this.queue.add(stack.getTop());
            stack.remove();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        GenericQueue<GenericQueue<T>> tmpQueue = new GenericQueue<>();
        // Copy elements to tmpQueue
        while (!this.queue.isEmpty()) {
            tmpQueue.add(this.queue.getFirst());
            this.queue.remove();
        }
        // Restore elements to original queue and build string representation
        while (!tmpQueue.isEmpty()) {
            GenericQueue<T> innerQueue = tmpQueue.getFirst();
            sb.append("[");
            GenericQueue<T> tmpInnerQueue = new GenericQueue<>();
            // Copy elements to tmpInnerQueue
            while (!innerQueue.isEmpty()) {
                tmpInnerQueue.add(innerQueue.getFirst());
                innerQueue.remove();
            }
            // Restore elements to original innerQueue and build string representation
            while (!tmpInnerQueue.isEmpty()) {
                sb.append(tmpInnerQueue.getFirst().toString());
                innerQueue.add(tmpInnerQueue.getFirst());
                tmpInnerQueue.remove();
                if (!tmpInnerQueue.isEmpty()) {  // If there are more elements, append comma
                    sb.append(", ");
                }
            }
            sb.append("]");
            this.queue.add(tmpQueue.getFirst());
            tmpQueue.remove();
            if (!tmpQueue.isEmpty()) {  // If there are more elements, append comma
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}

