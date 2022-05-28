package solutions;

// [Problem] https://leetcode.com/problems/expressive-words
class ExpressiveWords {
    // Two pointers
    // O(n * l) time, O(1) space
    // where n = number of words, l = string length
    public int expressiveWords(String s, String[] words) {
        int expressiveWordsCount = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                expressiveWordsCount++;
            }
        }
        return expressiveWordsCount;
    }

    private boolean isStretchy(String s, String word) {
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (wordIndex < word.length() && s.charAt(i) == word.charAt(wordIndex)) {
                wordIndex++;
            } else if (i > 0 && i < s.length() - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            } else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                continue;
            } else {
                return false;
            }
        }
        return wordIndex == word.length();
    }

    // Test
    public static void main(String[] args) {
        ExpressiveWords solution = new ExpressiveWords();

        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        int expectedOutput = 1;
        int actualOutput = solution.expressiveWords(s, words);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
