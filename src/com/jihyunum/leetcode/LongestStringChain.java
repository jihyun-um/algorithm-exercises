package com.jihyunum.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/longest-string-chain/
class LongestStringChain {

    // test
    public static void main(String[] args) {
        LongestStringChain solution = new LongestStringChain();

        // one of the longest word chain is "a","ba","bda","bdca".
        String[] input = {"a", "b", "ba", "bca", "bda", "bdca"};
        int expectedOutput = 4;
        int actualOutput = solution.longestStrChain(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));

    }

    // Dynamic Programming with HashMap - O(NlogN + NL) time, O(N) space
    public int longestStrChain(String[] words) {
        Map<String, Integer> chainLengths = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // O(NlogN)

        int maxChainLength = 0;
        for (String word : words) {  // O(NL)
            int chainLength = 0;
            for (int i = 0; i < word.length(); ++i) { // O(L)
                String prevWord = word.substring(0, i) + word.substring(i + 1);
                int prevChainLength = chainLengths.getOrDefault(prevWord, 0);
                chainLength = Math.max(chainLength, prevChainLength + 1);
            }
            chainLengths.put(word, chainLength);
            maxChainLength = Math.max(maxChainLength, chainLength);
        }
        return maxChainLength;
    }

}
