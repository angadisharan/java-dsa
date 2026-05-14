package org.matools.java.matrix;

import java.util.*;

import static org.matools.java.dsa.utils.Utils.printMatrix;

public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];

        // Initialize all cells as unvisited
        for (int i = 0; i < m; i++) {
            Arrays.fill(height[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        // Multi-source BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        height[newRow][newCol] == -1) {

                    height[newRow][newCol] = height[row][col] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return height;
    }

    public static void main(String[] args) {

        int[][] isWater = {
                {0, 1},
                {0, 0}
        };

        MapOfHighestPeak solution = new MapOfHighestPeak();

        int[][] result = solution.highestPeak(isWater);

        System.out.println("Height Map:");

        printMatrix(result);
    }
}