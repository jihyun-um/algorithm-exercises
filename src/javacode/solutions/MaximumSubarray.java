package javacode.solutions;

// [Problem] https://leetcode.com/problems/maximum-subarray/
class MaximumSubarray {

    // test
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        // [4,-1,2,1] has the largest sum = 6
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expectedOutput = 6;
        int actualOutput = solution.maxSubArray(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Dynamic Programming solution - O(n) time, O(1) space
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int sum = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i] + sum , nums[i]);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
