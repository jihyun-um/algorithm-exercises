package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/concatenation-of-array/
class ConcatenationOfArray {
    // Array
    // O(n) time, O(n) space
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] concatenatedArr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            concatenatedArr[i] = concatenatedArr[i + n] = nums[i];
        }
        return concatenatedArr;
    }

    // Test
    public static void main(String[] args) {
        ConcatenationOfArray solution = new ConcatenationOfArray();

        int[] nums = {1, 2, 1};
        int[] expectedOutput = {1, 2, 1, 1, 2, 1};
        int[] actualOutput = solution.getConcatenation(nums);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }
}
