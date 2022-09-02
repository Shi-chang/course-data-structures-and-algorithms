/**
 * The interface for a queue that contains common functions of a queue.
 *
 * @param <E> the generic type
 */
public interface Queue<E> {
    /**
     * Gets the size of the queue.
     *
     * @return the size of the queue
     */
    int getSize();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the end of the queue.
     *
     * @param e the element to be added
     */
    void enqueue(E e);

    /**
     * Removes the front element from the queue.
     *
     * @return the removed element
     */
    E dequeue();

    /**
     * Gets the front element of the queue.
     *
     * @return front element of the queue
     */
    E getFront();
}
