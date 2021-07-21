package javacode.solutions;

import javacode.datastructure.TreeNode;

// [Problem] https://leetcode.com/problems/subtree-of-another-tree/
class SubtreeOfAnotherTree {

    // test
    public static void main(String[] args) {

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

        // Given tree s:
        //      3
        //    / \
        //   4   5
        //  / \
        // 1   2
        TreeNode s = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));

        // Given tree t:
        //   4
        //  / \
        // 1   2
        TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        boolean expectedOutput = true;
        boolean actualOutput = solution.isSubtree(s, t);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }

    // Preorder Traversal and Recursion - O(m * n) time, O(n) space
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
