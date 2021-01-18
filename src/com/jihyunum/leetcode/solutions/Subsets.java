package com.jihyunum.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/subsets/
class Subsets {

    // test
    public static void main(String[] args) {
        Subsets solution = new Subsets();

        int[] input = {1, 2, 3};
        List<List<Integer>> output = solution.subsets(input);

        System.out.println(output);
        // expected output =
        // [
        //  [3],
        //  [1],
        //  [2],
        //  [1,2,3],
        //  [1,3],
        //  [2,3],
        //  [1,2],
        //  []
        // ]

    }

    // Cascading solution - O(n * 2^n) time, O(n * 2^n) space
    public List<List<Integer>> subsetsCascading(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                newSubsets.add(new ArrayList<>(subset) {{
                    add(num);
                }});
            }
            subsets.addAll(newSubsets);
        }

        return subsets;
    }

    // Bit manipulation solution - O(n * 2^n) time, O(n * 2^n) space
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') subset.add(nums[j]);
            }
            subsets.add(subset);
        }

        return subsets;
    }

}
