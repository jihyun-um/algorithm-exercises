package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/permutations
class Permutations {
    // Backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new LinkedList<>(), nums);
        return permutations;
    }

    private void backtrack(List<List<Integer>> permutations, LinkedList<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new LinkedList<>(permutation));
        } else {
            for (int num : nums) {
                if (permutation.contains(num)) {
                    continue;
                }
                permutation.add(num);
                backtrack(permutations, permutation, nums);
                permutation.removeLast();
            }
        }
    }

    // Test
    public static void main(String[] args) {
        Permutations solution = new Permutations();

        int[] input = {1, 2, 3};
        // order doesn't matter
        Set<List<Integer>> expectedOutput = Set.of(
                List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        Set<List<Integer>> actualOutput = new HashSet<>(solution.permute(input));

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
