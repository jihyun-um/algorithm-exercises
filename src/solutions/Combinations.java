package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/combinations
class Combinations {
    // Backtracking
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new LinkedList<>(), k, 1, n);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, LinkedList<Integer> combination, int len, int next, int max) {
        if (combination.size() == len) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        for (int num = next; num <= max; num++) {
            combination.add(num);
            backtrack(combinations, combination, len, num + 1, max);
            combination.removeLast();
        }
    }

    // Test
    public static void main(String[] args) {
        Combinations solution = new Combinations();

        // order doesn't matter
        Set<List<Integer>> expectedOutput = Set.of(
                List.of(2, 4), List.of(3, 4), List.of(2, 3),
                List.of(1, 2), List.of(1, 3), List.of(1, 4));
        Set<List<Integer>> actualOutput = new HashSet<>(solution.combine(4, 2));

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
