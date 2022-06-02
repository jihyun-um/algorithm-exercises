package solutions;

import java.util.Stack;

// [Problem] https://leetcode.com/problems/decode-string
class DecodeString {
    // Stack
    // O(n) time, O(n) space
    public String decodeString(String s) {
        int num = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(String.valueOf(num));
                stack.push("[");
                num = 0;
            } else if (c == ']') {
                String substring = "";
                while (!stack.empty() && !"[".equals(stack.peek())) {
                    substring = stack.pop() + substring;
                }
                stack.pop(); // pop '['
                int repeatCount = Integer.parseInt(stack.pop());
                String repeatedSubstring = substring.repeat(repeatCount);
                stack.add(repeatedSubstring);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        String result = "";
        while (!stack.empty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    // Test
    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        String input = "3[a2[c]]";
        String expectedOutput = "accaccacc";
        String actualOutput = solution.decodeString(input);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
