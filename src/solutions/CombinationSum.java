package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/combination-sum
class CombinationSum {
    // Backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new LinkedList<>(), target, 0, candidates);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, LinkedList<Integer> currentCombination, int remain, int start, int[] candidates) {
        if (remain == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(combinations, currentCombination, remain - candidates[i], i, candidates);
            currentCombination.removeLast();
        }
    }

    // Test
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        // order doesn't matter
        Set<List<Integer>> expectedOutput1 = Set.of(List.of(2, 2, 3), List.of(7));
        Set<List<Integer>> actualOutput1 = new HashSet<>(solution.combinationSum(candidates1, target1));
        System.out.println("Test 1 passed? " + actualOutput1);
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        Set<List<Integer>> expectedOutput2 = Set.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
        Set<List<Integer>> actualOutput2 = new HashSet<>(solution.combinationSum(candidates2, target2));
        System.out.println("Test 2 passed? " + actualOutput2);
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
