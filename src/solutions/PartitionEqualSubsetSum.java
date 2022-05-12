package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// [Problem] https://leetcode.com/problems/partition-equal-subset-sum
class PartitionEqualSubsetSum {
    // Top-down DP with memo
    // O(n * s) time, O(n * s) space
    // where n = input length, s = subset sum
    public boolean canPartition(int[] nums) {
        int numLen = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int subsetSum = sum / 2;
        Boolean[][] memo = new Boolean[numLen][subsetSum + 1];
        return canPartitionRecursive(memo, nums, 0, subsetSum);
    }

    private boolean canPartitionRecursive(Boolean[][] memo, int[] nums, int currentIndex, int currentSum) {
        if (currentSum == 0) {
            return true;
        }
        if (currentIndex >= nums.length) {
            return false;
        }
        if (memo[currentIndex][currentSum] == null) {
            if (nums[currentIndex] <= currentSum
                    && canPartitionRecursive(memo, nums, currentIndex + 1, currentSum - nums[currentIndex])) {
                memo[currentIndex][currentSum] = true;
                return true;
            }
            memo[currentIndex][currentSum] = canPartitionRecursive(memo, nums, currentIndex + 1, currentSum);
        }
        return memo[currentIndex][currentSum];
    }

    // Bottom-up DP
    // O(n * s) time, O(n * s) space
    public boolean canPartitionBottomUp(int[] nums) {
        int numLen = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int subsetSum = sum / 2;
        boolean[][] dp = new boolean[numLen][subsetSum + 1];
        // first column - always true as sum of empty subset is zero
        for (int n = 0; n < numLen; n++) {
            dp[n][0] = true;
        }
        // first row - true if its value is equal to subset sum
        for (int s = 1; s <= subsetSum; s++) {
            dp[0][s] = nums[0] == s;
        }
        for (int n = 1; n < numLen; n++) {
            for (int s = 1; s <= subsetSum; s++) {
                if (s >= nums[n]) {
                    dp[n][s] = dp[n - 1][s] || dp[n - 1][s - nums[n]];
                } else {
                    dp[n][s] = dp[n - 1][s];
                }
            }
        }
        return dp[numLen - 1][subsetSum];
    }

    // Test
    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        int[] input1 = {1, 5, 11, 5};
        boolean output1 = solution.canPartition(input1);
        System.out.println("Test 1 passed? " + (output1 == true));

        int[] input2 = {1, 2, 3, 5};
        boolean output2 = solution.canPartition(input2);
        System.out.println("Test 2 passed? " + (output2 == false));
    }
}
