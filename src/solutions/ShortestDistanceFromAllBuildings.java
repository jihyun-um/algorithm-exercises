package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/shortest-distance-from-all-buildings
class ShortestDistanceFromAllBuildings {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    // BFS
    // O(m^2 * n^2) time, O(m * n) space
    // m = number of rows, n = number of cols
    public int shortestDistance(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int totalBuildingCount = 0;
        int[][] distances = new int[rowSize][colSize];
        int[][] buildingCounts = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 1) {
                    totalBuildingCount++;
                    countDistances(grid, distances, buildingCounts, new int[]{row, col});
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (buildingCounts[row][col] == totalBuildingCount) {
                    minDistance = Math.min(minDistance, distances[row][col]);
                }
            }
        }
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }

    private void countDistances(int[][] grid, int[][] distances, int[][] buildingCounts, int[] startingPoint) {
        int rowSize = grid.length, colSize = grid[0].length;
        Queue<int[]> locationsToVisit = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];
        locationsToVisit.offer(startingPoint);
        visited[startingPoint[0]][startingPoint[1]] = true;

        int distance = 0;
        while (!locationsToVisit.isEmpty()) {
            int locationSize = locationsToVisit.size();
            for (int i = 0; i < locationSize; i++) {
                int[] location = locationsToVisit.poll();
                int row = location[0], col = location[1];
                if (grid[row][col] == 0) {
                    distances[row][col] += distance;
                    buildingCounts[row][col] += 1;
                }
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextCol >= 0 && nextRow < rowSize && nextCol < colSize) {
                        if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                            visited[nextRow][nextCol] = true;
                            locationsToVisit.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            distance++;
        }
    }

    // Test
    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings solution = new ShortestDistanceFromAllBuildings();

        int[][] input1 = new int[][]{
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};
        int expectedOutput1 = 7;
        int actualOutput1 = solution.shortestDistance(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] input2 = new int[][]{{1}};
        int expectedOutput2 = -1;
        int actualOutput2 = solution.shortestDistance(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
