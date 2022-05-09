package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/number-of-good-pairs
class NumberOfGoodPairs {

    // test
    public static void main(String[] args) {
        NumberOfGoodPairs solution = new NumberOfGoodPairs();

        int[] input = new int[]{1, 2, 3, 1, 1, 3};
        int expectedOutput = 4;
        int actualOutput = solution.numIdenticalPairs(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // O(N) time, O(K) space where K = number of unique numbers
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            int occurrence = occurrences.getOrDefault(num, 0);
            occurrences.put(num, occurrence + 1);
        }
        int numPairs = 0;
        for (int numOccurrences : occurrences.values()) {
            numPairs += getNumPairs(numOccurrences);
        }
        return numPairs;
    }

    // If a number appears n times,
    // n * (n – 1) / 2 pairs can be made with this number
    private int getNumPairs(int n) {
        return (n * (n - 1)) / 2;
    }

}
