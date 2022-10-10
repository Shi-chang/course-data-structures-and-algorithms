import java.util.ArrayList;

/**
 * This class is an implementation of the AVL tree structure.
 *
 * @param <K> the generic type of key
 * @param <V> the generic type of value
 */
public class AVLTree<K extends Comparable<K>, V> {
    /**
     * An inner node class for representation of an AVL tree node.
     */
    private class Node {
        public K key;
        public V value;
        public int height;
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
            height = 1;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * No-argument constructor of the class.
     */
    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * Gets the size of the tree.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if is tree is a binary search tree.
     *
     * @return true if the tree is a binary search tree, false otherwise
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * In-order traversal of the tree.
     *
     * @param node the starting node for traversal
     * @param keys the list that stores the keys
     */
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * Checks if the tree is balanced.
     *
     * @return true is the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * Checks if the tree whose root is the specified node is balanced.
     *
     * @param node the root node of a tree for verification
     * @return true is the tree is balanced, false otherwise
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * Gets the height of the node.
     *
     * @param node the specified node
     * @return the height of the node
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * Gets the balance factor of the specified node.
     *
     * @param node the specified node
     * @return the balance factor of the specified node
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * Adds a node.
     *
     * @param key   the key of the node
     * @param value the value of the node
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * Adds a node with the specified key and value to a tree whose root node is the specified node.
     *
     * @param node  the root of a tree
     * @param key   the key of the node to be added
     * @param value the value of the node to be added
     * @return the newly added node
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
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("Imbalanced!");
        }
        return node;
    }

    /**
     * Gets a node with the specified key from the tree whose root is the specified node.
     *
     * @param node the root of a tree
     * @param key  the key of the node to be retrieved
     * @return the retrieved node
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
     * Checks if any node of the tree contains the specified key.
     *
     * @param key teh specified key
     * @return true if any node of the tree contains the specified key, false otherwise
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * Gets the value of the node with the specified key.
     *
     * @param key the specified key
     * @return the value of the node with the specified key
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * Updates the value of a node with the specified key.
     *
     * @param key      the specified key
     * @param newValue the new value to be assigned to the node
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "does not exit.");
        }
        node.value = newValue;
    }

    /**
     * Removes a node with the specified key.
     *
     * @param key the specified key
     * @return a node with the specified key
     */
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
     * @param node the root of a tree
     * @param key  the specified key for the node to be removed
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
     * Returns the minimum node.
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
     * Removes the minimum node recursively.
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
