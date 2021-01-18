package com.jihyunum.leetcode.solutions;

import java.util.LinkedHashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/first-unique-character-in-a-string/
class FirstUniqueCharacter {

    // test
    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();

        String input = "loveleetcode";
        int expectedOutput = 2;
        int actualOutput = solution.firstUniqueChar(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // HashMap solution - O(n) time, O(n) space
    public int firstUniqueCharHashMap(String s) {
        Map<Character, Integer> charFrequencies = new LinkedHashMap<>();

        Integer charFrequency;
        for (char c : s.toCharArray()) {
            charFrequency = charFrequencies.get(c);
            charFrequencies.put(c, charFrequency == null ? 1 : charFrequency + 1);
        }

        for (char c : charFrequencies.keySet()) {
            if (charFrequencies.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    // Two pointers solution - O(n) time, O(n) space
    public int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] frequencies = new int[26];
        int slow = 0, fast = 0;

        while (fast < length) {
            frequencies[chars[fast++] - 'a']++;

            // if slow pointer is not on a unique character, increment slow pointer
            while (slow < length && frequencies[chars[slow] - 'a'] > 1) {
                slow++;
            }

            // if all chars are dupe, return -1
            if (slow == length) {
                return -1;
            }
        }
        return slow;
    }

}
