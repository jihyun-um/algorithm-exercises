package solutions;

// [Problem] https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards
class MaximumPointsFromCards {
    // Sliding window
    // O(k) time, O(1) space
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length, left = n - k;
        for (int right = left; right < n; right++) {
            sum += cardPoints[right];
        }
        int maxSum = sum;
        for (int right = 0; right < k; right++) {
            sum -= cardPoints[left++];
            sum += cardPoints[right];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Test
    public static void main(String[] args) {
        MaximumPointsFromCards solution = new MaximumPointsFromCards();

        int[] input1 = {1, 2, 3, 4, 5, 6, 1};
        int expectedOutput1 = 12;
        int actualOutput1 = solution.maxScore(input1, 3);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[] input2 = {9, 7, 7, 9, 7, 7, 9};
        int expectedOutput2 = 55;
        int actualOutput2 = solution.maxScore(input2, 7);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
