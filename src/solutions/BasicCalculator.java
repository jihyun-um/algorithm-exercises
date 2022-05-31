package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/basic-calculator
class BasicCalculator {
    // Stack
    // O(n) time, O(n) space
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, num = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = c == '-' ? -1 : 1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                sign = 1;
                num = 0;
            }
        }
        return result + sign * num;
    }

    // Test
    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();

        String input1 = " 2-1 + 2 ";
        int expectedOutput1 = 3;
        int actualOutput1 = solution.calculate(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String input2 = "(1+(4+5+2)-3)+(6+8)";
        int expectedOutput2 = 23;
        int actualOutput2 = solution.calculate(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}