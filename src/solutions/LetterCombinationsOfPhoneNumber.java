package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/letter-combinations-of-a-phone-number
class LetterCombinationsOfPhoneNumber {
    Map<Character, char[]> letterMappings = Map.of(
            '2', new char[] {'a', 'b', 'c'},
            '3', new char[] {'d', 'e', 'f'},
            '4', new char[] {'g', 'h', 'i'},
            '5', new char[] {'j', 'k', 'l'},
            '6', new char[] {'m', 'n', 'o'},
            '7', new char[] {'p', 'q', 'r', 's'},
            '8', new char[] {'t', 'u', 'v'},
            '9', new char[] {'w', 'x', 'y', 'z'});

    // Backtracking
    // O(n * 4^n) time, O(n) space
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, "", digits, 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String combination, String digits, int index) {
        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }
        char[] letterMapping = letterMappings.get(digits.charAt(index));
        for (char letter : letterMapping) {
            backtrack(combinations, combination + letter, digits, index + 1);
        }
    }

    // Test
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();

        String input1 = "2"; // order doesn't matter
        Set<String> expectedOutput1 = Set.of("a", "b", "c");
        Set<String> actualOutput1 = new HashSet<>(solution.letterCombinations(input1));
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        String input2 = "23";
        Set<String> expectedOutput2 = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Set<String> actualOutput2 = new HashSet<>(solution.letterCombinations(input2));
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
