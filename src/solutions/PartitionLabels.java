package solutions;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/partition-labels
class PartitionLabels {
    // Two pointers
    // O(n) time, O(1) space
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitionLengths = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            if (i == end) {
                partitionLengths.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitionLengths;
    }

    // Test
    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();

        String input = "ababcbacadefegdehijhklij";
        List<Integer> expectedOutput = List.of(9, 7, 8);
        List<Integer> actualOutput = solution.partitionLabels(input);

        System.out.println(actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
