package org.matools.java.dsa.matrix;

public class SearchSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 9;

        boolean found = search(matrix, target);

        System.out.println("Target " + target + " found: " + found);
    }

    public static boolean search(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1; // top-right

        while (row < m && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // move left
            } else {
                row++; // move down
            }
        }

        return false;
    }
}