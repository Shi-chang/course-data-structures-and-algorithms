/**
 * An interface for a binary search tree map.
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> {
    /**
     * Adds an element to the tree.
     *
     * @param key   the key of the tree
     * @param value the value of the tree
     */
    void add(K key, V value);

    /**
     * Removes an element from the tree.
     *
     * @param key the key of the element to be removed
     * @return the removed element
     */
    V remove(K key);

    /**
     * Checks if the tree contains an element with the specified key
     *
     * @param key the specified key for searching
     * @return true if the tree contains an element with the specified key, false otherwise
     */
    boolean contains(K key);

    /**
     * Gets the value of a node with the specified key.
     *
     * @param key the specified key
     * @return the value of the node with the specified key
     */
    V get(K key);

    /**
     * Assigns the new value to the value of the node with the specified key.
     *
     * @param key      the specified key
     * @param newValue the new value to be assigned
     */
    void set(K key, V newValue);

    /**
     * Gets the size of the tree map.
     *
     * @return the size of the tree map
     */
    int getSize();

    /**
     * Checks if the tree map is empty.
     *
     * @return true if the tree map is empty, false otherwise
     */
    boolean isEmpty();
}
