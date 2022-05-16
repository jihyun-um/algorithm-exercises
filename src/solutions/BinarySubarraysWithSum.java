package solutions;

// [Problem] https://leetcode.com/problems/binary-subarrays-with-sum
class BinarySubarraysWithSum {
    // Sliding window
    // O(n) time, O(1) space
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0, sum = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left < right && sum > goal) {
                sum -= nums[left++];
            }
            if (sum == goal) {
                count++;
                for (int i = left; i < right && nums[i] == 0; i++) {
                    count++;
                }
            }
        }
        return count;
    }

    // Test
    public static void main(String[] args) {
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();

        int[] nums1 = {1, 0, 1, 0, 1};
        int goal1 = 2;
        int expectedOutput1 = 4;
        int actualOutput1 = solution.numSubarraysWithSum(nums1, goal1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        int[] nums2 = {0, 0, 0, 0, 0};
        int goal2 = 0;
        int expectedOutput2 = 15;
        int actualOutput2 = solution.numSubarraysWithSum(nums2, goal2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
