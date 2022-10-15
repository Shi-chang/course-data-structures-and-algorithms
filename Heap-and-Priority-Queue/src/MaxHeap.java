import java.util.ArrayList;

/**
 * This class implements the basic functions of a maximum binary heap.
 */
public class MaxHeap<E extends Comparable<E>> {

    // A list is used to store the elements for the heap.
    private ArrayList<E> data;

    /**
     * Constructor of the class.
     * @param capacity the capacity of the list
     */
    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    /**
     * No-argument constructor of the class.
     */
    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * Constructs a max heap using a random list.
     * @param arr
     */
    public MaxHeap(ArrayList<E> arr) {
        // Puts the elements from the argument to the list.
        for (int i = 0; i < arr.size(); i++) {
            data.set(i, arr.get(i));
        }

        // Heapify - from the last element that has child element(s) to the first element, conduct
        // sifting down processing so that every element is in the right position.
        // Time complexity =  O(n)
        for (int i = parent(arr.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * Returns the size of the heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns if the heap is empty.
     *
     * @return if the heap is empty
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns the parent index of the indexed element.
     *
     * @param index the index of an element
     * @return the parent index of the indexed element
     * @throws IllegalArgumentException if the index is invalid
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("root element does not have a parent.");
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the left child of the indexed element.
     *
     * @param index the index of an element
     * @return the index of the left child of the indexed element
     */
    // return the index number of the left child of the indexed element
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * Returns the index of the right child of the indexed element.
     *
     * @param index the index of an element
     * @return the index of the right child of the indexed element
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * Adds an element to the heap. The element will be added to the end, and then sifted up along
     * the path until it reaches an appropriate position.
     * Time complexity = O(nlogn)
     *
     * @param e the element to be added
     */
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    /**
     * Sifts up the element in the kth position. Sifting up happens when an element is added(to
     * the end). Sifting is conducted by comparing the current element with its parent element.
     * If it is needed, swap them.
     *
     * @param k the index of the element
     */
    public void siftUp(int k) {
        // Compares current element with its parent
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * Swaps two elements.
     *
     * @param i the first element to be swapped
     * @param j the second element to be swapped
     * @throws IllegalArgumentException if the index is invalid
     */
    private void swap(int i, int j) {
        if (i < 0 || i >= data.size() || j < 0 || j >= data.size()) {
            throw new IllegalArgumentException("Invalid index");
        }
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    /**
     * Returns the max element of the heap.
     *
     * @return the max element of the heap
     * @throws IllegalArgumentException if the heap is empty
     */
    public E findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Cannot find max in an empty heap.");
        }
        return data.get(0);
    }

    /**
     * Returns and removes the max element from the heap.
     *
     * @return the max element from the heap
     */
    public E extractMax() {
        E ret = findMax();

        swap(0, data.size() - 1);
        data.remove(data.size() - 1);

        //Sifts down the first element to its appropriate position
        siftDown(0);

        return ret;
    }

    /**
     * Sifts down the element in the kth position. Sifting down happens when the max element is
     * removed. Sifting is conducted by comparing the current element with its child elements.
     * If it is needed, swap it with the bigger child element.
     *
     * @param k the index of the element
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            // Makes data[j] the bigger element between the two child elements
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    /**
     * Extracts the max element from the heap, replaces it with the specified element,
     * and sift down the new element to the correct position.
     *
     * @param e the element to be added
     * @return the max element
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
