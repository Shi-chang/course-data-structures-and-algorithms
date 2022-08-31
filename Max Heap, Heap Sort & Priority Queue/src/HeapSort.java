/**
 * This class implements sorting using a heap.
 */
public class HeapSort {
    private HeapSort(){}

    /**
     * Sort and array using a max heap. Time complexity = O(nlogn) and space complexity = O(n).
     *
     * @param data the array
     * @param <E> the generic type
     */
    public static <E extends Comparable<E>> void sort(E[] data){
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for(E e: data){
            maxHeap.add(e);
        }

        for(int i = data.length - 1; i >=0; i --){
            data[i] = maxHeap.extractMax();
        }
    }
}
