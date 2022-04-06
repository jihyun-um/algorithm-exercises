package javacode.solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/implement-trie-ii-prefix-tree
class TrieNodeII {
    int prefixCount;
    int wordCount;
    Map<Character, TrieNodeII> children;

    public TrieNodeII() {
        wordCount = 0;
        children = new HashMap<>();
    }
}

class TrieII {
    TrieNodeII root;

    public TrieII() {
        root = new TrieNodeII();
    }

    // O(n) time, O(n) space
    // where n = length of word
    public void insert(String word) {
        TrieNodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNodeII());
            }
            node = node.children.get(letter);
            node.prefixCount++;
        }
        node.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                return 0;
            }
            node = node.children.get(letter);
        }
        return node.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNodeII node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!node.children.containsKey(letter)) {
                return 0;
            }
            node = node.children.get(letter);
        }
        return node.prefixCount;
    }

    public void erase(String word) {
        TrieNodeII node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                return;
            }
            node = node.children.get(letter);
            node.prefixCount--;
        }
        node.wordCount--;
    }

    // Test
    public static void main(String[] args) {
        TrieII trie = new TrieII();

        trie.insert("apple");
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("apple") == 2);
        System.out.println(trie.countWordsStartingWith("app") == 2);
        trie.erase("apple");
        System.out.println(trie.countWordsEqualTo("apple") == 1);
        System.out.println(trie.countWordsStartingWith("app") == 1);
        trie.erase("apple");
        System.out.println(trie.countWordsStartingWith("app") == 0);
    }
}
