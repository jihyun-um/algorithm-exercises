package javacode.solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/counting-bits
class CountingBits {
    // Bit Manipulation
    // O(n) time, O(n) space
    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bitCounts[i] = bitCounts[i >> 1] + (i & 1);
        }
        return bitCounts;
    }

    // Dynamic Programming
    // O(n) time, O(n) space
    public int[] countBitsDp(int n) {
        int[] bitCounts = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (i == offset * 2) {
                offset *= 2;
            }
            bitCounts[i] = 1 + bitCounts[i - offset];
        }
        return bitCounts;
    }

    // Test
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        int input = 5;
        int[] expectedOutput = {0, 1, 1, 2, 1, 2};
        /*
            0 --> 0     0
            1 --> 1     1
            2 --> 10    1
            3 --> 11    2
            4 --> 100   1
            5 --> 101   2

        */
        int[] actualOutput = solution.countBits(input);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));

    }
}
