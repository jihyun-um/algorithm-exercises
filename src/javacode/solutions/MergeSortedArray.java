package javacode.solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/merge-sorted-array
class MergeSortedArray {
    // Two pointers from the beginning
    // O(m + n) time, O(m) space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int p1 = 0, p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p1 >= m || (p2 < n && nums1Copy[p1] > nums2[p2])) {
                nums1[i] = nums2[p2++];
            } else {
                nums1[i] = nums1Copy[p1++];
            }
        }
    }

    // Two pointers from the end
    // O(m + n) time, O(1) space
    public void mergeFromEnd(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
    }

    // Test
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] expectedOutput = {1, 2, 2, 3, 5, 6};
        solution.merge(nums1, m, nums2, n);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, nums1));
    }
}