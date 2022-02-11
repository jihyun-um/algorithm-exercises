package javacode.solutions;

// [Problem] https://leetcode.com/problems/max-increase-to-keep-city-skyline
class MaxIncreaseToKeepCitySkyline {
    // Matrix
    // O(n^2) time, O(n) space
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n], colMax = new int[n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                rowMax[row] = Math.max(rowMax[row], grid[row][col]);
                colMax[col] = Math.max(colMax[col], grid[row][col]);
            }
        }
        int totalIncrease = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                totalIncrease += Math.min(rowMax[row], colMax[col]) - grid[row][col];
            }
        }
        return totalIncrease;
    }

    // Test
    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline solution = new MaxIncreaseToKeepCitySkyline();

        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int expectedOutput = 35;
        /*
         gridNew = [[8, 4, 8, 7],
                    [7, 4, 7, 7],
                    [9, 4, 8, 7],
                    [3, 3, 3, 3]]
        */
        int actualOutput = solution.maxIncreaseKeepingSkyline(grid);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}