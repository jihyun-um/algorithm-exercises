package com.jihyunum.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [Problem] https://leetcode.com/problems/insert-interval/
class InsertInterval {

    // test
    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expectedOutput = {{1, 2}, {3, 10}, {12, 16}};
        int[][] actualOutput = solution.insert(intervals, newInterval);

        System.out.println("Test passed? " + Arrays.deepEquals(expectedOutput, actualOutput));
    }

    // O(n) time, O(n) space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> insertedIntervalList = new ArrayList<>();
        int i = 0, length = intervals.length;

        // add all the intervals ending before newInterval starts
        while (i < length && intervals[i][1] < newInterval[0]) {
            insertedIntervalList.add(intervals[i++]);
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        insertedIntervalList.add(newInterval);

        // add all the rest
        while (i < length) {
            insertedIntervalList.add(intervals[i++]);
        }

        int[][] insertedIntervals = new int[insertedIntervalList.size()][2];
        for (int k = 0; k < insertedIntervalList.size(); k++) {
            insertedIntervals[k] = insertedIntervalList.get(k);
        }

        return insertedIntervals;
    }

}
