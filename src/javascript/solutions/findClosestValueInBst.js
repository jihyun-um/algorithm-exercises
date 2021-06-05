// Problem: https://leetcode.com/problems/closest-binary-search-tree-value

// This is the class of the input tree
class BST {
  constructor(value, left = null, right = null) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}

// recursion solution
// average O(log(n)) time, O(log(n)) space
// worst O(n) time, O(n) space
const findClosestValueInBst = (tree, target) => {
  return findClosestValueInBstHelper(tree, target, tree.value);
};

const findClosestValueInBstHelper = (tree, target, closestValue) => {
  if (tree === null) {
    return closestValue;
  }
  if (Math.abs(target - tree.value) < Math.abs(target - closestValue)) {
    closestValue = tree.value;
  }
  if (target < tree.value) {
    return findClosestValueInBstHelper(tree.left, target, closestValue);
  } else if (target > tree.value) {
    return findClosestValueInBstHelper(tree.right, target, closestValue);
  } else {
    return closestValue;
  }
};

// test
/*
tree =   10
       /     \
      5      15
    /   \   /   \
   2     5 13   22
 /           \
1            14
*/
const tree = new BST(
  10,
  new BST(5, new BST(2, new BST(1), null), new BST(5)),
  new BST(15, new BST(13, null, new BST(14)), new BST(22))
);
const target = 17;
const expectedOutput = 15;
const actualOutput = findClosestValueInBst(tree, target);

console.log(actualOutput);
console.log(actualOutput === expectedOutput);
