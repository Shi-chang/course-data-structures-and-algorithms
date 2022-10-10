/**
 * This class is an implementation of a linked list structure.
 *
 * @param <E> the generic type
 */
public class LinkedList<E> {
    /**
     * The inner class for representation of nodes that form a linked list.
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
    }

    private Node dummyHead;
    int size;

    /**
     * No-argument constructor for the class.
     */
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * Gets the size of the list.
     *
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the specified element to the head of the list.
     *
     * @param e the specified element to be added
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Adds the specified element to the tail of the list.
     *
     * @param e the specified element to be added
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Adds the specified element to the index position.
     *
     * @param index the position for addition
     * @param e     the element to be added
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index for addition.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // The following part is equal to:
        // Node newNode = new Node(e);
        // newNode.next = prev.next;
        // prev.next = newNode;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * Gets the node at the index position.
     *
     * @param index the index of the node
     * @return the node at the index position
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index for addition.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * Gets the head node of the list.
     *
     * @return the head node of the list
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Gets the last node of the list.
     *
     * @return the last node of the list
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Sets the node at index position to be the specified element.
     *
     * @param index the index of the node to be reset
     * @param e     the specified element for update
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index for addition.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * Returns if the list contains the specified element.
     *
     * @param e the element whose presence will be checked
     * @return true if the specified element is present, false otherwise
     */
    public boolean contains(E e) {
        return contains(dummyHead.next, e);
//        Non-recursive method would be:
//        Node cur = dummyHead.next;
//        while (cur != null){
//            if(e.equals(cur.e)){
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
    }

    /**
     * Checks the presence of the specified element in a list whose head is the specified head.
     *
     * @param head the head node of a list
     * @param e    the element whose presence will be checked
     * @return true if the specified element is present, false otherwise
     */
    private boolean contains(Node head, E e) {
        if (head == null) {
            return false;
        }
        if (head.e.equals(e)) {
            return true;
        }
        return contains(head.next, e);
    }

    /**
     * Removes the element at the index position.
     *
     * @param index the index of the element to be removed
     * @return the removed element
     */
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal index for removal.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * Removes the first element of the list.
     *
     * @return the removed element
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Removes the last element of the list.
     *
     * @return the removed element
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Returns a string representation of an instance.
     *
     * @return a string representation of an instance
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
