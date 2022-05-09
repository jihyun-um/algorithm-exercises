package solutions;

import java.util.Stack;

// [Problem] https://leetcode.com/problems/min-stack

// Two stacks
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack; // O(n) space

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // O(1) time
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // O(1) time
    public void pop() {
        if (minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    // O(1) time
    public int top() {
        return stack.peek();
    }

    // O(1) time
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}