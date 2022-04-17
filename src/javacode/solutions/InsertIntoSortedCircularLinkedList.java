package javacode.solutions;

import javacode.datastructure.ListNode;

// [Problem] https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list
class InsertIntoSortedCircularLinkedList {
    // Circular linked list
    // O(n) time, O(1) space
    public ListNode insert(ListNode head, int insertVal) {
        ListNode newNode = new ListNode(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode current = head;
        ListNode next = head.next;
        while (next != head) {
            if ((insertVal >= current.val && insertVal <= next.val) ||
                    (next.val < current.val && (insertVal <= next.val || insertVal >= current.val))) {
                break;
            }
            current = next;
            next = next.next;
        }
        current.next = newNode;
        newNode.next = next;
        return head;
    }

    // Test
    public static void main(String[] args) {
        InsertIntoSortedCircularLinkedList solution = new InsertIntoSortedCircularLinkedList();

        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = head;
        int insertVal = 2;

        ListNode output = solution.insert(head, insertVal);
    }
}