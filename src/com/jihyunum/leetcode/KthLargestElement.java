package com.jihyunum.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// [Problem] https://leetcode.com/problems/kth-largest-element-in-an-array/
class KthLargestElement {

    // test
    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        int actualOutput = findKthLargest(nums, k);
        int expectedOutput = 5;

        System.out.println("Test passed? " + (expectedOutput == actualOutput));

    }

    // O(NlogN) Sort solution
    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // O(NlogK) Minimum Heap solution
    private static int findKthLargestWithMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> largestNumbers = new PriorityQueue<>();
        for (int num : nums) {
            if (largestNumbers.size() < k) {
                largestNumbers.add(num);
            } else {
                int minNum = largestNumbers.peek();
                if (num > minNum) {
                    largestNumbers.poll();
                    largestNumbers.add(num);
                }
            }
        }
        return largestNumbers.peek();
    }

}
