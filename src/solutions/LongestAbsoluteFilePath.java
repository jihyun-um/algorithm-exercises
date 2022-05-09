package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// [Problem] https://leetcode.com/problems/longest-absolute-file-path
class LongestAbsoluteFilePath {
    // HashMap
    // O(n) time, O(n) space
    public int lengthLongestPathMap(String input) {
        String[] items = input.split("\n");
        if (items.length == 0) {
            return 0;
        }
        Map<Integer, String> paths = new HashMap<>();
        int maxPathLength = 0;
        for (String item : items) {
            int currentLevel = item.lastIndexOf("\t") + 1;
            String currentItem = item.substring(currentLevel);
            String currentPath = currentLevel == 0 ? currentItem : paths.get(currentLevel - 1) + "/" + currentItem;
            paths.put(currentLevel, currentPath);
            if (isFile(currentItem)) {
                maxPathLength = Math.max(currentPath.length(), maxPathLength);
            }
        }
        return maxPathLength;
    }

    // Stack
    // O(n) time, O(n) space
    public int lengthLongestPath(String input) {
        String[] items = input.split("\n");
        if (items.length == 0) {
            return 0;
        }
        Stack<Integer> pathLengths = new Stack<>();
        int maxPathLength = 0;
        for (String item : items) {
            int currentLevel = item.lastIndexOf("\t") + 1;
            while (pathLengths.size() > currentLevel) {
                pathLengths.pop();
            }
            int currentItemLength = item.length() - currentLevel;
            int currentPathLength = currentLevel == 0 ? currentItemLength : pathLengths.peek() + currentItemLength + 1;
            pathLengths.push(currentPathLength);
            if (isFile(item)) {
                maxPathLength = Math.max(currentPathLength, maxPathLength);
            }
        }
        return maxPathLength;
    }

    private boolean isFile(String input) {
        return input.contains(".");
    }

    // Test
    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();

        String input1 = "dir" +
                "\n\tsubdir1" +
                "\n\tsubdir2" +
                "\n\t\tfile.ext";
        int expectedOutput1 = 20;
        int actualOutput1 = solution.lengthLongestPath(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        String input2 = "dir" +
                "\n\tsubdir1" +
                "\n\t\tfile1.ext" +
                "\n\t\tsubsubdir1" +
                "\n\tsubdir2" +
                "\n\t\tsubsubdir2" +
                "\n\t\t\tfile2.ext";
        int expectedOutput2 = 32;
        int actualOutput2 = solution.lengthLongestPath(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
