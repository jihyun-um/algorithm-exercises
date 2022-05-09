package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/meeting-rooms-ii/
class MeetingRoomsII {
    // Min heap
    // O(nlogn) time, O(n) space
    public int minMeetingRoomsMinHeap(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        Queue<int[]> meetings = new PriorityQueue<>(Comparator.comparingInt(meeting -> meeting[1]));
        for (int[] interval : intervals) {
            if (!meetings.isEmpty() && meetings.peek()[1] <= interval[0]) {
                meetings.poll();
            }
            meetings.add(interval);
        }
        return meetings.size();
    }

    // Using double arrays
    // O(nlogn) time, O(n) space
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
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

    // Test
    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();

        int[][] input = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        int expectedOutput = 4;
        int actualOutput = solution.minMeetingRooms(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
