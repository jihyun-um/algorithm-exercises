package com.jihyunum.leetcode;

import com.jihyunum.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/palindrome-linked-list/
class PalindromeLinkedList {

    // test
    public static void main(String[] args) {

        PalindromeLinkedList solution = new PalindromeLinkedList();

        // Input: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(head);

        boolean expectedOutput = true;
        boolean actualOutput = solution.isPalindrome(head);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // ArrayList solution - O(n) time, O(n) space
    public boolean isPalindromeArrayList(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current.next != null) {
            values.add(current.val);
            current = current.next;
        }
        values.add(current.val);

        int length = values.size();
        for (int i = 0; i < length / 2; i++) {
            if (!values.get(i).equals(values.get(length - i - 1))) {
                return false;
            }
        }
        return true;
    }

    // Two pointers solution - O(n) time, O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversed = reverse(slow);
        ListNode current = head;
        while (current != null && reversed != null) {
            if (current.val != reversed.val) {
                return false;
            }
            current = current.next;
            reversed = reversed.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
