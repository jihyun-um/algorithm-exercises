package solutions;

import datastructure.TreeNode;

// [Problem] https://leetcode.com/problems/count-univalue-subtrees
class CountUnivalueSubtrees {
    int count = 0;

    // DFS
    // O(n) time, O(h) space where h = height
    public int countUnivalSubtrees(TreeNode node) {
        isUnivalue(node, 0);
        return count;
    }

    boolean isUnivalue(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        boolean isLeftUnivalue = isUnivalue(node.left, node.val);
        boolean isRightUnivalue = isUnivalue(node.right, node.val);
        if (isLeftUnivalue && isRightUnivalue) {
            count++;
            return node.val == value;
        }
        return false;
    }

    // Test
    public static void main(String[] args) {
        CountUnivalueSubtrees solution = new CountUnivalueSubtrees();

        // Given input tree:
        //     5
        //    / \
        //   1   5
        //  / \   \
        // 5   5   5
        TreeNode input = new TreeNode(5,
                new TreeNode(1, new TreeNode(5), new TreeNode(5)),
                new TreeNode(5, null, new TreeNode(5)));
        int expectedOutput = 4;
        int actualOutput = solution.countUnivalSubtrees(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
