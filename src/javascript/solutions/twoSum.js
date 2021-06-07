// Problem: https://leetcode.com/problems/two-sum

const { isEqual } = require('../utils/helpers');

// map solution - O(N) time, O(n) space
const twoSum = (nums, target) => {
  const targetNums = {};
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    const complement = target - num;
    const complementInx = targetNums[complement];
    if (complementInx >= 0) {
      return [complementInx, i];
    }
    targetNums[num] = i;
  }
  return [];
};

// test
const nums = [2, 7, 11, 15];
const target = 9;
const expectedOutput = [0, 1];
const actualOutput = twoSum(nums, target);
console.log('Test passed? ' + isEqual(actualOutput, expectedOutput));
