package solutions;

import datastructure.ListNode;

// [Problem] https://leetcode.com/problems/linked-list-cycle-ii/
class LinkedListCycleII {

    // test
    public static void main(String[] args) {

        LinkedListCycleII solution = new LinkedListCycleII();

        // Input: head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode cycleHead = new ListNode(2);
        head.next = cycleHead;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = cycleHead;

        // Output: ListNode(2)
        ListNode output = solution.detectCycle(head);
        System.out.println("Test passed ? " + (output != null && output.val == 2));

    }

    // Floyd's Tortoise and Hare solution - O(N) time, O(1) space
    private ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode cycleHead = head;
                while (cycleHead != slow){
                    cycleHead = cycleHead.next;
                    slow = slow.next;
                }
                return cycleHead;
            }
        }
        return null;
    }

}
