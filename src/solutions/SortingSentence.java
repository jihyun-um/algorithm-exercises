package solutions;

// [Problem] https://leetcode.com/problems/sorting-the-sentence
class SortingSentence {
    // O(n) time, O(n) space
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] sortedWords = new String[words.length];
        for (String word: words) {
            int orderIndex = word.length() - 1;
            int wordIndex = word.charAt(orderIndex) - '1';
            sortedWords[wordIndex] = word.substring(0, orderIndex);
        }
        return String.join(" ", sortedWords);
    }

    // test
    public static void main(String[] args) {
        SortingSentence solution = new SortingSentence();

        String input = "is2 sentence4 This1 a3";
        String expectedOutput = "This is a sentence";
        String actualOutput = solution.sortSentence(input);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
