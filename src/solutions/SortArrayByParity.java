package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/sort-array-by-parity
class SortArrayByParity {
    // Two pointers
    // O(n) time, O(n) space
    public int[] sortArrayByParity(int[] nums) {
        int[] sortedNums = new int[nums.length];
        int evenIndex = 0, oddIndex = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                sortedNums[evenIndex++] = num;
            } else {
                sortedNums[oddIndex--] = num;
            }
        }
        return sortedNums;
    }

    // test
    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();

        int[] nums = {3, 1, 2, 4};
        int[] expectedOutput = {2, 4, 1, 3};
        int[] actualOutput = solution.sortArrayByParity(nums);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }
}
