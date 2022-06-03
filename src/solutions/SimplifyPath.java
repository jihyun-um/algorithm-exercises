package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/simplify-path
class SimplifyPath {
    // Stack (Deque)
    // O(n) time, O(n) space
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Deque<String> finalDirectories = new ArrayDeque<>();
        for (String directory : directories) {
            if ("..".equals(directory)) {
                if (!finalDirectories.isEmpty()) {
                    finalDirectories.pop();
                }
            } else if (!".".equals(directory) && !"".equals(directory)) {
                finalDirectories.push(directory);
            }
        }
        StringBuilder simplifiedPath = new StringBuilder();
        if (finalDirectories.isEmpty()) {
            simplifiedPath.append("/");
        } else {
            while (!finalDirectories.isEmpty()) {
                simplifiedPath.append("/").append(finalDirectories.removeLast());
            }
        }
        return simplifiedPath.toString();
    }

    // Test
    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();

        String input1 = "/../";
        String expectedOutput1 = "/";
        String actualOutput1 = solution.simplifyPath(input1);
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        String input2 = "/home//foo/";
        String expectedOutput2 = "/home/foo";
        String actualOutput2 = solution.simplifyPath(input2);
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
