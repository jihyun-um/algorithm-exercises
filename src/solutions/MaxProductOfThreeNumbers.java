package solutions;

// [Problem] https://leetcode.com/problems/maximum-product-of-three-numbers/
class MaxProductOfThreeNumbers {

    // test
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4};
        int expectedOutput = 24;
        int actualOutput = maximumProduct(nums);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));

    }

    // O(N) Single scan solution
    private static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num >= max1) { // num >= max1 >= max2 >= max3
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) { // max1 > num >= max2 >= max3
                max3 = max2;
                max2 = num;
            } else if (num > max3) { // max1 >= max2 >= num > max3
                max3 = num;
            }

            if (num <= min1) { // num <= min1 <= min2
                min2 = min1;
                min1 = num;
            } else if (num < min2) { // min1 <= num < min2
                min2 = num;
            }
        }

        int positiveProduct = max3 * max2 * max1;
        int negativeProduct = min1 * min2 * max1;

        return Math.max(positiveProduct, negativeProduct);
    }

}
