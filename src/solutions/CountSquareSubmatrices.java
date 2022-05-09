package solutions;

// [Problem] https://leetcode.com/problems/count-square-submatrices-with-all-ones
class CountSquareSubmatrices {
    // Dynamic programming
    // O(m * n) time, O(1) space
    // where m = row size, n = column size
    public int countSquares(int[][] matrix) {
        int count = 0;
        int rowSize = matrix.length, colSize = matrix[0].length;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (matrix[row][col] == 1 && row > 0 && col > 0) {
                    matrix[row][col] = Math.min(matrix[row - 1][col - 1], Math.min(matrix[row - 1][col], matrix[row][col - 1])) + 1;
                }
                count += matrix[row][col];
            }
        }
        return count;
    }

    // Test
    public static void main(String[] args) {
        CountSquareSubmatrices solution = new CountSquareSubmatrices();

        int[][] input = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int expectedOutput = 15;
        int actualOutput = solution.countSquares(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
