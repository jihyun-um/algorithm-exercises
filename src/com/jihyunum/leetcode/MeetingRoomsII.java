package com.jihyunum.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/meeting-rooms-ii/
class MeetingRoomsII {

    // test
    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();

        int[][] input = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        int expectedOutput = 4;
        int actualOutput = solution.minMeetingRooms(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Using min heap - O(NlogN) time, O(N) space
    public int minMeetingRoomsMinHeap(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Queue<int[]> meetingTimes = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        meetingTimes.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] targetTime = intervals[i];
            if (targetTime[0] >= meetingTimes.peek()[1]) {
                meetingTimes.poll();
            }
            meetingTimes.add(targetTime);
        }

        return meetingTimes.size();
    }

    // Using double arrays - O(NlogN) time, O(N) space
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }

        int[] startTimes = new int[n], endTimes = new int[n];
        for (int i = 0; i < n; i ++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int meetingRoomCnt = 0, endTimeIndex = 0;
        for (int startTime : startTimes) {
            if (endTimes[endTimeIndex] > startTime) {
                meetingRoomCnt++;
            } else {
                endTimeIndex++;
            }
        }

        return meetingRoomCnt;
    }
}
