// Problem: https://leetcode.com/problems/path-sum

// Definition for a binary tree node.
class TreeNode {
  constructor(val, left = null, right = null) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

// recursion solution - O(n) time, O(n) space
const hasPathSum = (root, targetSum) => {
  if (!root) {
    return false;
  }
  targetSum -= root.val;
  if (!root.left && !root.right) {
    return targetSum === 0;
  }
  return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
};

// test
/*
tree =    5
       /     \
      4       8
    /       /   \
   11      13    4
 /   \            \
7     2            1
*/
const root = new TreeNode(
  5,
  new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
  new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
);
const targetSum = 22;
const expectedOutput = true;
const actualOutput = hasPathSum(root, targetSum);

console.log('Test passed? ' + (actualOutput === expectedOutput));
