package com.jihyunum.leetcode;

import java.util.*;

// [Problem] https://leetcode.com/problems/intersection-of-two-arrays-ii/
class IntersectionOfTwoArraysII {

    // test
    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] expectedOutput = {4, 9};
        int[] actualOutput = solution.intersect(nums1, nums2);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));

        // [Follow up] What if the given array is already sorted? How would you optimize your algorithm?
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] actualOutput2 = solution.intersectSorted(nums1, nums2);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput2));
    }

    // HashMap solution - O(n) time, O(n) space
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        Integer count;
        for (int num : nums2) {
            count = counts.get(num);
            if (count != null && count > 0) {
                intersection.add(num);
                counts.put(num, --count);
            }
        }

        int[] intersectionArr = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            intersectionArr[i] = intersection.get(i);
        }
        return intersectionArr;
    }

    // With sorted arrays
    // Two pointers solution - O(n) time, O(n) space
    public int[] intersectSorted(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        int num1, num2;
        while (i < nums1.length && j < nums2.length) {
            num1 = nums1[i];
            num2 = nums2[j];
            if (num1 == num2) {
                intersection.add(num1);
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }

        int[] intersectionArr = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            intersectionArr[k] = intersection.get(k);
        }
        return intersectionArr;
    }

}
