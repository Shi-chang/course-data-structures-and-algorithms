/**
 * An interface for a binary search tree set.
 *
 * @param <E> the generic type
 */
public interface Set<E> {
    /**
     * Returns the size of the set.
     *
     * @return the size of the set
     */
    public int size();

    /**
     * Returns if this set is empty.
     *
     * @return true if this set is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns if this set contains the specified element.
     *
     * @param e the element whose presence will be checked
     * @return true if the element is present, false otherwise
     */
    public boolean contains(E e);

    /**
     * Adds the specified element to the set.
     */
    public void add(E e);

    /**
     * Removes the specified element from the set.
     *
     * @param e the element to be removed
     */
    public void remove(E e);
}
