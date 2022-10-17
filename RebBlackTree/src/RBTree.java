import java.util.Map;

/**
 * This class is an implementation of the red-black tree structure.
 *
 * @param <K> the generic type for key
 * @param <V> the generic type for value
 */
public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * The node class that is used to represent nodes of a RBTree.
     */
    private class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        /**
         * Constructor for the node class.
         *
         * @param key   the key
         * @param value the value
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    /**
     * No-argument constructor for the class.
     */
    public RBTree() {
        root = null;
        size = 0;
    }

    /**
     * Gets the size of the tree.
     *
     * @return the size of the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns if the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if a node is red.
     *
     * @param node the node to be checked
     * @return true if the node is red, false otherwise
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**
     * Adds a key value pair to the tree.
     *
     * @param key   the key to be added
     * @param value the value to be added
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * Adds a key value pair of node to the specified node
     *
     * @param node  the specified node
     * @param key   the key to be added
     * @param value the value to be added
     * @return the node with the pair added
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
     * Gets a node with the specified key from the specified node as the root node.
     *
     * @param node the root node
     * @param key  the key
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
     * Checks if the tree contains a node with the specified key.
     *
     * @param key the specified key
     * @return true if the tree contains the specified key, false otherwise
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * Gets the value of the node with the specified key.
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
     * Sets the value of the node with the specified key.
     *
     * @param key      the specified key
     * @param newValue the new value to be set on the node
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
     * Removes the node with the specified key.
     *
     * @param key the specified key
     * @return the value of the node with the specified key
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
     * Removes a node with the specified key from a tree whose root is the specified node.
     *
     * @param node the root of the tree
     * @param key  the specified key
     * @return the removed node
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
     * Returns the minimum node from the tree whose root is the specified node.
     *
     * @param node the root of a tree
     * @return the minimum node
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * Removes the minimum node from the tree whose root is the specified node.
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
