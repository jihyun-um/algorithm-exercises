package javacode.solutions;

// [Problem] https://leetcode.com/problems/battleships-in-a-board
class BattleshipsInBoard {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    // DFS
    // O(m * n) time, O(1) space
    // where m = rowSize, n = colSize
    public int countBattleshipsDfs(char[][] board) {
        if (board.length == 0) {
            return 0;
        }
        int rowSize = board.length, colSize = board[0].length;
        int count = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 'X') {
                    count++;
                    markCounted(board, row, col);
                }
            }
        }
        return count;
    }

    private void markCounted(char[][] board, int row, int col) {
        board[row][col] = '.';
        int rowSize = board.length, colSize = board[0].length;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && board[nextRow][nextCol] == 'X') {
                markCounted(board, nextRow, nextCol);
            }
        }
    }

    // Simple counting
    // O(m * n) time, O(1) space
    // where m = rowSize, n = colSize
    public int countBattleships(char[][] board) {
        if (board.length == 0) {
            return 0;
        }
        int rowSize = board.length, colSize = board[0].length;
        int count = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 'X'
                        && (row == 0 || board[row - 1][col] != 'X')
                        && (col == 0 || board[row][col - 1] != 'X')) {
                    count++;
                }
            }
        }
        return count;
    }

    // Test
    public static void main(String[] args) {
        BattleshipsInBoard solution = new BattleshipsInBoard();

        char[][] input1 = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}};
        int expectedOutput1 = 2;
        int actualOutput1 = solution.countBattleships(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        char[][] input2 = {{'.'}};
        int expectedOutput2 = 0;
        int actualOutput2 = solution.countBattleships(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
