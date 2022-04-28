package javacode.solutions;

// [Problem] https://leetcode.com/problems/count-sorted-vowel-strings
class CountSortedVowelStrings {
    // Dynamic programming
    // O(n) time, O(1) space
    public int countVowelStrings(int n) {
        int aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;

        int numLetters = 2;
        while (numLetters <= n) {
            aCount = aCount + eCount + iCount + oCount + uCount;
            eCount = eCount + iCount + oCount + uCount;
            iCount = iCount + oCount + uCount;
            oCount = oCount + uCount;
            // uCount is always 1
            numLetters++;
        }
        return (aCount + eCount + iCount + oCount + uCount);
    }

    // Test
    public static void main(String[] args) {
        CountSortedVowelStrings solution = new CountSortedVowelStrings();

        int input = 3;
        int expectedOutput = 35;
        int actualOutput = solution.countVowelStrings(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
