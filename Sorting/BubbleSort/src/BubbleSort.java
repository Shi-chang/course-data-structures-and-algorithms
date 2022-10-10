/**
 * This class is an implemention of bubble sort.
 */
public class BubbleSort {
    private BubbleSort() {
    }

    /**
     * Bubble sort without optimization.
     *
     * @param data the data to be sorted
     * @param <E>  the generic type
     */
    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * Bubble sort with optimization considering the possibility of input array is already fully sorted.
     *
     * @param data the data to be sorted
     * @param <E>  the generic type
     */
    // bubble sort with improvement when the data array is ordered
    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    /**
     * Bubble sort with optimization considering the possibility of input array is already partially sorted.
     *
     * @param data the data to be sorted
     * @param <E>  the generic type
     */
    public static <E extends Comparable<E>> void sort3(E[] data) {
        for (int i = 0; i < data.length - 1; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            // 首次入循环i=0,数组尾巴排好队的个数也为0，也此处i为尾巴已经排好队的元素个数；
            // 此时，排好队元素个数为(data.length -1) - lastSawppedIndex + 1
            i = data.length - lastSwappedIndex;
        }
    }

    /**
     * Swaps two elements from the data array.
     *
     * @param data the array whose two element will be swapped
     * @param i    the first element for swapping
     * @param j    the second element for swapping
     * @param <E>  the generic type
     */
    private static <E> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
