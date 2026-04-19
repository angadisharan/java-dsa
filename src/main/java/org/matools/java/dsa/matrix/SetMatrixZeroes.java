package org.matools.java.dsa.matrix;

import org.matools.java.dsa.utils.Utils;

public class SetMatrixZeroes {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println("Original:");
        Utils.printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("After Set Zeroes:");
        Utils.printMatrix(matrix);
    }

//    If any cell is 0 → entire row & column = 0
    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // check first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }

        // mark
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++)
                    matrix[i][j] = 0;
            }
        }

        // first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        // first col
        if (firstColZero) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }


}