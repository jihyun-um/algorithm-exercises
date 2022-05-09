package solutions;

// [Problem] https://leetcode.com/problems/minimum-falling-path-sum
class MinimumFallingPathSum {
    // Dynamic programming
    // O(m * n) time, O(1) space
    // where m = row size, n = column size
    public int minFallingPathSum(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        int totalMinSum = Integer.MAX_VALUE;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (row >= 1) {
                    int minSum = matrix[row][col];
                    if (colSize == 1) {
                        minSum += matrix[row - 1][col];
                    } else if (col == 0) {
                        minSum += Math.min(matrix[row - 1][col], matrix [row - 1][col + 1]);
                    } else if (col == colSize - 1) {
                        minSum += Math.min(matrix[row - 1][col], matrix [row - 1][col - 1]);
                    } else {
                        minSum += Math.min(matrix[row - 1][col], Math.min(matrix[row - 1][col - 1], matrix [row - 1][col + 1]));
                    }
                    matrix[row][col] = minSum;
                }
                if (row == rowSize - 1) {
                    totalMinSum = Math.min(matrix[row][col], totalMinSum);
                }
            }
        }
        return totalMinSum;
    }

    // Test
    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        int[][] input = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int expectedOutput = 13;
        int actualOutput = solution.minFallingPathSum(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
