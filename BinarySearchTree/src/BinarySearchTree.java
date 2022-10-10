import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class is an implementation of binary search tree.
 *
 * @param <E> The generic type
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * No-argument constructor.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the size of the tree.
     *
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Returns if the tree is empty.
     *
     * @return if the tree is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the tree.
     *
     * @param e the element to be added
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * Adds an element to the tree.
     *
     * @param node the tree node that this data is to be added to
     * @param data the data to be added
     * @return the tree node with the data added
     */
    private Node add(Node node, E data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        if (data.compareTo(node.e) < 0) {
            node.left = add(node.left, data);
        } else if (data.compareTo(node.e) > 0) {
            node.right = add(node.right, data);
        }
        return node;
    }

    /**
     * Checks if this tree contains the specified data
     *
     * @param data the data to be checked
     * @return true if this tree contains the data, false otherwise
     */
    public boolean contains(E data) {
        return contains(root, data);
    }

    /**
     * Checks if the descendants of the node contains the specified data
     *
     * @param node the node of a tree to check the existence of data
     * @param data the data to be checked
     * @return true if this node contains the data, false otherwise
     */
    public boolean contains(Node node, E data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.e) == 0) {
            return true;
        } else if (data.compareTo(node.e) < 0) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    /**
     * Conducts level order search of the tree with a queue.
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.e + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * Conducts pre-order search using a non-recursive method.
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.e + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * Conducts pre-order search using a recursive method.
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * Recursively searches a tree with the node as the root in pre-order.
     *
     * @param node the root of a tree for searching
     */
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Conducts in-order search using a recursive method.
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * Recursively searches a tree with the node as the root in pre-order.
     *
     * @param node the root of a tree for searching
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e + " ");
        inOrder(node.right);
    }

    /**
     * Conducts post-order search using a recursive method.
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * Recursively searches a tree with the node as the root in post-order.
     *
     * @param node the root of a tree for searching
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e + " ");
        postOrder(node.left);
        postOrder(node.right);
    }

    /**
     * Returns the maximum node.
     *
     * @return the maximum node
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("The tree is empty.");
        }
        return maximum(root).e;
    }

    /**
     * Returns the maximum node of a tree with the specified node as the root.
     *
     * @param node the root of a tree
     * @return the maximum node of a tree with the specified node as the root
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * Returns the minimum node.
     *
     * @return the minimum node
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("The tree is empty.");
        }
        return minimum(root).e;
    }

    /**
     * Returns the minimum node of a tree with the specified node as the root.
     *
     * @param node the root of a tree
     * @return the minimum node of a tree with the specified node as the root
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * Removes the minimum node.
     *
     * @return the minimum node that is removed
     */
    public E removeMin() {
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    /**
     * Removes the minimum node from the tree with the specified as the root.
     *
     * @param node the root of a tree
     * @return the minimum node that is removed
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

    /**
     * Removes the maximum node from the tree.
     *
     * @return the maximum node from the tree
     */
    public E removeMax() {
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    /**
     * Removes the maximum node from the tree with the specified as the root.
     *
     * @param node the root of a tree
     * @return the maximum node that is removed
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * Removes the specified element.
     *
     * @param e the element to be removed
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * Removes the specified data from a tree whose root is the specified node.
     *
     * @param node the root of a tree whose specified data is to be removed
     * @param data the data to be removed
     * @return the removed data
     */
    private Node remove(Node node, E data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.e) < 0) {
            node.left = remove(node.left, data);
            return node;
        }
        if (data.compareTo(node.e) > 0) {
            node.right = remove(node.right, data);
            return node;
        }

        // node.data = data
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
     * Returns a string representation of an instance.
     *
     * @return a string representation of an instance
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * Generates a bst string.
     *
     * @param node  the root of the tree
     * @param depth the depth of the tree
     * @param res   the StringBuilder instance for string building
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepth(depth) + "null\n");
            return;
        }
        res.append(generateDepth(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * Generates a depth for the tree's string representation.
     *
     * @param depth the depth of the tree
     * @return the string representation of depth of the tree
     */
    private String generateDepth(int depth) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            str.append("--");
        }
        return str.toString();
    }
}
