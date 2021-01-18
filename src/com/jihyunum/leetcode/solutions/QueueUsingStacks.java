package com.jihyunum.leetcode.solutions;

import java.util.Stack;

// [Problem] https://leetcode.com/problems/implement-queue-using-stacks/
class QueueUsingStacks {

    // test
    public static void main(String[] args) {
        PushOptimizedQueue queue = new PushOptimizedQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("push() and peek() test passed? " + (queue.peek() == 1));
        System.out.println("pop() test passed? " + (queue.pop() == 1));
        System.out.println("empty() test passed? " + (queue.empty() == false));
    }

}

// pop & peek optimized
class PopOptimizedQueue {

    private Stack<Integer> queue;
    private Stack<Integer> backup;

    public PopOptimizedQueue() {
        queue = new Stack<>();
        backup = new Stack<>();
    }

    // O(n) time
    public void push(int x) {
        while (!queue.empty()) {
            backup.push(queue.pop());
        }
        queue.push(x);
        while (!backup.empty()) {
            queue.push(backup.pop());
        }
    }

    // O(1) time
    public int pop() {
        return queue.pop();
    }

    // O(1) time
    public int peek() {
        return queue.peek();
    }

    // O(1) time
    public boolean empty() {
        return queue.empty();
    }
}

// push optimized
class PushOptimizedQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    public PushOptimizedQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // O(1) time
    public void push(int x) {
        input.push(x);
    }

    // Amortized O(1), Worst-case O(n) time
    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    // Amortized O(1), Worst-case O(n) time
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // O(1) time
    public boolean empty() {
        return input.empty() && output.empty();
    }
}