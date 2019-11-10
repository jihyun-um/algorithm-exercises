package com.jihyunum.leetcode;

// [Problem] https://leetcode.com/problems/odd-even-linked-list/
class OddEvenLinkedList {

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

        // Output: 1->3->5->2->4->NULL
        ListNode output = oddEvenList(head);
        System.out.println(output);

    }

    public static class ListNode {
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

    // O(N) time, O(1) space solution
    private static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

}
