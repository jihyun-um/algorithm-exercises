package javacode.solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/lfu-cache

// Doubly linked list with hash map
class LFUCache {
    int capacity;
    Map<Integer, LfuDoublyLinkedNode> valueCache; // O(n) space where n = capacity
    Map<Integer, LfuDoublyLinkedList> frequencyCache; // O(m) space where m = frequencies
    int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.valueCache = new HashMap<>();
        this.frequencyCache = new HashMap<>();
        this.minFrequency = 0;
    }

    // O(1) time
    public int get(int key) {
        LfuDoublyLinkedNode node = valueCache.get(key);
        if (node != null) {
            update(node);
            return node.value;
        }
        return -1;
    }

    // O(1) time
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        LfuDoublyLinkedNode node = valueCache.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            if (valueCache.size() == capacity) {
                LfuDoublyLinkedList lfu = frequencyCache.get(minFrequency);
                LfuDoublyLinkedNode nodeToRemove = lfu.popLast();
                valueCache.remove(nodeToRemove.key);
            }
            LfuDoublyLinkedNode newNode = new LfuDoublyLinkedNode(key, value);
            LfuDoublyLinkedList list = frequencyCache.getOrDefault(1, new LfuDoublyLinkedList());
            list.add(newNode);
            frequencyCache.put(1, list);
            valueCache.put(key, newNode);
            minFrequency = 1;
        }
    }

    // O(1) time
    private void update(LfuDoublyLinkedNode node) {
        LfuDoublyLinkedList oldList = frequencyCache.get(node.counter);
        oldList.remove(node);
        if (node.counter == minFrequency && oldList.size == 0) {
            minFrequency++;
        }
        node.counter++;
        LfuDoublyLinkedList newList = frequencyCache.getOrDefault(node.counter, new LfuDoublyLinkedList());
        newList.add(node);
        frequencyCache.put(node.counter, newList);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}

class LfuDoublyLinkedList {
    LfuDoublyLinkedNode head;
    LfuDoublyLinkedNode tail;
    int size;

    public LfuDoublyLinkedList() {
        head = new LfuDoublyLinkedNode();
        tail = new LfuDoublyLinkedNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(LfuDoublyLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void remove(LfuDoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public LfuDoublyLinkedNode popLast() {
        if (size > 0) {
            LfuDoublyLinkedNode lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
        return null;
    }
}

class LfuDoublyLinkedNode {
    int key;
    int value;
    int counter;
    LfuDoublyLinkedNode prev;
    LfuDoublyLinkedNode next;

    public LfuDoublyLinkedNode() {
    }

    public LfuDoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.counter = 1;
    }
}