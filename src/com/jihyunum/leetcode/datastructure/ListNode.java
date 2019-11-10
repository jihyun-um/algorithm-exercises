package com.jihyunum.leetcode.datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    // Return 1->2->3->4->5->NULL
    public static ListNode initFiveNodes() {
        ListNode head = new ListNode(1), node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode nextNode = new ListNode(i);
            node.next = nextNode;
            node = nextNode;
        }
        return head;
    }

}
