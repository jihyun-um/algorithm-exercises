package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/minimum-window-substring/
class MinimumWindowSubstring {

    // test
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String s = "ADOBECODEBANC", t = "ABC";
        String expectedOutput = "BANC";
        String actualOutput = solution.minWindow(s, t);

        System.out.println("actualOutput: " + actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));

    }

    // Sliding window - O(s + t) time, O(s + t) space
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> requiredLetters = new HashMap<>();
        for (char letter : t.toCharArray()) {
            requiredLetters.put(letter, requiredLetters.getOrDefault(letter, 0) + 1);
        }

        Map<Character, Integer> currentWindowLetters = new HashMap<>();
        int left = 0, right = 0, letterCount = 0;
        int minLeft = 0, minRight = 0, minWindowLength = -1;
        while (right < s.length()) {
            char letter = s.charAt(right);
            int count = currentWindowLetters.getOrDefault(letter, 0);
            currentWindowLetters.put(letter, count + 1);

            if (requiredLetters.containsKey(letter) && currentWindowLetters.get(letter).equals(requiredLetters.get(letter))) {
                letterCount++;
            }

            while (left <= right && letterCount == requiredLetters.size()) {
                letter = s.charAt(left);

                // Save the smallest window until now.
                if (minWindowLength == -1 || right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                // The character at the left pointer is no longer a part of the window.
                currentWindowLetters.put(letter, currentWindowLetters.get(letter) - 1);
                if (requiredLetters.containsKey(letter) && currentWindowLetters.get(letter) < requiredLetters.get(letter)) {
                    letterCount--;
                }

                left++;
            }
            right++;
        }

        return minWindowLength == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

}
