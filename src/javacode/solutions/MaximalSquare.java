package javacode.solutions;

// [Problem] https://leetcode.com/problems/maximal-square/
class MaximalSquare {

    // test
    public static void main(String[] args) {
        MaximalSquare solution = new MaximalSquare();

        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int expectedOutput = 4;
        int actualOutput = solution.maximalSquare(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Dynamic programming - O(mn) time, O(mn) space
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int maxLength = 0;

        // dp(i, j) = min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1)) + 1.
        int[][] dp = new int[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < columnSize; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = matrix[row][col] - '0';
                } else if (matrix[row][col] == '1'){
                    dp[row][col] = Math.min(Math.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1;
                }
                maxLength = Math.max(maxLength, dp[row][col]);
            }
        }

        return maxLength * maxLength;
    }
}
