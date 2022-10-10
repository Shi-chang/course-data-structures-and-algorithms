/**
 * This class is an implementation of a queue structure with a linked nodes.
 *
 * @param <E> the generic type
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * The inner class for representation of nodes that form a queue.
     */
    private class Node {
        public E e;
        public Node next;

        /**
         * No-argument constructor for the node class.
         */
        public Node() {
            this(null, null);
        }

        /**
         * Constructor for the node class.
         *
         * @param e the element of the node
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         * @param e    the element of the node
         * @param next the next node
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * A string representation of a node instance.
         *
         * @return a string representation of a node instance
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    /**
     * No-argument constructor for the class.
     */
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the size of the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Enqueues the specified element.
     *
     * @param e the element to be enqueued
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Dequeues an element.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = head.e;
        Node successor = head.next;
        head.next = null;
        head = successor;
        if (head == null) {
            tail = null;
        }
        size--;
        return ret;
    }

    /**
     * Gets the front element of the queue.
     *
     * @return the front element of the queue
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    /**
     * Returns a string representation of an instance.
     *
     * @return a string representation of an instance
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:\nhead ");
        Node cur = head;
        while (cur != null) {
            res.append(cur.toString());
            cur = cur.next;
        }
        return res.toString();
    }
}
