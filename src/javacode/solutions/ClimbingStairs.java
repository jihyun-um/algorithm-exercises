package javacode.solutions;

// [Problem] https://leetcode.com/problems/climbing-stairs/
class ClimbingStairs {

    // test
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        int input = 3;
        int expectedOutput = 3;
        int actualOutput = solution.climbStairs(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Recursion with memoization - O(n) time, O(n) space
    private int[] memo;

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        return climbStairsRecursion(n);
    }

    private int climbStairsRecursion(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
        return memo[n];
    }

    // Bottom up with memoization - O(n) time, O(n) space
    public int climbStairsBottomUp(int n) {
        if (n <= 1) {
            return n;
        }
        memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n];
    }
}