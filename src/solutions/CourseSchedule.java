package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/course-schedule
class CourseSchedule {
    // Topological sort
    // O(v + e) time, O(v + e) space
    // where v = number of courses, e = number of prerequisites
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nextCourseMap = new HashMap<>();
        int[] numPrerequisites = new int[numCourses];
        for (int[] courseToPrerequisite : prerequisites) {
            int course = courseToPrerequisite[0];
            int prerequisite = courseToPrerequisite[1];
            nextCourseMap.putIfAbsent(prerequisite, new ArrayList<>());
            nextCourseMap.get(prerequisite).add(course);
            numPrerequisites[course]++;
        }
        Queue<Integer> coursesToTake = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPrerequisites[i] == 0) {
                coursesToTake.add(i);
            }
        }
        int count = 0;
        while (!coursesToTake.isEmpty()) {
            int currentCourse = coursesToTake.poll();
            List<Integer> nextCourses = nextCourseMap.get(currentCourse);
            if (nextCourses != null) {
                for (int nextCourse : nextCourses) {
                    if (--numPrerequisites[nextCourse] == 0) {
                        coursesToTake.add(nextCourse);
                    }
                }
            }
            count++;
        }
        return count == numCourses;
    }

    // Test
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        boolean expectedOutput1 = true;
        boolean actualOutput1 = solution.canFinish(numCourses1, prerequisites1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int numCourses2 = 3;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        boolean expectedOutput2 = false;
        boolean actualOutput2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}