package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/top-k-frequent-elements/
class TopKthFrequentElements {

    // test
    public static void main(String[] args) {
        TopKthFrequentElements solution = new TopKthFrequentElements();

        int[] expectedOutput = {1, 2};
        int[] actualOutput = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }

    // Heap solution - O(NlogK) time, O(N) space
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // 1. Build counts map - O(N) time
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // 2. Keep k top frequent elements in the heap - O(NlogK) time
        Queue<Integer> heap = new PriorityQueue<>((num1, num2) -> counts.get(num1) - counts.get(num2));
        for (int num : counts.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 3. Build an output array - O(KlogK) time
        int[] topFrequentNums = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topFrequentNums[i] = heap.poll();
        }

        return topFrequentNums;
    }
}
