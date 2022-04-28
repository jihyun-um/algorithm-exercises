package javacode.solutions;

// [Problem] https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BestTimeToBuyAndSellStock {
    // Simple math
    // O(n) time, O(1) space
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0], maxProfit = 0;
        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // Test
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5
        int[] input = {7, 1, 5, 3, 6, 4};
        int expectedOutput = 5;
        int actualOutput = solution.maxProfit(input);

        System.out.println("Test passed? " + (expectedOutput == actualOutput));
    }
}
