// Problem: https://leetcode.com/problems/path-sum-ii

const { isEqual } = require('../utils/helpers');
const { TreeNode } = require('../datastructure/treeNode');

// DFS solution - O(n) time, O(n) space
const pathSum = (root, targetSum) => {
  let validPaths = [];
  addValidPath(root, targetSum, [], validPaths);
  return validPaths;
};

const addValidPath = (root, targetSum, path, validPaths) => {
  if (!root) {
    return;
  }
  const newPath = [...path, root.val];
  if (!root.left && !root.right && targetSum === root.val) {
    validPaths.push(newPath);
  }
  addValidPath(root.left, targetSum - root.val, newPath, validPaths);
  addValidPath(root.right, targetSum - root.val, newPath, validPaths);
};

// test
/*
tree =    5
       /     \
      4       8
    /       /   \
   11      13    4
 /   \          /  \
7     2        5    1
*/
const root = new TreeNode(
  5,
  new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
  new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
);
const targetSum = 22;
const expectedOutput = [
  [5, 4, 11, 2],
  [5, 8, 4, 5],
];
const actualOutput = pathSum(root, targetSum);

console.log(actualOutput);
console.log('Test passed? ' + isEqual(actualOutput, expectedOutput));
