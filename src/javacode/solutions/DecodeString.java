package javacode.solutions;

import java.util.Stack;

// [Problem] https://leetcode.com/problems/decode-string
class DecodeString {
    // Stack
    // O(n) time, O(n) space
    public String decodeString(String s) {
        Stack<Integer> repeatCounts = new Stack<>();
        Stack<String> storedStrings = new Stack<>();
        storedStrings.push("");

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int start = i;
                while (Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                repeatCounts.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                storedStrings.push("");
            } else if (ch == ']') {
                String repeatStr = storedStrings.pop();
                int repeatCount = repeatCounts.pop();
                storedStrings.push(storedStrings.pop() + repeatStr.repeat(repeatCount));
            } else {
                storedStrings.push(storedStrings.pop() + ch);
            }
            i++;
        }
        return storedStrings.pop();
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
