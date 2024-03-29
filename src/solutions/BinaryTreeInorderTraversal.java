package solutions;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// [Problem] https://leetcode.com/problems/binary-tree-inorder-traversal/
class BinaryTreeInorderTraversal {
    // Recursion
    // O(n) time, O(logn) space
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        addValueInorder(root, values);
        return values;
    }

    private void addValueInorder(TreeNode node, List<Integer> values) {
        if (node != null) {
            addValueInorder(node.left, values);
            values.add(node.val);
            addValueInorder(node.right, values);
        }
    }

    // Stack
    // O(n) time, O(n) space
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            values.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return values;
    }
}
