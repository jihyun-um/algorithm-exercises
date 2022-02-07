package javacode.solutions;

// [Problem] https://leetcode.com/problems/peak-index-in-a-mountain-array
class PeakIndexInMountainArray {
    // Linear scan
    // O(N) time, O(1) space
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // Binary search
    // O(logN) time, O(1) space
    public int peakIndexInMountainArrayBinarySearch(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Test
    public static void main(String[] args) {
        PeakIndexInMountainArray solution = new PeakIndexInMountainArray();

        int[] input = {0, 10, 5, 2};
        int expectedOutput = 1;
        int actualOutput = solution.peakIndexInMountainArray(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
