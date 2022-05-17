package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/longest-substring-without-repeating-characters
class LongestSubstringWithoutRepeatingCharacters {
    // Sliding window with HashMap
    // O(n) time, O(n) space
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> occurrences = new HashMap<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer occurrence = occurrences.get(c);
            if (occurrence != null && occurrence >= left) {
                left = occurrence + 1;
            }
            occurrences.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Test
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        String input1 = "abcabcbb";
        int expectedOutput1 = 3;
        int actualOutput1 = solution.lengthOfLongestSubstring(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String input2 = "bbbbb";
        int expectedOutput2 = 1;
        int actualOutput2 = solution.lengthOfLongestSubstring(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
