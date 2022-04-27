package javacode.solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/employee-free-time
class EmployeeFreeTime {
    // Min heap
    // O(nlogn) time, O(n) space
    // where n = total number of meetings in schedule
    public List<Interval> employeeFreeTimeHeap(List<List<Interval>> schedule) {
        Queue<Interval> employeeBusyTime = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(meetings -> employeeBusyTime.addAll(meetings));

        List<Interval> availabilities = new ArrayList<>();
        int startTime = employeeBusyTime.poll().end;
        while (!employeeBusyTime.isEmpty()) {
            Interval meeting = employeeBusyTime.poll();
            if (meeting.start > startTime) {
                availabilities.add(new Interval(startTime, meeting.start));
            }
            startTime = Math.max(startTime, meeting.end);
        }
        return availabilities;
    }

    // Array sorting
    // O(nlogn) time, O(n) space
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> employeeBusyTime = new ArrayList<>();
        schedule.forEach(meetings -> employeeBusyTime.addAll(meetings));
        employeeBusyTime.sort((a, b) -> a.start - b.start);

        List<Interval> availabilities = new ArrayList<>();
        int startTime = employeeBusyTime.get(0).end;
        for (Interval meeting : employeeBusyTime) {
            if (meeting.start > startTime) {
                availabilities.add(new Interval(startTime, meeting.start));
            }
            startTime = Math.max(startTime, meeting.end);
        }
        return availabilities;
    }

    // Test
    public static void main(String[] args) {
        EmployeeFreeTime solution = new EmployeeFreeTime();

        List<List<Interval>> input = List.of(
                List.of(new Interval(1, 2), new Interval(5, 6)),
                List.of(new Interval(1, 3)),
                List.of(new Interval(4, 10))
        );
        List<Interval> actualOutput = solution.employeeFreeTime(input);

        System.out.println("Actual output? " + actualOutput); // expectedOutput: [[3,4]]
    }
}

class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +  start + ", " + end + '}';
    }
}
