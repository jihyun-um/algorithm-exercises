package solutions;

// [Problem] https://leetcode.com/problems/island-perimeter
class IslandPerimeter {
    // Matrix simple counting
    // O(mn) time, where m = row length, n = column length
    // O(1) space
    public int islandPerimeter(int[][] grid) {
        int rowLength = grid.length, colLength = grid[0].length;
        int perimeter = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    if (row == 0 || grid[row - 1][col] == 0) { // top
                        perimeter++;
                    }
                    if (row == rowLength - 1 || grid[row + 1][col] == 0) { // bottom
                        perimeter++;
                    }
                    if (col == 0 || grid[row][col - 1] == 0) { // left
                        perimeter++;
                    }
                    if (col == colLength - 1 || grid[row][col + 1] == 0) { // right
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    // Matrix neighbor counting
    // O(mn) time, O(1) space
    public int islandPerimeterNeighborCounting(int[][] grid) {
        int rowLength = grid.length, colLength = grid[0].length;
        int islands = 0, neighbors = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    islands++;
                    if (row < rowLength - 1 && grid[row + 1][col] == 1) {
                        neighbors++; // right neighbor
                    }
                    if (col < colLength - 1 && grid[row][col + 1] == 1) {
                        neighbors++; // bottom neighbor
                    }
                }
            }
        }
        return islands * 4 - neighbors * 2;
    }

    // DFS
    // O(mn) time, O(1) space
    public int islandPerimeterDfs(int[][] grid) {
        int rowLength = grid.length, colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    return getPerimeter(grid, row, col);
                }
            }
        }
        return 0;
    }

    private int getPerimeter(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] == -1) { // has been visited
            return 0;
        }
        grid[row][col] = -1;
        return getPerimeter(grid, row - 1, col) // top
                + getPerimeter(grid, row + 1, col) // bottom
                + getPerimeter(grid, row, col - 1) // left
                + getPerimeter(grid, row, col + 1); // right
    }

    // Test
    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();

        int[][] input = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int expectedOutput = 16;
        int actualOutput = solution.islandPerimeter(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}