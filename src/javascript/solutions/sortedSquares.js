const { isEqual } = require('../utils/helpers');

// Problem: https://leetcode.com/problems/squares-of-a-sorted-array

// two pointers solution - O(n) time, O(n) space
const sortedSquares = (nums) => {
  let squares = Array(nums.length);
  let leftIndex = 0;
  let rightIndex = nums.length - 1;

  for (let i = nums.length - 1; i >= 0; i--) {
    const left = Math.pow(nums[leftIndex], 2);
    const right = Math.pow(nums[rightIndex], 2);
    if (left > right) {
      squares[i] = left;
      leftIndex++;
    } else {
      squares[i] = right;
      rightIndex--;
    }
  }
  return squares;
};

// test
const input = [-4, -1, 0, 3, 10];
const expectedOutput = [0, 1, 9, 16, 100];
const actualOutput = sortedSquares(input);
console.log('Test passed? ' + isEqual(actualOutput, expectedOutput));
