package solutions;

import java.util.List;

// [Problem] https://leetcode.com/problems/longest-word-in-dictionary-through-deleting
class LongestWordInDictionaryThroughDeleting {
    // Two pointers
    // O(n * l) time, O(1) space
    // where n = number of words in dictionary, l = string length
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String word : dictionary) {
            if (isValid(s, word) && isLonger(word, longestWord)) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private boolean isValid(String s, String word) {
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (wordIndex == word.length()) {
                return true;
            } else if (s.charAt(i) == word.charAt(wordIndex)) {
                wordIndex++;
            }
        }
        return wordIndex == word.length();
    }

    private boolean isLonger(String word1, String word2) {
        return word1.length() > word2.length() || (word1.length() == word2.length() && word1.compareTo(word2) < 0);
    }

    // Test
    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting solution = new LongestWordInDictionaryThroughDeleting();

        String s = "abpcplea";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");
        String expectedOutput = "apple";
        String actualOutput = solution.findLongestWord(s, dictionary);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
