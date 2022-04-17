package javacode.solutions;

import javacode.datastructure.ListNode;

// [Problem] https://leetcode.com/problems/add-two-numbers
class AddTwoNumbers {
    // Linked list
    // O(max(m, n)) time, O(max(m, n)) space
    // where m = length of l1, n = length of l2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode l1Pointer = l1, l2Pointer = l2, resultPointer = result;
        int carryOver = 0;
        while (l1Pointer != null || l2Pointer != null) {
            int l1Val = l1Pointer != null ? l1Pointer.val : 0;
            int l2Val = l2Pointer != null ? l2Pointer.val : 0;
            int sum = carryOver + l1Val + l2Val;
            carryOver = sum / 10;
            resultPointer.next = new ListNode(sum % 10);
            resultPointer = resultPointer.next;
            l1Pointer = l1Pointer != null ? l1Pointer.next : null;
            l2Pointer = l2Pointer != null ? l2Pointer.next : null;
        }
        if (carryOver > 0) {
            resultPointer.next = new ListNode(carryOver);
        }
        return result.next;
    }

    // Test
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode output = solution.addTwoNumbers(l1, l2);
        System.out.println(output); // expected: [7, 0, 8]
    }
}
