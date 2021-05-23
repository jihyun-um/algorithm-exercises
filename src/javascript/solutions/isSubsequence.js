// Problem: https://leetcode.com/problems/is-subsequence

// two pointers solution - O(n) time, O(1) space
const isSubsequence = (sequence, str) => {
    let index = 0;
    let seqIndex = 0;
    while (index < str.length && seqIndex < sequence.length) {
        if (str.charAt(index) === sequence.charAt(seqIndex)) {
            seqIndex++;
        }
        index++;
    }
    return seqIndex === sequence.length;
};

// test
const sequence = "abc"
const str = "ahbgdc";
const expectedOutput = true;
const actualOutput = isSubsequence(sequence, str);
console.log('Test passed? ' + (actualOutput === expectedOutput));