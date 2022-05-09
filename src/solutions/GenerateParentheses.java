package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// [Problem] https://leetcode.com/problems/generate-parentheses
class GenerateParentheses {
    // Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        backtrack(parentheses, "", 0, 0, n);
        return parentheses;
    }

    public void backtrack(List<String> parentheses, String current, int open, int close, int n) {
        if (open == n && close == n) {
            parentheses.add(current);
            return;
        }
        if (open < n) {
            backtrack(parentheses, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(parentheses, current + ")", open, close + 1, n);
        }
    }

    // Test
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();

        int input1 = 3; // order doesn't matter
        Set<String> expectedOutput1 = Set.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Set<String> actualOutput1 = new HashSet<>(solution.generateParenthesis(input1));
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        int input2 = 4;
        Set<String> expectedOutput2 = Set.of(
                "(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
                "(()()())", "(()())()", "(())(())", "(())()()", "()((()))",
                "()(()())", "()(())()", "()()(())", "()()()()");
        Set<String> actualOutput2 = new HashSet<>(solution.generateParenthesis(input2));
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
