package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/subarray-sum-equals-k
class SubarraySumEqualsK {
    // Hashmap storing prefix sum
    // O(n) time, O(n) space
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (sumCounts.containsKey(sum - k)) {
                count += sumCounts.get(sum - k);
            }
            int sumCount = sumCounts.getOrDefault(sum, 0);
            sumCounts.put(sum, sumCount + 1);
        }
        return count;
    }

    // Test
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int expectedOutput = 4;
        int actualOutput = solution.subarraySum(nums, k);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
