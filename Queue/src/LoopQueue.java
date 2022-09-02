/**
 * An implementation of the Queue interface by constructing a looping. This implementation can
 * improve time complexity of an array queue for the dequeue operation. When dequeuing, an
 * array queue take O(n) in time, while the amortized time complexity of a loop queue is O(1).
 *
 * @param <E> the generic type
 */

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    /**
     * Constructor for the class.
     *
     * @param capacity the initial capacity for the data array
     */
    public LoopQueue(int capacity) {
        // An extra space required to distinguish between null and full for the queue.
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * No-argument constructor for the class.
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * Gets the capacity of the queue.
     *
     * @return the capacity of the queue
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * Gets the size of the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param e the element to be added
     */
    @Override
    public void enqueue(E e) {
        // Resizes the array when the array is full(has only one space left).
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * Removes the front element from the queue.
     *
     * @return the removed element
     * @throws IllegalArgumentException when the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue failed. Queue is empty.");

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // Only shrinks the capacity when the size reaches a quarter of the capacity
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return e;
    }

    /**
     * Gets the front element of the queue.
     *
     * @return front element of the queue
     * @throws IllegalArgumentException when the queue is empty
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Get front failed. Queue is empty.");
        }
        return data[front];
    }

    /**
     * Resizes the data array.
     *
     * @param newCapacity the new capacity of the new array
     */
    private void resize(int newCapacity) {
        // Creates a new array, and copies elements from the old array to the new array. The
        // copied elements are placed from the first spot of the new array.
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Queue: ");
        result.append("front ");
        result.append('[');
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail)
                result.append(", ");
        }
        result.append(']');
        result.append(" tail");
        return result.toString();
    }
}
