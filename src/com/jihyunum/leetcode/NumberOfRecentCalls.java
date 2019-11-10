package com.jihyunum.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// [Problem] https://leetcode.com/problems/number-of-recent-calls/
class NumberOfRecentCalls {

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */

    class RecentCounter {
        Queue<Integer> pings;

        public RecentCounter() {
            pings = new LinkedList<>();
        }

        public int ping(int t) {
            pings.add(t);
            while (pings.peek() < t - 3000) {
                pings.poll();
            }
            return pings.size();
        }
    }

}
