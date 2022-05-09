package solutions;

import datastructure.ListNode;

// [Problem] https://leetcode.com/problems/insertion-sort-list
class InsertionSortList {
    // Moving over to another linked list
    // O(n^2) time, O(1) space
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode current = head;
        while (current != null) {
            ListNode prev = newHead;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            ListNode next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        return newHead.next;
    }

    // Test
    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();

        ListNode input = new ListNode(4);
        input.next = new ListNode(2);
        input.next.next = new ListNode(1);
        input.next.next.next = new ListNode(3);

        ListNode output = solution.insertionSortList(input);
        System.out.println(output); // expected: [1, 2, 3, 4]
    }
}
