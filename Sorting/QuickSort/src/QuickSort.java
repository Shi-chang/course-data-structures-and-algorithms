/**
 * This class is an implementation of the quick sort algorithm.
 */
class QuickSort {

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}

