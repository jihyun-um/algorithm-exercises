package javacode.solutions;

import java.util.LinkedList;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/shortest-path-in-binary-matrix
class ShortestPathInBinaryMatrix {
    private static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    // BFS
    // O(n) time, O(n) space
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        if (grid[0][0] != 0 || grid[rowSize - 1][colSize - 1] != 0) {
            return -1;
        }
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<int[]> locationsToVisit = new LinkedList<>();
        locationsToVisit.add(new int[]{0, 0});
        int pathLength = 1;

        while (!locationsToVisit.isEmpty()) {
            int nextLocations = locationsToVisit.size();
            for (int i = 0; i < nextLocations; i++) {
                int[] location = locationsToVisit.poll();
                int row = location[0], col = location[1];
                if (row == rowSize - 1 && col == rowSize - 1) {
                    return pathLength;
                }
                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize &&
                            !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                        locationsToVisit.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            pathLength++;
        }
        return -1;
    }

    // Test
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();

        int[][] input1 = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int expectedOutput1 = 4;
        int actualOutput1 = solution.shortestPathBinaryMatrix(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] input2 = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int expectedOutput2 = -1;
        int actualOutput2 = solution.shortestPathBinaryMatrix(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
