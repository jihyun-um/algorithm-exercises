package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/group-anagrams
class GroupAnagrams {
    // Sorting
    // O(nklog(k)) time, O(n) space
    // n = number of strings, k = length of each string
    public List<List<String>> groupAnagramsSorting(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String anagramKey = String.valueOf(letters);
            if (!anagramGroups.containsKey(anagramKey)) {
                anagramGroups.put(anagramKey, new ArrayList<>());
            }
            anagramGroups.get(anagramKey).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    // Letter frequencies
    // O(nk) time, O(n) space
    // n = number of strings, k = length of each string
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            int[] letterFrequencies = new int[26];
            for (char letter : letters) {
                letterFrequencies[letter - 'a']++;
            }
            String anagramKey = Arrays.toString(letterFrequencies);
            if (!anagramGroups.containsKey(anagramKey)) {
                anagramGroups.put(anagramKey, new ArrayList<>());
            }
            anagramGroups.get(anagramKey).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    // Test
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expectedOutput = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );
        List<List<String>> actualOutput = solution.groupAnagrams(input);

        // compare outputs (order doesn't matter)
        System.out.println("expectedOutput: " + expectedOutput);
        System.out.println("actualOutput: " + actualOutput);
    }
}
