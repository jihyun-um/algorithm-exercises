package javacode.solutions;

// [Problem] https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list
class InsertIntoSortedCircularLinkedList {
    // Circular linked list
    // O(n) time, O(1) space
    public CircularLinkedNode insert(CircularLinkedNode head, int insertVal) {
        CircularLinkedNode newNode = new CircularLinkedNode(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        CircularLinkedNode current = head;
        CircularLinkedNode next = head.next;
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

        CircularLinkedNode head = new CircularLinkedNode(3);
        head.next = new CircularLinkedNode(4);
        head.next.next = new CircularLinkedNode(1);
        head.next.next.next = head;
        int insertVal = 2;

        CircularLinkedNode output = solution.insert(head, insertVal);
    }
}

class CircularLinkedNode {
    public int val;
    public CircularLinkedNode next;

    public CircularLinkedNode() {
    }

    public CircularLinkedNode(int val) {
        this.val = val;
    }

    public CircularLinkedNode(int val, CircularLinkedNode next) {
        this.val = val;
        this.next = next;
    }
}