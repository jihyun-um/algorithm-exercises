package com.jihyunum.leetcode;

import com.jihyunum.leetcode.datastructure.ListNode;

// [Problem] https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedList {

    // test
    public static void main(String[] args) {

        // Input: 1->2->3->4->5->NULL
        ListNode head = ListNode.initFiveNodes();
        System.out.println(head);

        // Output: 5->4->3->2->1->NULL
        ListNode outputNode = reverseList(head);
        System.out.println(outputNode);

    }

    // O(N) Iterative solution
    private static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}
