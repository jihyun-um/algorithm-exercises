package solutions;

import datastructure.TreeNode;

// [Problem] https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class ConvertSortedArrayToBST {
    // Binary search
    // O(logn) time, O(1) space
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = sortedArrayToBST(nums, startIndex, midIndex - 1);
        node.right = sortedArrayToBST(nums, midIndex + 1, endIndex);
        return node;
    }
}
