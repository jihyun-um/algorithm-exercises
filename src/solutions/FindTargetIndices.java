package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [Problem] https://leetcode.com/problems/find-target-indices-after-sorting-array
class FindTargetIndices {
    // Sorting
    // O(nlogn) time, O(n) space
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums); // O(nlogn) time
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);
            } else if (!indices.isEmpty()) {
                break;
            }
        }
        return indices;
    }

    // Without sorting
    // O(n) time, O(n) space
    public List<Integer> targetIndicesWithoutSorting(int[] nums, int target) {
        int targetCount = 0, belowTargetCount = 0;
        for (int num : nums) {
            if (num == target) {
                targetCount++;
            } else if (num < target) {
                belowTargetCount++;
            }
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            indices.add(belowTargetCount + i);
        }
        return indices;
    }

    // Test
    public static void main(String[] args) {
        FindTargetIndices solution = new FindTargetIndices();

        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;
        List<Integer> expectedOutput = List.of(1, 2);
        List<Integer> actualOutput = solution.targetIndices(nums, target);

        System.out.println(actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
