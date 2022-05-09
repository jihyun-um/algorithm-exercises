package solutions;

// [Problem] https://leetcode.com/problems/reverse-words-in-a-string-iii
class ReverseWordsInStringIII {
    // O(n) time, O(n) space
    public String reverseWords(String s) {
        StringBuilder output = new StringBuilder();
        String[] words = s.split(" ");
        for (String word: words) {
            char[] lettersInWord = word.toCharArray();
            for (int i = lettersInWord.length - 1; i >= 0; i--) {
                output.append(lettersInWord[i]);
            }
            output.append(" ");
        }
        return output.toString().trim();
    }

    // test
    public static void main(String[] args) {
        ReverseWordsInStringIII solution = new ReverseWordsInStringIII();

        String input = "Let's take LeetCode contest";
        String expectedOutput = "s'teL ekat edoCteeL tsetnoc";
        String actualOutput = solution.reverseWords(input);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
