package solutions;

import datastructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

// [Problem] https://leetcode.com/problems/delete-nodes-and-return-forest
class DeleteNodesAndReturnForest {
    // DFS
    // O(n) time, O(n) space
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> nodesToDelete = Arrays.stream(toDelete).boxed().collect(Collectors.toSet());
        List<TreeNode> forest = new ArrayList<>();
        if (!nodesToDelete.contains(root.val)) {
            forest.add(root);
        }
        deleteNodes(root, nodesToDelete, forest);
        return forest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> nodesToDelete, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        node.left = deleteNodes(node.left, nodesToDelete, forest);
        node.right = deleteNodes(node.right, nodesToDelete, forest);
        if (nodesToDelete.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        return node;
    }

    // Test
    public static void main(String[] args) {
        DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();

        // Given input tree:
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6   7
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        int[] toDelete = {3, 5};

        List<TreeNode> expectedOutput = List.of(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), null), null),
                new TreeNode(6),
                new TreeNode(7));
        List<TreeNode> actualOutput = solution.delNodes(root, toDelete);

        System.out.println(actualOutput);
        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }
}
