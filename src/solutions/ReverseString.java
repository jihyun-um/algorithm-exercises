package solutions;

import java.util.Arrays;

// [Problem] https://leetcode.com/problems/reverse-string/
class ReverseString {

    // test
    public static void main(String[] args) {

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] expectedOutput = new char[]{'o', 'l', 'l', 'e', 'h'};
        reverseString(arr);

        System.out.println("Test passed? " + Arrays.equals(arr, expectedOutput));

    }

    // O(N) solution
    private static void reverseString(char[] arr) {
        int n = arr.length;
        char temp;
        for (int i = 0; i < n / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

}
