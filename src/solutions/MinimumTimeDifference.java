package solutions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// [Problem] https://leetcode.com/problems/minimum-time-difference
class MinimumTimeDifference {
    // Sorting
    // O(nlogn) time, O(n) space
    public int findMinDifference(List<String> timePoints) {
        List<Integer> numTimes = new ArrayList<>();
        for (String timePoint : timePoints) {
            int hour = Integer.parseInt(timePoint.substring(0, 2));
            int minute = Integer.parseInt(timePoint.substring(3));
            numTimes.add(60 * hour + minute);
        }
        Collections.sort(numTimes);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < numTimes.size(); i++) {
            int diff = numTimes.get(i) - numTimes.get(i - 1);
            minDiff = Math.min(diff, minDiff);
        }
        int cornerDiff = 1440 + numTimes.get(0) - numTimes.get(numTimes.size() - 1);
        return Math.min(cornerDiff, minDiff);
    }

    // Test
    public static void main(String[] args) {
        MinimumTimeDifference solution = new MinimumTimeDifference();

        List<String> input1 = List.of("23:59", "00:00");
        int expectedOutput1 = 1;
        int actualOutput1 = solution.findMinDifference(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        List<String> input2 = List.of("00:00", "23:59", "00:00");
        int expectedOutput2 = 0;
        int actualOutput2 = solution.findMinDifference(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
