package javacode.solutions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// [Problem] https://leetcode.com/problems/valid-parentheses/
class ValidParentheses {

    // test
    public static void main(String[] args) {

        String validString = "()[]{}";
        String invalidString = "([)]";

        System.out.println("Test passed? " + (isValid(validString) == true));
        System.out.println("Test passed? " + (isValid(invalidString) == false));

    }

    // O(N) Stack solution
    private static boolean isValid(String s) {
        Map<Character, Character> matchingPairs = new HashMap<>();
        matchingPairs.put(')', '(');
        matchingPairs.put(']', '[');
        matchingPairs.put('}', '{');

        Collection<Character> openingBrackets = matchingPairs.values();
        Collection<Character> closingBrackets = matchingPairs.keySet();

        Stack<Character> bracketStack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (openingBrackets.contains(bracket)) {
                bracketStack.push(bracket);
            }
            if (closingBrackets.contains(bracket)) {
                if (bracketStack.isEmpty()) {
                    return false;
                } else if (bracketStack.lastElement() == matchingPairs.get(bracket)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }

}
