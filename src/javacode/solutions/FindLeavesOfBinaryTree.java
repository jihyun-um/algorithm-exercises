package javacode.solutions;

import javacode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/find-leaves-of-binary-tree
class FindLeavesOfBinaryTree {
    // O(N) time, O(N) space
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> removeHistory = new ArrayList<>();
        getHeight(root, removeHistory);
        return removeHistory;
    }

    private int getHeight(TreeNode node, List<List<Integer>> removeHistory) {
        if (node == null) {
            return -1;
        }
        int leftHeight = getHeight(node.left, removeHistory);
        int rightHeight = getHeight(node.right, removeHistory);

        int nodeHeight = Math.max(leftHeight, rightHeight) + 1;
        if (removeHistory.size() <= nodeHeight) {
            removeHistory.add(new ArrayList<>());
        }
        removeHistory.get(nodeHeight).add(node.val);

        return nodeHeight;
    }

    // test
    public static void main(String[] args) {
        FindLeavesOfBinaryTree removeHistory = new FindLeavesOfBinaryTree();

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        List<List<Integer>> expectedOutput = List.of(List.of(4, 5, 3), List.of(2), List.of(1));
        List<List<Integer>> actualOutput = removeHistory.findLeaves(root);

        System.out.println(actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
