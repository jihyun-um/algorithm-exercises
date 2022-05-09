package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/different-ways-to-add-parentheses
class DifferentWaysToAddParentheses {
    // Recursion
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> permutations = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftPermutations = diffWaysToCompute(left);
                List<Integer> rightPermutations = diffWaysToCompute(right);
                for (int leftPermutation : leftPermutations) {
                    for (int rightPermutation : rightPermutations) {
                        int permutation = compute(leftPermutation, rightPermutation, c);
                        permutations.add(permutation);
                    }
                }
            }
        }
        if (permutations.size() == 0) {
            permutations.add(Integer.valueOf(input));
        }
        return permutations;
    }

    private int compute(int num1, int num2, char operator) {
        if (operator == '*') {
            return num1 * num2;
        } else if (operator == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }

    // Test
    public static void main(String[] args) {
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();

        String input = "2*3-4*5";
        List<Integer> output = solution.diffWaysToCompute(input);

        // expected: [-34, -14, -10, -10, 10] in any order
        System.out.println("actualOutput " + output);
    }
}
