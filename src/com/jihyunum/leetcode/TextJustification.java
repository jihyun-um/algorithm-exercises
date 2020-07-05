package com.jihyunum.leetcode;

import java.util.ArrayList;
import java.util.List;

// [Problem] https://leetcode.com/problems/text-justification/
class TextJustification {

    // test
    public static void main(String[] args) {
        TextJustification solution = new TextJustification();

        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> expectedOutput = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        ");
        List<String> actualOutput = solution.fullJustify(words, maxWidth);

        System.out.println("Test passed? " + expectedOutput.equals(actualOutput));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedOutput = new ArrayList<>();

        int left = 0;
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            justifiedOutput.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }

        return justifiedOutput;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int lineLength = words[right++].length();

        while (right < words.length && (lineLength + words[right].length() + 1) <= maxWidth) {
            lineLength += words[right++].length() + 1;
        }
        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (left == right) {
            return padRight(words[left], maxWidth);
        }

        int wordsLength = 0;
        for (int i = left; i <= right; i++) {
            wordsLength += words[i].length();
        }

        int totalSpaces = maxWidth - wordsLength;
        int numSpaceSpots = right - left;

        boolean isLastLine = right == words.length - 1;
        int numSpaces = isLastLine ? 1 : totalSpaces / numSpaceSpots;
        int numRemainders = isLastLine ? 0 : totalSpaces % numSpaceSpots;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++) {
            result.append(words[i])
                    .append(repeatSpace(numSpaces))
                    .append(numRemainders-- > 0 ? " " : "");
        }

        return padRight(result.toString().trim(), maxWidth);
    }

    private String padRight(String result, int maxWidth) {
        return result + repeatSpace(maxWidth - result.length());
    }

    private String repeatSpace(int numSpaces) {
        return " ".repeat(numSpaces);
    }

}
