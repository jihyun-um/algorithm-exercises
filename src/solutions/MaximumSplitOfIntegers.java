package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/maximum-split-of-positive-even-integers
class MaximumSplitOfIntegers {
    // Min heap
    // O(nlogn) time, O(n) space
    // where n = total number of meetings in schedule
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> numbers = new ArrayList<>();
        long currentNumber = 2L;
        while (finalSum > 0) {
            if (finalSum - currentNumber > currentNumber) {
                finalSum -= currentNumber;
                numbers.add(currentNumber);
            } else {
                numbers.add(finalSum);
                break;
            }
            currentNumber += 2;
        }
        return numbers;
    }

    // Test
    public static void main(String[] args) {
        MaximumSplitOfIntegers solution = new MaximumSplitOfIntegers();

        long input1 = 12;
        List<Long> expectedOutput1 = List.of(2L, 4L, 6L);
        List<Long> actualOutput1 = solution.maximumEvenSplit(input1);
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        long input2 = 28;
        List<Long> expectedOutput2 = List.of(2L, 4L, 6L, 16L);
        List<Long> actualOutput2 = solution.maximumEvenSplit(input2);
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}