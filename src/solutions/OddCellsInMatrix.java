package solutions;

// [Problem] https://leetcode.com/problems/cells-with-odd-values-in-a-matrix
class OddCellsInMatrix {
    // Matrix
    // O(k(m + n) + m * n) time, where k = indices.length
    // O(m * n) space
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            int rowIndex = index[0], columnIndex = index[1];
            for (int i = 0; i < n; i++) {
                matrix[rowIndex][i]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][columnIndex]++;
            }
        }
        int oddCount = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] % 2 == 1) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }

    // Row and column arrays to simulate matrix
    // O(k + m * n) time, where k = indices.length
    // O(m + n) space
    public int oddCellsArray(int m, int n, int[][] indices) {
        int[] rows = new int[m], columns = new int[n];
        for (int[] index : indices) {
            int rowIndex = index[0], columnIndex = index[1];
            rows[rowIndex]++;
            columns[columnIndex]++;
        }
        int oddCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + columns[j]) % 2 == 1) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }

    // Test
    public static void main(String[] args) {
        OddCellsInMatrix solution = new OddCellsInMatrix();

        int m = 2, n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        int expectedOutput = 6;
        int actualOutput = solution.oddCells(m, n, indices);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
