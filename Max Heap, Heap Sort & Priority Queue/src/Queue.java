/**
 * An interface that includes common functions for Queue.
 * @param <E> the generic type
 */
public interface Queue<E>{
    /**
     * Gets the size of the heap.
     *
     * @return the size of the heap
     */
    int getSize();

    /**
     * Returns if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Enqueues an element into the queue.
     *
     * @param e the element to be enqueued
     */
    void enqueue(E e);

    /**
     * Dequeues an element from the queue.
     */
    E dequeue();

    /**
     * Gets the front element from the queue.
     *
     * @return the front element from the queue
     */
    E getFront();
}
