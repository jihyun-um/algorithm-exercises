package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [Problem] https://leetcode.com/problems/meeting-scheduler
class MeetingScheduler {
    // Two pointers with sorting
    // O(mlogm + nlogn) time, O(1) space
    // where m = slots1.length, n = slots2.length
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]); // O(mlogm) time
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]); // O(nlogn) time
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int[] slot1 = slots1[i], slot2 = slots2[j];
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            if (end - start >= duration) {
                return List.of(start, start + duration);
            }
            if (slot1[1] < slot2[1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();
    }

    // Test
    public static void main(String[] args) {
        MeetingScheduler solution = new MeetingScheduler();

        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        List<Integer> expectedOutput = List.of(60, 68);
        List<Integer> actualOutput = solution.minAvailableDuration(slots1, slots2, duration);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
