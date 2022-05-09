package solutions;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/binary-tree-level-order-traversal
class BinaryTreeLevelOrderTraversal {
    // BFS
    // O(n) time, O(n) space
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int currentLevelSize = nodes.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = nodes.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            levels.add(currentLevel);
        }
        return levels;
    }

    // Test
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // Given input tree:
        //     3
        //    / \
        //   9   20
        //      /  \
        //     15   7
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> expectedOutput = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        List<List<Integer>> actualOutput = solution.levelOrder(root);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
