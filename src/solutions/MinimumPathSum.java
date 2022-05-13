package solutions;

// [Problem] https://leetcode.com/problems/minimum-path-sum
class MinimumPathSum {
    // Bottom-up DP
    // O(m * n) time, O(m * n) space
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int[][] dp = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                dp[row][col] = grid[row][col];
                if (row == 0 && col > 0) {
                    dp[row][col] += dp[row][col - 1];
                } else if (row > 0 && col == 0) {
                    dp[row][col] += dp[row - 1][col];
                } else if (row > 0 && col > 0) {
                    dp[row][col] += Math.min(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }
        return dp[rowSize - 1][colSize - 1];
    }

    // Test
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();

        int[][] input1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int expectedOutput1 = 7;
        int actualOutput1 = solution.minPathSum(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] input2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int expectedOutput2 = 12;
        int actualOutput2 = solution.minPathSum(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}