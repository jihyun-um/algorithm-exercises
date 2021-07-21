package javacode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/two-sum/
class TwoSum {

    // test
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expectedOutput = new int[]{0, 1};
        int[] actualOutput = twoSum(nums, target);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));

    }

    // O(N) Hashtable solution
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{ indexMap.get(complement), i };
            }
            indexMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution available");
    }

}
