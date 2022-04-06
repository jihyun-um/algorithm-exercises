package javacode.solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/implement-trie-prefix-tree
class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // O(n) time, O(n) space
    // where n = length of word
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.isWord = true;
    }

    // O(n) time, O(1) space
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.isWord;
    }

    // O(n) time, O(1) space
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }

    // Test
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple") == true);
        System.out.println(trie.search("app") == false);
        System.out.println(trie.startsWith("app") == true);
        trie.insert("app");
        System.out.println(trie.search("app") == true);
    }
}
