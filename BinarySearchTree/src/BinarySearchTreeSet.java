/**
 * This class is an implementation of a binary search tree set.
 *
 * @param <E> the generic type
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    /**
     * Constructor for the class.
     */
    public BinarySearchTreeSet() {
        bst = new BinarySearchTree<>();
    }

    /**
     * Returns the size of the set.
     *
     * @return the size of the set
     */
    @Override
    public int size() {
        return bst.size();
    }

    /**
     * Returns if this set is empty.
     *
     * @return true if this set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    /**
     * Returns if this set contains the specified element.
     *
     * @param e the element whose presence will be checked
     * @return true if the element is present, false otherwise
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * Adds the specified element to the set.
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * Removes the specified element from the set.
     *
     * @param e the element to be removed
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
