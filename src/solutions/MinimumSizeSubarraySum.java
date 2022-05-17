package solutions;

// [Problem] https://leetcode.com/problems/minimum-size-subarray-sum
class MinimumSizeSubarraySum {
    // Sliding window
    // O(n) time, O(1) space
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, minLength = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Test
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        int expectedOutput1 = 2;
        int actualOutput1 = solution.minSubArrayLen(target1, nums1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        int expectedOutput2 = 1;
        int actualOutput2 = solution.minSubArrayLen(target2, nums2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
