package com.jihyunum.leetcode;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/maximal-rectangle/
class MaximalRectangle {

    // test
    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();

        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int expectedOutput = 6;
        int actualOutput = solution.maximalRectangle(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Dynamic programming 1 - O(mn^2) time, O(mn) space
    public int maximalRectangleDP1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int maxArea = 0;

        int[][] rowLengths = new int[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < columnSize; col++) {
                if (matrix[row][col] == '1') {
                    rowLengths[row][col] = col == 0 ? 1 : rowLengths[row][col - 1] + 1;

                    // bottom up calculation
                    int width = rowLengths[row][col], height;
                    for (int i = row; i >= 0; i--) {
                        width = Math.min(width, rowLengths[i][col]);
                        height = row - i + 1;
                        maxArea = Math.max(maxArea, width * height);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(rowLengths));

        return maxArea;
    }

    // Dynamic programming 2 - O(mn) time, O(mn) space
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        int[] left = new int[columnSize]; // initialize left as the leftmost boundary possible
        int[] right = new int[columnSize];
        int[] height = new int[columnSize];

        Arrays.fill(right, columnSize); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int row = 0; row < rowSize; row++) {
            int curLeft = 0, curRight = columnSize;
            // update height
            for (int col = 0; col < columnSize; col++) {
                if (matrix[row][col] == '1') height[col]++;
                else height[col] = 0;
            }
            // update left
            for (int j = 0; j < columnSize; j++) {
                if (matrix[row][j] == '1') left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            // update right
            for (int j = columnSize - 1; j >= 0; j--) {
                if (matrix[row][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = columnSize;
                    curRight = j;
                }
            }
            // update area
            for (int j = 0; j < columnSize; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

}
