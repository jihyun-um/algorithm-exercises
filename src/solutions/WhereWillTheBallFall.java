package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/where-will-the-ball-fall
class WhereWillTheBallFall {
    // Matrix
    // O(m * n) time, O(n) space
    // where m = row size, n = column size
    public int[] findBall(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length;
        int[] ballPositions = new int[colSize];
        for (int ball = 0; ball < colSize; ball++) {
            int row = 0, col = ball;
            while (row < rowSize) {
                int direction = grid[row][col];
                int nextCol = col + direction;
                if (nextCol < 0 || nextCol >= colSize || grid[row][nextCol] != direction) {
                    ballPositions[ball] = -1;
                    break;
                }
                row++;
                col = nextCol;
            }
            if (row == rowSize) {
                ballPositions[ball] = col;
            }
        }
        return ballPositions;
    }

    // Test
    public static void main(String[] args) {
        WhereWillTheBallFall solution = new WhereWillTheBallFall();

        int[][] input = {
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };
        int[] expectedOutput = {1, -1, -1, -1, -1};
        int[] actualOutput = solution.findBall(input);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }
}
