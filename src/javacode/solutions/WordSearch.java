package javacode.solutions;

// [Problem]https://leetcode.com/problems/word-search
class WordSearch {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    private char[][] board;
    private int rowSize;
    private int colSize;
    private String word;

    // Backtracking
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rowSize = board.length;
        this.colSize = board[0].length;
        this.word = word;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rowSize][colSize];
                    if (backtrack(visited, row, col,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(boolean[][] visited, int row, int col, int wordIndex) {
        visited[row][col] = true;
        if (wordIndex == word.length() - 1) {
            return true;
        }
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && !visited[nextRow][nextCol] && word.charAt(wordIndex + 1) == board[nextRow][nextCol]) {
                if (backtrack(visited, nextRow, nextCol, wordIndex + 1)) {
                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;
    }

    // Test
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String input1 = "ABCCED";
        boolean expectedOutput1 = true;
        boolean actualOutput1 = solution.exist(board, input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String input2 = "SEE";
        boolean expectedOutput2 = true;
        boolean actualOutput2 = solution.exist(board, input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
