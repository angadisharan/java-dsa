package org.matools.java.dsa.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && height[nr][nc] == -1) {
                    height[nr][nc] = height[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return height;
    }
}


/*

Great idea — this is the best way to understand 👍

Let’s take a 4×4 grid with water in the center.

🧩 Sample Input
0 0 0 0
0 1 0 0
0 0 0 0
0 0 0 0

👉 Only one water cell at (1,1)

🧠 Step-by-step thinking
Step 1: Water = 0
-1 -1 -1 -1
-1  0 -1 -1
-1 -1 -1 -1
-1 -1 -1 -1
Step 2: Distance = 1 (neighbors of water)

Cells adjacent to (1,1):

-1  1 -1 -1
 1  0  1 -1
-1  1 -1 -1
-1 -1 -1 -1
Step 3: Distance = 2
 2  1  2 -1
 1  0  1  2
 2  1  2 -1
-1  2 -1 -1
Step 4: Distance = 3
 2  1  2  3
 1  0  1  2
 2  1  2  3
 3  2  3 -1
Step 5: Distance = 4
 2  1  2  3
 1  0  1  2
 2  1  2  3
 3  2  3  4
✅ Final Output
2 1 2 3
1 0 1 2
2 1 2 3
3 2 3 4

 */