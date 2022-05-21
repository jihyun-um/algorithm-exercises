package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/sliding-window-maximum
class SlidingWindowMaximum {
    // Sliding window with Deque
    // O(n) time, O(k) space
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n - k + 1];
        Deque<Integer> windowIndices = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int maxIndex = i - k + 1;
            if (!windowIndices.isEmpty() && windowIndices.peek() < maxIndex) {
                windowIndices.poll();
            }
            while (!windowIndices.isEmpty() && nums[windowIndices.peekLast()] < nums[i]) {
                windowIndices.pollLast();
            }
            windowIndices.add(i);
            if (maxIndex >= 0) {
                max[maxIndex] = nums[windowIndices.peek()];
            }
        }
        return max;
    }

    // Test
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] expectedOutput = {3, 3, 5, 5, 6, 7};
        int[] actualOutput = solution.maxSlidingWindow(input, 3);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }
}
