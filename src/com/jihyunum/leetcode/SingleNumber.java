package com.jihyunum.leetcode;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/single-number
class SingleNumber {

    // test
    public static void main(String[] args) {

        SingleNumber solution = new SingleNumber();

        int[] input = new int[]{4, 1, 2, 1, 2};
        int expectedOutput = 4;
        int actualOutput = solution.singleNumber(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));

    }

    // HashMap solution - O(N) Time, O(N) Space
    private int singleNumberHashmap(int[] nums) {
        Map<Integer, Integer> numOccurrence = new HashMap<>();
        for (int num : nums) {
            numOccurrence.put(num, numOccurrence.containsKey(num) ? numOccurrence.get(num) + 1 : 1);
        }

        for (int num : numOccurrence.keySet()) {
            if (numOccurrence.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }

    // XOR bit manipulation solution - O(N) Time, O(1) Space
    private int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

}
