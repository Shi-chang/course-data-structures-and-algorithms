import java.util.Arrays;
import java.util.LinkedList;

/**
 * Selection sort and insertion sort.
 */
public class Sort {
    private Sort(){}
    /**
     * Selection sort. The time complexity is O(n2) and the space complexity is O(1).
     *
     * @param arr the array to be sorted
     * @param <E> the generic type
     */
    public static <E extends Comparable<E>> void selectionSort(E[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * Insertion sort. The time complexity is O(n2) and the space complexity is O(1).
     *
     * @param arr the array to be sorted
     * @param <E> the generic type
     */
    // Insertion sort.
    public static <E extends Comparable<E>> void insertionSort(E[] arr){
        for(int i = 1; i < arr.length; i++){
            E key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j].compareTo(key) > 0){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * A helper function the swaps two elements of an array.
     *
     * @param arr the array whose two elements will be swapped
     * @param i the first element to be swapped
     * @param j the second element to be swapped
     */
    private static <E> void swap(E arr[], int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
