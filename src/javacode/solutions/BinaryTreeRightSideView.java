package javacode.solutions;

import javacode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/binary-tree-right-side-view
class BinaryTreeRightSideView {
    // BFS
    // O(n) time, O(d) space where d = tree diameter
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightmostValues = new ArrayList<>();
        if (root == null) {
            return rightmostValues;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int currentLevelSize = nodes.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = nodes.poll();
                if (i == currentLevelSize - 1) {
                    rightmostValues.add(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return rightmostValues;
    }

    // Test
    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

        // Given input tree:
        //     1
        //    / \
        //   2   3
        //    \   \
        //     5   4
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)));

        List<Integer> expectedOutput = List.of(1, 3, 4);
        List<Integer> actualOutput = solution.rightSideView(root);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
