package solutions;

// [Problem] https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter
class SubstringsWithSameLetter {
    // Prefix sum
    // O(n) time, O(1) space
    public long numberOfSubstrings(String s) {
        int[] letterCounts = new int[26];
        long substringCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int letterCount = ++letterCounts[c - 'a'];
            substringCount += letterCount;
        }
        return substringCount;
    }

    // Test
    public static void main(String[] args) {
        SubstringsWithSameLetter solution = new SubstringsWithSameLetter();

        String input1 = "abcba";
        long expectedOutput1 = 7;
        long actualOutput1 = solution.numberOfSubstrings(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String input2 = "abacad";
        long expectedOutput2 = 9;
        long actualOutput2 = solution.numberOfSubstrings(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
