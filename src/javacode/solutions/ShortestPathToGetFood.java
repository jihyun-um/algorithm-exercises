package javacode.solutions;

import java.util.LinkedList;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/shortest-path-to-get-food
class ShortestPathToGetFood {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    // BFS
    // O(m * n) time, O(m * n) space
    // where m = rowSize and n = colSize
    public int getFood(char[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        int[] startingLocation = findStartingLocation(grid, rowSize, colSize);

        Queue<int[]> locationsToVisit = new LinkedList<>();
        locationsToVisit.add(startingLocation);
        visited[startingLocation[0]][startingLocation[1]] = true;

        int distanceToFood = 0;
        while (!locationsToVisit.isEmpty()) {
            int nextLocationSize = locationsToVisit.size();
            for (int i = 0; i < nextLocationSize; i++) {
                int[] location = locationsToVisit.poll();
                int row = location[0], col = location[1];
                if (grid[row][col] == '#') {
                    return distanceToFood;
                }
                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0], newCol = col + direction[1];
                    if (isValidLocation(newRow, newCol, rowSize, colSize) && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] != 'X') {
                            locationsToVisit.add(new int[]{newRow, newCol});
                        }
                        visited[newRow][newCol] = true;
                    }
                }
            }
            distanceToFood++;
        }
        return -1;
    }

    private int[] findStartingLocation(char[][] grid, int rowSize, int colSize) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                char currentSpot = grid[row][col];
                if (currentSpot == '*') {
                    return new int[]{row, col};
                }
            }
        }
        throw new RuntimeException();
    }

    private boolean isValidLocation(int newRow, int newCol, int rowSize, int colSize) {
        return newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize;
    }

    // Test
    public static void main(String[] args) {
        ShortestPathToGetFood solution = new ShortestPathToGetFood();

        char[][] input1 = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}};
        int expectedOutput1 = 3;
        int actualOutput1 = solution.getFood(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        char[][] input2 = new char[][]{
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}};
        int expectedOutput2 = -1;
        int actualOutput2 = solution.getFood(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
