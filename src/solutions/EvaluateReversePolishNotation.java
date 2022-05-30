package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/evaluate-reverse-polish-notation
class EvaluateReversePolishNotation {
    private final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    // Stack
    // O(n) time, O(n) space
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculate(num1, num2, token);
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        if ("+".equals(operator)) {
            return num1 + num2;
        } else if ("-".equals(operator)) {
            return num1 - num2;
        } else if ("*".equals(operator)) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    // Test
    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        String[] input1 = {"2", "1", "+", "3", "*"};
        int expectedOutput1 = 9;
        int actualOutput1 = solution.evalRPN(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String[] input2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expectedOutput2 = 22;
        int actualOutput2 = solution.evalRPN(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
