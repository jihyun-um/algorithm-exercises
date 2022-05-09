package solutions;

import java.util.HashMap;
import java.util.Map;

// [Problem] https://leetcode.com/problems/logger-rate-limiter
class Logger {
    Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    // O(1) time, O(m) space where m = number of messages
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer previousTimestamp = messageTimestamps.get(message);
        if (previousTimestamp == null || timestamp >= previousTimestamp + 10) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }

    // test
    public static void main(String[] args) {
        Logger logger = new Logger();

        System.out.println("Test1 passed? " + (logger.shouldPrintMessage(1, "foo") == true));
        System.out.println("Test2 passed? " + (logger.shouldPrintMessage(2, "bar") == true));
        System.out.println("Test3 passed? " + (logger.shouldPrintMessage(3, "foo") == false));
        System.out.println("Test4 passed? " + (logger.shouldPrintMessage(8, "bar") == false));
        System.out.println("Test5 passed? " + (logger.shouldPrintMessage(10, "foo") == false));
        System.out.println("Test6 passed? " + (logger.shouldPrintMessage(11, "foo") == true));
    }
}
