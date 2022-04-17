package javacode.datastructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " ---> " + next;
    }

    // Return 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    public static ListNode initFiveNodes() {
        ListNode head = new ListNode(1), node = head;
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head;
    }

}
