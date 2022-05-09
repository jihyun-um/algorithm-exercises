package solutions;

// [Problem] https://leetcode.com/problems/moving-average-from-data-stream/

import java.util.LinkedList;
import java.util.Queue;

class MovingAverageFromDataStream {

    // test
    public static void main(String[] args) {

        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("Test passed? " + (movingAverage.next(1) == 1));
        System.out.println("Test passed? " + (movingAverage.next(10) == ((double) (1 + 10) / 2)));
        System.out.println("Test passed? " + (movingAverage.next(3) == ((double) (1 + 10 + 3) / 3)));
        System.out.println("Test passed? " + (movingAverage.next(5) == ((double) (10 + 3 + 5) / 3)));

    }

}

// Using queue - O(1) time, O(n) space
class MovingAverage {

    int maxSize;
    Queue<Integer> elements;
    double sum;

    public MovingAverage(int size) {
        maxSize = size;
        elements = new LinkedList<>();
        sum = 0D;
    }

    public double next(int val) {
        if (elements.size() == maxSize) {
            sum -= elements.poll();
        }
        elements.add(val);
        sum += val;

        return sum / elements.size();
    }

}