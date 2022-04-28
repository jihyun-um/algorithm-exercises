package javacode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// [Problem] https://leetcode.com/problems/all-paths-from-source-to-target
class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        findPath(0, path, allPaths, graph);
        return allPaths;
    }

    private void findPath(int currentPoint, List<Integer> path, List<List<Integer>> allPaths, int[][] graph) {
        path = new ArrayList<>(path);
        path.add(currentPoint);
        if (currentPoint == graph.length - 1) {
            allPaths.add(path);
            return;
        }
        int[] nextPoints = graph[currentPoint];
        for (int nextPoint: nextPoints) {
            findPath(nextPoint, path, allPaths, graph);
        }
    }

    // Test
    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();

        int[][] input = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> expectedOutput = List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4));
        List<List<Integer>> actualOutput = solution.allPathsSourceTarget(input);

        System.out.println(actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
