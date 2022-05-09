package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/running-sum-of-1d-array/
class RunningSumOfArray {

    // test
    public static void main(String[] args) {
        RunningSumOfArray solution = new RunningSumOfArray();

        int[] nums = {1, 2, 3, 4};
        int[] expectedOutput = {1, 3, 6, 10};
        int[] actualOutput = solution.runningSum(nums);

        System.out.println(Arrays.toString(actualOutput));
        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }

    // O(n) time, O(n) space
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        return sums;
    }

}
