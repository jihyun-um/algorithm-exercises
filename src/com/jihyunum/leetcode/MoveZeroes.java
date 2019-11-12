package com.jihyunum.leetcode;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/move-zeroes/
class MoveZeroes {

    // test
    public static void main(String[] args) {

        MoveZeroes solution = new MoveZeroes();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] expectedOutput = new int[]{1, 3, 12, 0, 0};
        solution.moveZeroes(nums);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, nums));

    }

    // Bubble sort solution - O(N^2) Time, O(1) Space
    private void moveZeroesBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

    // Insert solution - O(N) Time, O(1) Space
    private void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroIndex++] = num;
            }
        }
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

}
