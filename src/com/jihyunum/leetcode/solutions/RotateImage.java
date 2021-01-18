package com.jihyunum.leetcode.solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/rotate-image/
class RotateImage {

    // test
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectedOutput = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        solution.rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));

        System.out.println("Test passed? " + Arrays.deepEquals(expectedOutput, matrix));
    }

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    // O(n^2) time, O(n) space
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[] tempRow;
        for (int row = 0; row < n / 2; row++) {
            tempRow = matrix[row];
            matrix[row] = matrix[n - row - 1];
            matrix[n - row - 1] = tempRow;
        }

        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */

}
