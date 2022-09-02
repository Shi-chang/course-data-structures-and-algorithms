/**
 * An implementation of the Queue interface using a self-defined and resizable array.
 *
 * @param <E> the generic type
 */
public class ArrayQueue<E> implements Queue<E>{
    // A self-defined and resizable array to store the elements.
    private Array<E> array;

    /**
     * Constructor for the class.
     *
     * @param capacity the initial capacity for the array
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * No-argument constructor for the class.
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * Gets the size of the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param e the element to be added
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * Removes the front element from the queue.
     *
     * @return the removed element
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * Gets the front element of the queue.
     *
     * @return front element of the queue
     */
    @Override
    public E getFront() {
        return array.get(0);
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append("Queue: ");
        result.append("front ");
        result.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            result.append(array.get(i));
            if(i != array.getSize() - 1)
                result.append(", ");
        }
        result.append(']');
        result.append(" tail");
        return result.toString();
    }
}
