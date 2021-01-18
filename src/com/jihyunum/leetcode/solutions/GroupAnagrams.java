package com.jihyunum.leetcode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/group-anagrams/
class GroupAnagrams {

    // test
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = List.of(
                List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );

        List<List<String>> actualOutput = solution.groupAnagrams(input);

        // compare outputs (order doesn't matter)
        System.out.println("expectedOutput: " + expectedOutput);
        System.out.println("actualOutput: " + actualOutput);
    }

    // O(N * Klog(K)) time
    // N = number of elements in string list, 1 <= N <= 10^4
    // K = length of each string, 0 <= K <= 100
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String anagramKey = String.valueOf(strArr);

            if (!anagramGroups.containsKey(anagramKey)) {
                anagramGroups.put(anagramKey, new ArrayList<>());
            }
            anagramGroups.get(anagramKey).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
