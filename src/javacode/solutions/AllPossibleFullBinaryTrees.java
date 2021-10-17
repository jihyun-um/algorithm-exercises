package javacode.solutions;

import javacode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// [Problem] https://leetcode.com/problems/all-possible-full-binary-trees
class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> memo = new HashMap();

    // O(2^n) time, O(2^n) space
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> fullBinaryTrees = new ArrayList<>();
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n % 2 == 0) {
            return fullBinaryTrees;
        }
        if (n == 1) {
            fullBinaryTrees.add(new TreeNode(0));
            return fullBinaryTrees;
        }
        for (int left = 0; left < n; left++) {
            int right = n - 1 - left;
            List<TreeNode> leftNodes = allPossibleFBT(left);
            List<TreeNode> rightNodes = allPossibleFBT(right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    fullBinaryTrees.add(node);
                }
            }
        }
        memo.put(n, fullBinaryTrees);
        return fullBinaryTrees;
    }
}
