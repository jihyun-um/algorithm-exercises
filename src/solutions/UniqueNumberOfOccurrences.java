package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/unique-number-of-occurrences
class UniqueNumberOfOccurrences {
    // HashTable & Set
    // O(n) time, O(n) space
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : arr) {
            int occurrence = occurrences.getOrDefault(num, 0);
            occurrences.put(num, occurrence + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>(occurrences.values());
        return uniqueOccurrences.size() == occurrences.size();
    }

    // Test
    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();

        int[] input1 = {1, 2, 2, 1, 1, 3};
        boolean output1 = solution.uniqueOccurrences(input1);
        System.out.println("Test 1 passed? " + (output1 == true));

        int[] input2 = {1, 2};
        boolean output2 = solution.uniqueOccurrences(input2);
        System.out.println("Test 2 passed? " + (output2 == false));
    }
}
