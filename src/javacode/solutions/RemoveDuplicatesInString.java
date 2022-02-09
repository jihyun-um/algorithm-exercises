package javacode.solutions;

// [Problem] https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
class RemoveDuplicatesInString {
    // StringBuilder as Stack
    // O(n) time, O(n) space
    public String removeDuplicates(String input) {
        StringBuilder deduplicatedString = new StringBuilder();
        for (char letter : input.toCharArray()) {
            int strLength = deduplicatedString.length();
            if (strLength > 0 && deduplicatedString.charAt(strLength - 1) == letter) {
                deduplicatedString.deleteCharAt(strLength - 1);
            } else {
                deduplicatedString.append(letter);
            }
        }
        return deduplicatedString.toString();
    }

    // Test
    public static void main(String[] args) {
        RemoveDuplicatesInString solution = new RemoveDuplicatesInString();

        String input = "abbaca";
        String expectedOutput = "ca";
        String actualOutput = solution.removeDuplicates(input);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
