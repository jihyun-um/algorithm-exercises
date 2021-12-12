package javacode.solutions;

// [Problem] https://leetcode.com/problems/jewels-and-stones
class JewelsAndStones {
    // O(n) time, O(1) space
    public int numJewelsInStones(String jewels, String stones) {
        int[] jewelCounts = new int[58];
        int totalCount = 0;
        for (char jewel : jewels.toCharArray()) {
            jewelCounts[jewel - 'A'] = 1;
        }
        for (char stone : stones.toCharArray()) {
            totalCount += jewelCounts[stone - 'A'];
        }
        return totalCount;
    }

    // test
    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();

        String jewels = "a", stones = "aAAbbbb";
        int expectedOutput = 3;
        int actualOutput = solution.numJewelsInStones(jewels, stones);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}