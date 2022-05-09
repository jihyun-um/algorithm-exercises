package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/lru-cache

// Doubly linked list
class LRUCache {
    Map<Integer, LruDoublyLinkedNode> cache;

    int capacity;
    LruDoublyLinkedList recentlyUsed;

    // O(n) space where n = capacity
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.recentlyUsed = new LruDoublyLinkedList();
    }

    // O(1) time
    public int get(int key) {
        LruDoublyLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        recentlyUsed.moveToHead(node);
        return node.value;
    }

    // O(1) time
    public void put(int key, int value) {
        LruDoublyLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            recentlyUsed.moveToHead(node);
        } else {
            LruDoublyLinkedNode newNode = new LruDoublyLinkedNode(key, value);
            cache.put(key, newNode);
            recentlyUsed.add(newNode);
            if (recentlyUsed.size > capacity) {
                LruDoublyLinkedNode tailNode = recentlyUsed.popLast();
                cache.remove(tailNode.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

class LruDoublyLinkedList {
    LruDoublyLinkedNode head;
    LruDoublyLinkedNode tail;
    int size;

    public LruDoublyLinkedList() {
        head = new LruDoublyLinkedNode();
        tail = new LruDoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(LruDoublyLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(LruDoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void moveToHead(LruDoublyLinkedNode node){
        remove(node);
        add(node);
    }

    public LruDoublyLinkedNode popLast() {
        LruDoublyLinkedNode lastNode = tail.prev;
        remove(lastNode);
        return lastNode;
    }
}

class LruDoublyLinkedNode {
    int key;
    int value;
    LruDoublyLinkedNode prev;
    LruDoublyLinkedNode next;

    public LruDoublyLinkedNode() {}

    public LruDoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}