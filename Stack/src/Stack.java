/**
 * An interface for stack.
 *
 * @param <E> the generic type
 */

public interface Stack<E> {
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Gets the size of the stack.
     *
     * @return the size of the stack
     */
    int getSize();

    /**
     * Pushes the element into the stack.
     *
     * @param e the element to be pushed into the stack
     */
    void push(E e);

    /**
     * Pops the top element from the stack.
     */
    E pop();

    /**
     * Retrieves the top element of the stack without modifying it.
     *
     * @return the top element of the stack
     */
    E peek();
}
