package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/course-schedule-ii
class CourseScheduleII {
    // Topological sort
    // O(v + e) time, O(v + e) space
    // where v = number of courses, e = number of prerequisites
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] order = new int[numCourses];
        int orderIndex = 0;
        while (!coursesToTake.isEmpty() && orderIndex < numCourses) {
            int currentCourse = coursesToTake.poll();
            order[orderIndex++] = currentCourse;
            List<Integer> nextCourses = nextCourseMap.get(currentCourse);
            if (nextCourses != null) {
                for (int nextCourse : nextCourses) {
                    if (--numPrerequisites[nextCourse] == 0) {
                        coursesToTake.add(nextCourse);
                    }
                }
            }
        }
        return orderIndex == numCourses ? order : new int[0];
    }

    // Test
    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[] expectedOutput1 = {0, 1};
        int[] actualOutput1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.println("Test 1 passed? " + Arrays.equals(expectedOutput1, actualOutput1));

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] expectedOutput2 = {0, 1, 2, 3};
        int[] actualOutput2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.println("Test 2 passed? " + Arrays.equals(expectedOutput2, actualOutput2));
    }
}