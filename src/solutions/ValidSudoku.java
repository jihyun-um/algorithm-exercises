package solutions;

// [Problem] https://leetcode.com/problems/valid-sudoku
class ValidSudoku {
    // Using 2d arrays for frequency counting
    // O(n^2) time, O(n^2) space
    // but since n is always 9, it is O(1)
    public boolean isValidSudoku(char[][] board) {
        final int N = 9;
        int[][] rowFrequencies = new int[N][N];
        int[][] colFrequencies = new int[N][N];
        int[][] boxFrequencies = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int[] rowFrequency = rowFrequencies[row];
                int[] colFrequency = colFrequencies[col];
                int box = (row / 3) * 3 + (col / 3);
                int[] boxFrequency = boxFrequencies[box];

                char cell = board[row][col];
                if (cell == '.') {
                    continue;
                }
                if (rowFrequency[cell - '1']++ > 0 || colFrequency[cell - '1']++ > 0 || boxFrequency[cell - '1']++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        char[][] input1 = {
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
        boolean expectedOutput1 = true;
        boolean actualOutput1 = solution.isValidSudoku(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        char[][] input2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean expectedOutput2 = false;
        boolean actualOutput2 = solution.isValidSudoku(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
