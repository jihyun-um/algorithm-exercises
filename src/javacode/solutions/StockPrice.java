package javacode.solutions;

// [Problem] https://leetcode.com/problems/stock-price-fluctuation

import java.util.*;

// Min & Max Heaps
class StockPriceHeap {
    Map<Integer, Integer> records;
    Queue<StockRecord> minHeap;
    Queue<StockRecord> maxHeap;
    StockRecord latestRecord;

    // O(n) space where n = number of prices
    public StockPriceHeap() {
        records = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b) -> a.price - b.price);
        maxHeap = new PriorityQueue<>((a, b) -> b.price - a.price);
    }

    // O(logn) time
    public void update(int timestamp, int price) {
        StockRecord record = new StockRecord(timestamp, price);
        records.put(timestamp, price);
        minHeap.add(record);
        maxHeap.add(record);
        if (latestRecord == null || timestamp >= latestRecord.timestamp) {
            latestRecord = record;
        }
    }

    // O(1) time
    public int current() {
        return latestRecord.price;
    }

    // O(k) time, where k = number of outdated max records
    public int maximum() {
        StockRecord maxRecord = maxHeap.peek();
        while (records.get(maxRecord.timestamp) != maxRecord.price) {
            maxHeap.poll();
            maxRecord = maxHeap.peek();
        }
        return maxRecord.price;
    }

    // O(k) time, where k = number of outdated min records
    public int minimum() {
        StockRecord minRecord = minHeap.peek();
        while (records.get(minRecord.timestamp) != minRecord.price) {
            minHeap.poll();
            minRecord = minHeap.peek();
        }
        return minRecord.price;
    }

    // Test
    public static void main(String[] args) {
        StockPriceHeap stockPrice = new StockPriceHeap();
        stockPrice.update(1, 10);                   // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);                    // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());   // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());   // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);                    // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());   // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);                    // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());   // return 2, the minimum price is 2 at timestamp 4.
    }
}

class StockRecord {
    int price;
    int timestamp;

    public StockRecord(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }
}

// Two TreeMaps
class StockPrice {
    TreeMap<Integer, Integer> pricePerTimestamp;
    TreeMap<Integer, Set<Integer>> timestampsPerPrice;

    // O(n) space
    public StockPrice() {
        pricePerTimestamp = new TreeMap<>();
        timestampsPerPrice = new TreeMap<>();
    }

    // O(logn) time
    public void update(int timestamp, int price) {
        if (pricePerTimestamp.containsKey(timestamp)) {
            int prevPrice = pricePerTimestamp.get(timestamp);
            Set<Integer> prevPriceTimestamps = timestampsPerPrice.get(prevPrice);
            prevPriceTimestamps.remove(timestamp);
            if (prevPriceTimestamps.isEmpty()) {
                timestampsPerPrice.remove(prevPrice);
            }
        }
        pricePerTimestamp.put(timestamp, price);
        timestampsPerPrice.putIfAbsent(price, new HashSet<>());
        timestampsPerPrice.get(price).add(timestamp);
    }

    // O(logn) time
    public int current() {
        return pricePerTimestamp.lastEntry().getValue();
    }

    // O(logn) time
    public int maximum() {
        return timestampsPerPrice.lastKey();
    }

    // O(logn) time
    public int minimum() {
        return timestampsPerPrice.firstKey();
    }

    // Test
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);                   // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);                    // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());   // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());   // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);                    // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());   // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);                    // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());   // return 2, the minimum price is 2 at timestamp 4.
    }
}