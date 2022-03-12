package javacode.solutions;

import javacode.datastructure.TreeNode;

import java.util.*;

// [Problem] https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
class BinaryTreeZigzagLevelOrderTraversal {
    // BFS
    // O(n) time, O(n) space
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean addReverseOrder = false;
        while (!nodes.isEmpty()) {
            int currentLevelSize = nodes.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = nodes.poll();
                if (addReverseOrder) {
                    currentLevel.addFirst(node.val);
                } else {
                    currentLevel.addLast(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            levels.add(currentLevel);
            addReverseOrder = !addReverseOrder;
        }
        return levels;
    }

    // Test
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

        // Given input tree:
        //     3
        //    / \
        //   9   20
        //      /  \
        //     15   7
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> expectedOutput = List.of(List.of(3), List.of(20, 9), List.of(15, 7));
        List<List<Integer>> actualOutput = solution.zigzagLevelOrder(root);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
