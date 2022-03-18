package javacode.solutions;

import java.util.LinkedList;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/number-of-islands
class NumberOfIslands {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    public int numIslands(char[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int islandCount = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == '1') {
                    exploreIslandDfs(grid, row, col);
//                    exploreIslandBfs(grid, row, col);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // DFS
    // O(m * n) time, O(m * n) space
    // where m = rowSize and n = colSize
    private void exploreIslandDfs(char[][] grid, int row, int col) {
        int rowSize = grid.length, colSize = grid[0].length;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && grid[newRow][newCol] == '1') {
                grid[newRow][newCol] = '0'; // mark visited cell as '0'
                exploreIslandDfs(grid, newRow, newCol);
            }
        }
    }

    // BFS
    // O(m * n) time, O(min(m,n)) space for the queue
    // where m = rowSize and n = colSize
    private void exploreIslandBfs(char[][] grid, int row, int col) {
        int rowSize = grid.length, colSize = grid[0].length;
        Queue<int[]> locationsToVisit = new LinkedList<>();
        locationsToVisit.add(new int[]{row, col});

        while (!locationsToVisit.isEmpty()) {
            int nextLocations = locationsToVisit.size();
            for (int i = 0; i < nextLocations; i++) {
                int[] location = locationsToVisit.poll();
                for (int[] direction : DIRECTIONS) {
                    int newRow = location[0] + direction[0];
                    int newCol = location[1] + direction[1];
                    if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && grid[newRow][newCol] == '1') {
                        locationsToVisit.add(new int[]{newRow, newCol});
                        grid[newRow][newCol] = '0'; // mark visited cell as '0'
                    }
                }
            }
        }
    }

    // Test
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] input1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', 'O', '1', '0'},
                {'1', '1', 'O', 'O', '0'},
                {'0', '0', '0', '0', '0'}};
        int expectedOutput1 = 1;
        int actualOutput1 = solution.numIslands(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        char[][] input2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', 'O', '0', '0'},
                {'0', '0', '1', 'O', '0'},
                {'0', '0', '0', '1', '1'}};
        int expectedOutput2 = 3;
        int actualOutput2 = solution.numIslands(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
