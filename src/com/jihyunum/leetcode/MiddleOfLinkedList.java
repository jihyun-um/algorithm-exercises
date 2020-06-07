package com.jihyunum.leetcode;

import com.jihyunum.leetcode.datastructure.ListNode;

// [Problem] https://leetcode.com/problems/middle-of-the-linked-list/
class MiddleOfLinkedList {

    // test
    public static void main(String[] args) {

        MiddleOfLinkedList solution = new MiddleOfLinkedList();

        // Input: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ListNode.initFiveNodes();
        System.out.println(head);

        ListNode expectedOutput = new ListNode(3);
        ListNode actualOutput = solution.middleNode(head);

        System.out.println("Test passed? " + (expectedOutput.val == actualOutput.val));
    }

    // Array solution - O(n) time, O(n) space
    public ListNode middleNodeArray(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        ListNode current = head;
        int i = 0;
        while (current != null) {
            nodes[i++] = current;
            current = current.next;
        }
        return nodes[i / 2];
    }

    // Two pointers solution - O(n) time, O(1) space
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
