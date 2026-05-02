package org.matools.java.string;

public class Permutation {

    public static void main(String[] args) {
        String str = "ABCD";
        permute(str.toCharArray(), 0);
    }

    static void permute(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(new String(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);          // choose
            permute(arr, index + 1);      // explore
            swap(arr, index, i);          // backtrack
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}