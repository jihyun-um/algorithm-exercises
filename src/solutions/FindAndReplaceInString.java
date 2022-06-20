package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/find-and-replace-in-string
class FindAndReplaceInString {
    // String and sorting
    // O(nlogn) time, O(n) space
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indexMap.put(indices[i], i);
        }
        Arrays.sort(indices);
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        for (int currentIndex : indices) {
            int i = indexMap.get(currentIndex);
            String source = sources[i];
            int nextIndex = currentIndex + source.length();
            if (source.equals(s.substring(currentIndex, nextIndex))) {
                result.append(s.substring(pointer, currentIndex));
                result.append(targets[i]);
                pointer = nextIndex;
            }
        }
        result.append(s.substring(pointer));
        return result.toString();
    }

    // Test
    public static void main(String[] args) {
        FindAndReplaceInString solution = new FindAndReplaceInString();

        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        String expectedOutput = "eeebffff";
        String actualOutput = solution.findReplaceString(s, indices, sources, targets);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
