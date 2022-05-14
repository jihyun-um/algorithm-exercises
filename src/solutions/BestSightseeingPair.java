package solutions;

// [Problem] https://leetcode.com/problems/best-sightseeing-pair
class BestSightseeingPair {
    // Bottom-up DP
    // O(n) time, O(1) space
    public int maxScoreSightseeingPair(int[] values) {
        int maxPair = values[0];
        int maxScore = 0;
        for (int i = 1; i < values.length; i++) {
            maxScore = Math.max(maxScore, values[i] + maxPair - 1);
            maxPair = Math.max(maxPair - 1, values[i]);
        }
        return maxScore;
    }

    // Test
    public static void main(String[] args) {
        BestSightseeingPair solution = new BestSightseeingPair();

        int[] input = {8, 1, 5, 2, 6};
        int expectedOutput = 11;
        int actualOutput = solution.maxScoreSightseeingPair(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
