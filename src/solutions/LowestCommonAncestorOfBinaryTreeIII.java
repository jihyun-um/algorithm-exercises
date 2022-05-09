package solutions;

import java.util.*;

// [Problem] https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii
class LowestCommonAncestorOfBinaryTreeIII {
    // Approach 1: Store the path from p to the root, traverse the path from q to the root
    // O(h) time, O(h) space where h = height of deeper node
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> pPath = new ArrayList<>();
        while (p.parent != null) {
            pPath.add(p);
            p = p.parent;
        }
        while (q.parent != null) {
            if (pPath.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    // Approach 2: Use two pointers for each list
    // O(h) time, O(1) space
    public Node lowestCommonAncestorTwoPointers(Node p, Node q) {
        Node pointer1 = p, pointer2 = q;
        while (pointer1 != pointer2) {
            pointer1 = pointer1 == null ? q : pointer1.parent;
            pointer2 = pointer2 == null ? p : pointer2.parent;
        }
        return pointer1;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
