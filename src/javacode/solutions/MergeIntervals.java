package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/merge-intervals
class MergeIntervals {
    // Array sorting
    // O(nlogn) time, O(logn) space for sorting
    public int[][] mergeArr(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    // Individual sorting
    // O(nlogn) time, O(n) space
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> merged = new ArrayList<>();
        for (int startIndex = 0, endIndex = 0; endIndex < n; endIndex++) {
            if (endIndex == n - 1 || starts[endIndex + 1] > ends[endIndex]) {
                merged.add(new int[]{starts[startIndex], ends[endIndex]});
                startIndex = endIndex + 1;
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    // Test
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expectedOutput = {{1, 6}, {8, 10}, {15, 18}};
        int[][] actualOutput = solution.merge(intervals);

        System.out.println("Test passed? " + Arrays.deepEquals(expectedOutput, actualOutput));
    }
}
