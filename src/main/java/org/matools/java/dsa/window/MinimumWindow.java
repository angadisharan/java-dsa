package org.matools.java.dsa.window;

public class MinimumWindow {

    public static int minSubArray(int[] arr, int target) {
        int left = 0, sum = 0, min = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
