package solutions;

// [Problem] https://leetcode.com/problems/find-median-from-data-stream

import java.util.PriorityQueue;
import java.util.Queue;

// Using two heaps (one min heap, one max heap)
// O(logN) time add, O(1) time findMedian
class MedianFinder {
    Queue<Integer> smallHalf; // max heap
    Queue<Integer> largeHalf; // min heap

    public MedianFinder() {
        smallHalf = new PriorityQueue<>((a, b) -> b - a);
        largeHalf = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        largeHalf.add(num);
        smallHalf.add(largeHalf.poll());
        if (largeHalf.size() < smallHalf.size()) {
            largeHalf.add(smallHalf.poll());
        }
    }

    public double findMedian() {
        if (largeHalf.size() > smallHalf.size()) {
            return largeHalf.peek();
        } else {
            return (double) (smallHalf.peek() + largeHalf.peek()) / 2;
        }
    }

    // Test
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        medianFinder.addNum(-5);
        double actualOutput = medianFinder.findMedian();
        double expectedOutput = -3D;

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}