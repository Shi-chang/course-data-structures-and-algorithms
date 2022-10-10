/**
 * An interface for the stack structure.
 *
 * @param <E> the generic type
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
