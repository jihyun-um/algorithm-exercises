package com.jihyunum.leetcode;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/product-of-array-except-self/
class ProductOfArrayExceptSelf {

    // test
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        int[] input = {1, 2, 3, 4};
        int[] expectedOutput = {24, 12, 8, 6};
        int[] actualOutput = solution.productExceptSelf(input);

        System.out.println("Test passed? " + Arrays.equals(expectedOutput, actualOutput));
    }

    // O(n) time, O(n) space
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] products = new int[length];

        int left = 1;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            products[i] = left;
        }

        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                right = right * nums[i + 1];
            }
            products[i] *= right;
        }
        return products;
    }

}
