package com.jihyunum.leetcode;

// [Problem] https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedList {

    // test
    public static void main(String[] args) {

        // Input: 1->2->3->4->5->NULL
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode nextNode = new ListNode(i);
            node.next = nextNode;
            node = nextNode;
        }
        System.out.println(head);

        // Output: 5->4->3->2->1->NULL
        ListNode outputNode = reverseList(head);
        System.out.println(outputNode);

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
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
