/**
 * This class is an implementation of a stack structure with a linked list.
 *
 * @param <E> the generic type
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    /**
     * Gets the size of the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Pushes the specified element into the stack
     *
     * @param e the element to be pushed
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * Pops an element from the stack
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * Gets the top element of the stack.
     *
     * @return the top element of the stack
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    /**
     * Returns a string representation of an instance.
     *
     * @return a string representation of an instance
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack:\ntop ");
        res.append(list.toString());
        return res.toString();
    }
}
