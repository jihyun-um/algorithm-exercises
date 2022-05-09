package solutions;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/maximum-product-of-splitted-binary-tree
class MaximumProductOfSplitBinaryTree {
    List<Long> allSums = new ArrayList<>();

    // DFS
    // O(n) time, O(n) space
    public int maxProduct(TreeNode root) {
        long totalSum = calculateTreeSum(root);
        long maxProduct = 0;
        for (long sum : allSums) {
            maxProduct = Math.max(sum * (totalSum - sum), maxProduct);
        }
        return (int) (maxProduct % 1000000007);
    }

    private long calculateTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        long treeSum = node.val + calculateTreeSum(node.left) + calculateTreeSum(node.right);
        allSums.add(treeSum);
        return treeSum;
    }

    // Test
    public static void main(String[] args) {
        MaximumProductOfSplitBinaryTree solution = new MaximumProductOfSplitBinaryTree();

        // Given input tree:
        //      1
        //    /   \
        //   2     3
        //  / \   /
        // 4   5 6
        TreeNode input1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        int expectedOutput1 = 110;
        int actualOutput1 = solution.maxProduct(input1);
        System.out.println("Test 1 passed? " + (expectedOutput1 == actualOutput1));

        // Given input tree:
        //      1
        //       \
        //        2
        //       / \
        //      3   4
        //         / \
        //        5   6
        TreeNode input2 = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4, new TreeNode(5), new TreeNode(6))));
        int expectedOutput2 = 110;
        int actualOutput2 = solution.maxProduct(input2);
        System.out.println("Test 2 passed? " + (expectedOutput2 == actualOutput2));
    }
}
