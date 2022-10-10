/**
 * This class is an implementation of the merge sort algorithm.
 */
class MergeSort {

    public static int[] mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);

        return array;
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(arr, start, (start + end) / 2, temp);
        mergeSort(arr, (start + end) / 2 + 1, end, temp);
        merge(arr, start, end, temp);
    }

    private static void merge(int[] arr, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = start;

        while (leftIndex <= middle && rightIndex <= end) {
            if (arr[leftIndex] < arr[rightIndex]) {
                temp[index++] = arr[leftIndex++];
            } else {
                temp[index++] = arr[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            temp[index++] = arr[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[index++] = arr[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}
