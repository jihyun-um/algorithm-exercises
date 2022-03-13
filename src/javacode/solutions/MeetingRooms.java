package javacode.solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/meeting-rooms
class MeetingRooms {
    // Array sorting
    // O(nlogn) time, O(1) space
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    // Individual sorting
    // O(nlogn) time, O(1) space
    public boolean canAttendMeetingsIndividualSorting(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n], endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        for (int i = 1; i < n; i++) {
            if (startTimes[i] < endTimes[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        int[][] input1 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        boolean expectedOutput1 = false;
        boolean actualOutput1 = solution.canAttendMeetings(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[][] input2 = new int[][]{{7, 10}, {2, 4}};
        boolean expectedOutput2 = true;
        boolean actualOutput2 = solution.canAttendMeetings(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
