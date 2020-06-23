package com.jihyunum.leetcode;

// [Problem] https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
class SubstringsContainingAllThreeCharacters {

    // test
    public static void main(String[] args) {
        SubstringsContainingAllThreeCharacters solution = new SubstringsContainingAllThreeCharacters();

        // "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
        String input = "abcabc";
        int expectedOutput = 10;
        int actualOutput = solution.numberOfSubstrings(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Sliding window - O(n) time, O(1) space
    public int numberOfSubstringsSlidingWindow(String s) {
        int result = 0, i = 0;
        int[] counts = {0, 0, 0};
        for (int j = 0; j < s.length(); j++) {
            counts[s.charAt(j) - 'a']++;
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0)
                counts[s.charAt(i++) - 'a']--;
            result += i;
        }
        return result;
    }

    // Using min index - O(n) time, O(1) space
    public int numberOfSubstrings(String s) {
        int result = 0;
        int[] counts = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] = i;
            if (counts[0] < 0 || counts[1] < 0 || counts[2] < 0) {
                continue;
            }
            int minIndex = Math.min(counts[0], Math.min(counts[1], counts[2]));
            result += minIndex + 1;
        }
        return result;
    }

}
