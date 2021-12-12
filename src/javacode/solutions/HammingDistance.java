package javacode.solutions;

// [Problem] https://leetcode.com/problems/hamming-distance
class HammingDistance {
    // Xor with built-in bitCount function
    // O(k) time where k = number of bits, O(1) space
    public int hammingDistance(int x, int y) {
        // xor returns 0 for same digits, 1 for different digits
        int xor = x ^ y;
        // bitCount() returns the number of 1s
        return Integer.bitCount(xor);
    }

    // Xor with bit counting by logical shift
    // O(k) time where k = number of bits, O(1) space
    public int hammingDistanceLogicalShift(int x, int y) {
        int xor = x ^ y;
        int differentDigits = 0;
        while (xor != 0) {
            // check if the rightmost bit of xor is 1
            if (xor % 2 == 1) {
                differentDigits++;
            }
            // right shift by 1
            xor = xor >> 1;
        }
        return differentDigits;
    }

    // test
    public static void main(String[] args) {
        HammingDistance solution = new HammingDistance();

        int x = 1; // 0 0 1
        int y = 4; // 1 0 0
        int expectedOutput = 2;
        int actualOutput = solution.hammingDistance(x, y);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
