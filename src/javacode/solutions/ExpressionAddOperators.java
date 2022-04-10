package javacode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// [Problem] https://leetcode.com/problems/expression-add-operators
class ExpressionAddOperators {
    String num;
    int target;
    List<String> combinations;

    // Backtracking
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        this.combinations = new ArrayList<>();
        backtrack(0, 0, 0, "");
        return combinations;
    }

    private void backtrack(int startIndex, long prevNum, long currentVal, String combination) {
        if (startIndex == num.length()) {
            if (currentVal == target) {
                combinations.add(combination);
            }
            return;
        }
        for (int endIndex = startIndex; endIndex < num.length(); endIndex++) {
            if (endIndex != startIndex && num.charAt(startIndex) == '0') {
                break;
            }
            long currentNum = Long.parseLong(num.substring(startIndex, endIndex + 1));
            if (startIndex == 0) {
                backtrack(endIndex + 1, currentNum, currentNum, String.valueOf(currentNum));
            } else {
                backtrack(endIndex + 1, currentNum, currentVal + currentNum, combination + "+" + currentNum);
                backtrack(endIndex + 1, -currentNum, currentVal - currentNum, combination + "-" + currentNum);
                backtrack(endIndex + 1, prevNum * currentNum, currentVal - prevNum + prevNum * currentNum, combination + "*" + currentNum);
            }
        }
    }

    // Test
    public static void main(String[] args) {
        ExpressionAddOperators solution = new ExpressionAddOperators();

        // order doesn't matter
        Set<String> expectedOutput1 = Set.of("1*2*3", "1+2+3");
        Set<String> actualOutput1 = new HashSet<>(solution.addOperators("123", 6));
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        Set<String> expectedOutput2 = Set.of("2*3+2", "2+3*2");
        Set<String> actualOutput2 = new HashSet<>(solution.addOperators("232", 8));
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
