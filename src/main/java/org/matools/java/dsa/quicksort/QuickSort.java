package org.matools.java.dsa.quicksort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);   // left
            quickSort(arr, pi + 1, high);  // right
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pick last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}