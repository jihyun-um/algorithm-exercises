package javacode.solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/subarray-sum-equals-k/
class SubarraySumEqualsK {

    // test
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int expectedOutput = 4;
        int actualOutput = solution.subarraySum(nums, k);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Using cumulative sum array - O(n^2) time, O(n) space
    public int subarraySumWithArray(int[] nums, int k) {
        int result = 0;
        int n = nums.length;

        int sum = 0;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            sums[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (sums[j] - sums[i] == k) {
                    result++;
                }
            }
        }

        return result;
    }

    // Using cumulative sum hashmap - O(n) time, O(n) space
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sumCounts.containsKey(sum - k)) {
                result += sumCounts.get(sum - k);
            }
            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
