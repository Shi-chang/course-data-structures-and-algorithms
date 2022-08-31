/**
 * This class implements the basic operations of a priority queue using a binary heap.
 * Time complexity = O(log n)
 *
 * @param <E> the generic type
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
    // A max heap to store the elements for the queue
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    /**
     * Gets the size of the heap.
     *
     * @return the size of the heap
     */
    @Override
    public int getSize(){
        return maxHeap.size();
    }

    /**
     * Returns if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * Enqueues an element into the queue.
     *
     * @param e the element to be enqueued
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * Dequeues an element from the queue.
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * Gets the front element from the queue.
     *
     * @return the front element from the queue
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
