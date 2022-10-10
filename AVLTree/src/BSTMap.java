/**
 * This class is an implementation of a binary search tree map.
 *
 * @param <K> the generic type of the key
 * @param <V> the generic type of the value
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    /**
     * An inner node class for representation of an AVL tree node.
     */
    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        /**
         * The constructor of the node class.
         *
         * @param key   the key of the node
         * @param value the value of the node
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * No-argument constructor of the class.
     */
    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * Gets the size of the tree map.
     *
     * @return the size of the tree map
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the tree map is empty.
     *
     * @return true if the tree map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the tree.
     *
     * @param key   the key of the tree
     * @param value the value of the tree
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * Adds an element to the tree.
     *
     * @param node  the root of a tree for addition
     * @param key   the key of the tree
     * @param value the value of the tree
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * Gets a node with the specified key.
     *
     * @param key the specified key
     * @return the node with the specified key
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * Checks if the tree contains an element with the specified key
     *
     * @param key the specified key for searching
     * @return true if the tree contains an element with the specified key, false otherwise
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * Gets the value of a node with the specified key.
     *
     * @param key the specified key
     * @return the value of the node with the specified key
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * Assigns the new value to the value of the node with the specified key.
     *
     * @param key      the specified key
     * @param newValue the new value to be assigned
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "does not exit.");
        }
        node.value = newValue;
    }

    /**
     * Removes an element from the tree.
     *
     * @param key the key of the element to be removed
     * @return the removed element
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    /**
     * Removes an element from the tree.
     *
     * @param node the root of a tree
     * @param key  the key of the node to be removed
     * @return the removed element
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }

        // node.key = key
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = null;
        node.right = null;
        return successor;
    }

    /**
     * Remove the minimum node from the tree.
     *
     * @param node the root of a tree
     * @return the removed node
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * Remove the minimum node from the tree.
     *
     * @param node the root of a tree
     * @return the removed node
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
