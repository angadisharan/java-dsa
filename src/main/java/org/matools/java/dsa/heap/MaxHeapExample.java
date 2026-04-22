package org.matools.java.dsa.heap;

import java.util.Arrays;

public class MaxHeapExample {

    public static void main(String[] args) {

        int[] arr = {10, 20, 15, 30, 40};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Build Heap
        buildHeap(arr);

        System.out.println("After Building Max Heap:");
        System.out.println(Arrays.toString(arr));

        // Delete root (max element)
        int n = arr.length;
        int max = arr[0];

        arr[0] = arr[n - 1]; // move last to root
        n--; // reduce heap size

        heapify(arr, n, 0);

        System.out.println("After Deleting Root (" + max + "):");
        System.out.println(Arrays.toString(Arrays.copyOf(arr, n)));
    }

    // Build Max Heap
    public static void buildHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify function (Max Heap)
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}