package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/sudoku-solver
class SudokuSolver {
    static final int N = 9;

    // Backtracking
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char candidate = '1'; candidate <= '9'; candidate++) {
                    if (isValid(board, row, col, candidate)) {
                        board[row][col] = candidate;
                        if (solve(board)) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char candidate) {
        for (int i = 0; i < N; i++) {
            if (board[row][i] == candidate) {
                return false;
            }
            if (board[i][col] == candidate) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == candidate) {
                return false;
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        SudokuSolver solution = new SudokuSolver();
        char[][] input = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] expectedOutput = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        solution.solveSudoku(input);
        System.out.println("Test passed? " + Arrays.deepToString(input));
        System.out.println("Test passed? " + Arrays.deepEquals(input, expectedOutput));
    }
}
