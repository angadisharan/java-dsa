package org.matools.java.dsa.window;

public class FixedWindow {

    public static int maxSum(int[] arr, int k) {
        int sum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        return max;
    }
}
