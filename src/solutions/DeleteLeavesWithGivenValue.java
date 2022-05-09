package solutions;

import datastructure.TreeNode;

// [Problem] https://leetcode.com/problems/delete-leaves-with-a-given-value
class DeleteLeavesWithGivenValue {
    // Recursion
    // O(n) time, O(h) space where h = height
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        node.left = removeLeafNodes(node.left, target);
        node.right = removeLeafNodes(node.right, target);
        if (isLeafNode(node) && node.val == target) {
            return null;
        }
        return node;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Test
    public static void main(String[] args) {
        DeleteLeavesWithGivenValue solution = new DeleteLeavesWithGivenValue();

        TreeNode input = new TreeNode(1,
                new TreeNode(2, new TreeNode(2), null),
                new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        int target = 2;
        TreeNode expectedOutput = new TreeNode(1,
                null,
                new TreeNode(3, null, new TreeNode(4)));
        TreeNode actualOutput = solution.removeLeafNodes(input, target);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
