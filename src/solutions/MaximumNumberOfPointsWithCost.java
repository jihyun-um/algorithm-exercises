package solutions;

// [Problem] https://leetcode.com/problems/maximum-number-of-points-with-cost
class MaximumNumberOfPointsWithCost {
    // Dynamic programming
    // O(m * n) time, O(n) space
    // where m = row size, n = column size
    public long maxPoints(int[][] points) {
        int rowSize = points.length, colSize = points[0].length;
        long[] prevRow = new long[colSize];
        for (int col = 0; col < colSize; col++) {
            prevRow[col] = points[0][col];
        }
        for (int row = 1; row < rowSize; row++) {
            long[] left = new long[colSize], right = new long[colSize], currentRow = new long[colSize];
            left[0] = prevRow[0];
            for (int i = 1; i < colSize; i++) {
                left[i] = Math.max(left[i - 1] - 1, prevRow[i]);
            }
            right[colSize - 1] = prevRow[colSize - 1];
            for (int j = colSize - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prevRow[j]);
            }
            for (int k = 0; k < colSize; k++) {
                currentRow[k] = Math.max(left[k], right[k]) + points[row][k];
            }
            prevRow = currentRow;
        }
        long max = 0;
        for (int i = 0; i < colSize; i++) {
            max = Math.max(prevRow[i], max);
        }
        return max;
    }

    // Test
    public static void main(String[] args) {
        MaximumNumberOfPointsWithCost solution = new MaximumNumberOfPointsWithCost();

        int[][] input = {
                {1, 2, 3},
                {1, 5, 1},
                {3, 1, 1}
        };
        long expectedOutput = 9;
        long actualOutput = solution.maxPoints(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
