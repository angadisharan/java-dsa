package org.matools.java.dsa.matrix;

import org.matools.java.dsa.utils.Utils;

public class MatrixTranspose {

    public static void main(String[] args) {

        // Rectangular matrix (m x n)
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Original Matrix (Rectangular):");
        Utils.printMatrix(matrix1);

        int[][] transposed1 = transpose(matrix1);

        System.out.println("Transposed Matrix:");
        Utils.printMatrix(transposed1);


        // Square matrix (n x n)
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("\nOriginal Matrix (Square):");
        Utils.printMatrix(matrix2);

        transposeInPlace(matrix2);

        System.out.println("Transposed Matrix (In-Place):");
        Utils.printMatrix(matrix2);
    }

    // ✅ For any matrix (m x n → n x m)
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // ✅ In-place transpose (only for square matrix)
    public static void transposeInPlace(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


}