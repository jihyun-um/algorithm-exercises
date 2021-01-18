package com.jihyunum.leetcode.solutions;

import com.jihyunum.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/binary-tree-level-order-traversal/
class BinaryTreeLevelOrderTraversal {

    // test
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // Input: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Output:
        // [
        //  [3],
        //  [9,20],
        //  [15,7]
        // ]
        List<List<Integer>> output = solution.levelOrder(root);
        System.out.println(output);
    }

    // BFS Solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> leveledValues = new ArrayList<>();
        if (root == null) {
            return leveledValues;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println(queue);
            int queueSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            leveledValues.add(currentLevel);
        }
        return leveledValues;
    }

}
