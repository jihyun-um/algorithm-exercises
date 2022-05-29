package solutions;

// [Problem] https://leetcode.com/problems/swap-adjacent-in-lr-string
class SwapAdjacentInString {
    // Two pointers
    // O(n) time, O(1) space
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0, len = start.length();
        while (i < len || j < len) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i >= len || j >= len) {
                break;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            } else if (start.charAt(i) == 'R' && i > j) {
                return false;
            } else if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            i++;
            j++;
        }
        return i == j;
    }

    // Test
    public static void main(String[] args) {
        SwapAdjacentInString solution = new SwapAdjacentInString();

        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        boolean output = solution.canTransform(start, end);

        System.out.println("Test 1 passed? " + (output == true));
    }
}
