package com.jihyunum.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/majority-element/
class MajorityElement {

    // test
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        int[] input = new int[]{2, 2, 1, 1, 1, 2, 2};
        int expectedOutput = 2;
        int actualOutput = solution.majorityElement(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // HashMap solution - O(n) time, O(n) space
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        Integer frequency;
        for (int num : nums) {
            frequency = frequencies.get(num);
            frequencies.put(num, frequency == null ? 1 : frequency + 1);
        }

        int maxFrequency = 0, majorityNum = 0;
        for (Integer num : frequencies.keySet()) {
            if (frequencies.get(num) > maxFrequency) {
                maxFrequency = frequencies.get(num);
                majorityNum = num;
            }
        }

        return majorityNum;
    }

    // Sorting solution - O(nlogn) time, O(1) or O(n) space
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
