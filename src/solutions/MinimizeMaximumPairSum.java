package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/minimize-maximum-pair-sum-in-array
class MinimizeMaximumPairSum {
    // O(nlogn) time, O(1) space
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left++] + nums[right--];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    // test
    public static void main(String[] args) {
        MinimizeMaximumPairSum solution = new MinimizeMaximumPairSum();

        int[] input = {3, 5, 4, 2, 4, 6};
        int expectedOutput = 8;
        int actualOutput = solution.minPairSum(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
