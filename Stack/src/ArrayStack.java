/**
 * An implementation of the Stack interface using a self-defined and resizable array.
 *
 * @param <E> the generic type
 */
public class ArrayStack<E> implements Stack<E>{
    // A self-defined and resizable array to store the elements.
    private Array<E> array;

    /**
     * Constructor for the class.
     *
     * @param capacity the initial capacity for the array
     */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * No-argument constructor for the class.
     */
    public ArrayStack(){
        array= new Array<>();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * Gets the size of the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * Gets the capacity of the stack.
     *
     * @return the capacity of the stack
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * Pushes the element into the stack.
     *
     * @param e the element to be pushed into the stack
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * Pops the top element from the stack.
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * Retrieves the top element of the stack without modifying it.
     *
     * @return the top element of the stack
     */
    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Stack: ");
        result.append('[');
        for(int i = 0; i < array.getSize(); i++){
            result.append(array.get(i));
            if(i != array.getSize() - 1){
                result.append(", ");
            }
        }
        result.append(']');
        result.append(" top");
        return result.toString();
    }
}
