package solutions;

// [Problem] https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips
class RemoveAllOnes {
    // Matrix
    // O(m * n) time, O(1) space
    public boolean removeOnes(int[][] grid) {
        int[] sampleRow = grid[0];
        for (int[] row : grid) {
            if (!isSameOrOpposite(row, sampleRow)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameOrOpposite(int[] row, int[] sampleRow) {
        for (int i = 0; i < row.length; i++) {
            if (Math.abs(row[i] - sampleRow[i]) != Math.abs(row[0] - sampleRow[0])) {
                return false;
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        RemoveAllOnes solution = new RemoveAllOnes();

        int[][] input1 = new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        boolean expectedOutput1 = true;
        boolean actualOutput1 = solution.removeOnes(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] input2 = new int[][]{{1, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        boolean expectedOutput2 = false;
        boolean actualOutput2 = solution.removeOnes(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
