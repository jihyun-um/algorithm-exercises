package javacode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// [Problem] https://leetcode.com/problems/word-search-ii
class WordTrieNode {
    String word;
    Map<Character, WordTrieNode> children;

    public WordTrieNode() {
        word = null;
        children = new HashMap<>();
    }
}

class WordSearchII {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    private char[][] board;
    private int rowSize;
    private int colSize;

    // Backtracking with Trie
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rowSize = board.length;
        this.colSize = board[0].length;

        WordTrieNode root = buildTrie(words);
        List<String> found = new ArrayList<>();
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtrack(row, col, root, found);
                }
            }
        }
        return found;
    }

    private WordTrieNode buildTrie(String[] words) {
        WordTrieNode root = new WordTrieNode();
        for (String word : words) {
            WordTrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new WordTrieNode());
                }
                node = node.children.get(letter);
            }
            node.word = word;
        }
        return root;
    }

    private void backtrack(int row, int col, WordTrieNode node, List<String> foundWords) {
        char letter = board[row][col];
        WordTrieNode currentNode = node.children.get(letter);

        if (currentNode.word != null) {
            foundWords.add(currentNode.word);
            currentNode.word = null;
        }

        board[row][col] = '#';
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rowSize && nextCol >= 0 && nextCol < colSize
                    && currentNode.children.containsKey(board[nextRow][nextCol])) {
                backtrack(nextRow, nextCol, currentNode, foundWords);
            }
        }
        board[row][col] = letter;

        if (currentNode.children.isEmpty()) {
            node.children.remove(letter);
        }
    }

    // Test
    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();

        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words1 = {"oath", "pea", "eat", "rain"};
        List<String> expectedOutput1 = List.of("oath", "eat");
        List<String> actualOutput1 = solution.findWords(board1, words1);
        System.out.println("Test 1 passed? " + expectedOutput1.equals(actualOutput1));

        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}};
        String[] words2 = {"abcb"};
        List<String> expectedOutput2 = new ArrayList<>();
        List<String> actualOutput2 = solution.findWords(board2, words2);
        System.out.println("Test 2 passed? " + expectedOutput2.equals(actualOutput2));
    }
}
