package solutions;

// [Problem] https://leetcode.com/problems/n-th-tribonacci-number/
class NthTribonacciNumber {

    // test
    public static void main(String[] args) {
        NthTribonacciNumber solution = new NthTribonacciNumber();

        int input = 25;
        int expectedOutput = 1389537;
        int actualOutput = solution.tribonacci(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // O(N) time, O(N) space (0 <= N <= 37)
    private int tribonacci(int n) {
        int[] tribonacciValues = new int[38];
        tribonacciValues[0] = 0;
        tribonacciValues[1] = 1;
        tribonacciValues[2] = 1;

        for (int i = 3; i <= n; i++) {
            tribonacciValues[i] = tribonacciValues[i - 3] + tribonacciValues[i - 2] + tribonacciValues[i - 1];
        }
        return tribonacciValues[n];
    }

}
