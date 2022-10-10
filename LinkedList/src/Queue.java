/**
 * An interface for the queue structure.
 *
 * @param <E> the generic type
 */
public interface Queue<E> {
    int getSize();

    void enqueue(E e);

    E dequeue();

    boolean isEmpty();

    public E getFront();
}
