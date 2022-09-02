/**
 * This class implements the basic functions of an array.
 *
 * @param <E> the generic type
 */
public class Array<E> {
    // The elements will be stored in the data array.
    private E[] data;
    // The size will keep track of the current size of the array.
    private int size;

    /**
     * Constructor of the class.
     *
     * @param capacity the initial capacity of the array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * No-argument constructor of the class. The default capacity is 10.
     */
    public Array() {
        this(10);
    }

    /**
     * Checks if the array is empty.
     *
     * @return true if the array is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the capacity of the array.
     *
     * @return the capacity of the array.
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Gets the size of the array.
     *
     * @return the size of the array
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Adds an element to the array at the specified index.
     *
     * @param index the position of the element to be added
     * @param e     the element to be added
     * @throws IllegalArgumentException if the index is invalid
     */
    public void add(int index, E e) {
        // Checks the validity of the index.
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addition failed. Invalid index.");
        }

        // If the size reaches the capacity of the array, double the capacity of the array by
        // resizing.
        if (size == data.length) {
            resize(2 * data.length);
        }

        // Shifts the elements between the index and the end by one to the right.
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
    }

    /**
     * Adds an element to the end of the array.
     *
     * @param e the element to be added
     */
    public void addLast(E e) {
        add(this.size, e);
    }

    /**
     * Adds an element to the beginning of the array.
     *
     * @param e the element to be added
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Gets the element at index position from the array.
     *
     * @param index the index of the element
     * @return the element at index position
     * @throws IllegalArgumentException if the index is invalid
     */
    public E get(int index) {
        // Checks the validity of the index.
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Get failed. Invalid index.");
        }
        return data[index];
    }

    /**
     * Checks if the array contains the specified element e.
     *
     * @param e the e element
     * @return true if the array contains the specified element e, false otherwise
     */
    public boolean contains(E e) {
        for (E element : data) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the index of the specified element in the array.
     *
     * @param e the specified element
     * @return the index of the specified element if it exists, or -1 if it does not
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sets the value at index position of the array.
     *
     * @param index the index of the element
     * @param e     the new value to be assigned on the target element
     * @throws IllegalArgumentException if the index is invalid
     */
    public void set(int index, E e) {
        // Checks the validity of the index.
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Set failed. Invalid index.");
        }
        data[index] = e;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to be removed
     * @return the element that is removed
     * @throws IllegalArgumentException if the index is invalid
     */
    public E remove(int index) {
        // Checks the validity of the index.
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Removal failed. Invalid index.");
        }

        E res = data[index];
        // Shifts the elements between (index + 1) and the end of the array one spot to the left.
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // Shrinks the capacity by half when the size reaches a quarter of capacity.
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return res;
    }

    /**
     * Removes the first element from the array.
     *
     * @return the element that is removed
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * Removes the last element from the array.
     *
     * @return the element that is removed
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * Removes the specified element form the array.
     *
     * @param e the specified element to be removed
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * Resizes the capacity of the array.
     *
     * @param newCapacity the new capacity of the array
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Returns a string representation of the array.
     *
     * @return a string representation of the array
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array info: size = %d, capacity = %d\n", size, getCapacity()));
        res.append('[');
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            // Adds a comma to elements in the middle
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
