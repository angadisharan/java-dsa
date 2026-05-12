package org.matools.java.skyline;

import java.util.*;

class SkyLineProblem {

    private List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        List<int[]> events = new ArrayList<>();

        for (int[] i : buildings) {
            events.add(new int[]{i[0], -1 * i[2]});
            events.add(new int[]{i[1], i[2]});
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(0);
        int previousHeight = 0;

        for (int[] event : events) {
            int x = event[0];
            int height = event[1];
            if (height < 0) {
                priorityQueue.add(height * -1);
            } else {
                priorityQueue.remove(height);
            }

            int currentHeight = priorityQueue.peek();
            if (previousHeight != currentHeight) {
                result.add(Arrays.asList(x, currentHeight));
                previousHeight = currentHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SkyLineProblem s = new SkyLineProblem();

        // [left, right, height]
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12}
        };
        //op : [[2, 10], [3, 15], [7, 12], [12, 0]]

        List<List<Integer>> skyline =
                s.getSkyline(buildings);

        System.out.println(skyline);
    }
}