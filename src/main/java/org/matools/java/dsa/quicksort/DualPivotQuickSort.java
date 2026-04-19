package org.matools.java.dsa.quicksort;

public class DualPivotQuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 8, 2, 5, 4, 6};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int[] pivots = partition(arr, low, high);

            quickSort(arr, low, pivots[0] - 1);        // left
            quickSort(arr, pivots[0] + 1, pivots[1] - 1); // middle
            quickSort(arr, pivots[1] + 1, high);       // right
        }
    }

    public static int[] partition(int[] arr, int low, int high) {

        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        int pivot1 = arr[low];
        int pivot2 = arr[high];

        int i = low + 1;
        int lt = low + 1;
        int gt = high - 1;

        while (i <= gt) {
            if (arr[i] < pivot1) {
                swap(arr, i, lt);
                lt++;
            } else if (arr[i] > pivot2) {
                swap(arr, i, gt);
                gt--;
                i--; // important
            }
            i++;
        }

        lt--;
        gt++;

        swap(arr, low, lt);
        swap(arr, high, gt);

        return new int[]{lt, gt};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}