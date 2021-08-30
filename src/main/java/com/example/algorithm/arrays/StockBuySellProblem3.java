package com.example.algorithm.arrays;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class StockBuySellProblem3 {

    public static void main(final String[] s) {
        final int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        final StockBuySellProblem3 sp = new StockBuySellProblem3();
        System.out.println("Max profit for 2 transactions: " + sp.maxProfit(prices));
    }

    private int maxProfit(final int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } else {
            int firstBuy = Integer.MIN_VALUE;
            int secondBuy = Integer.MIN_VALUE;
            int firstSell = 0;
            int secondSell = 0;

            for (int i = 0; i < prices.length; i++) {
                firstBuy = Math.max(firstBuy, -prices[i]);
                firstSell = Math.max(firstSell, firstBuy + prices[i]);
                secondBuy = Math.max(secondBuy, firstSell - prices[i]);
                secondSell = Math.max(secondSell, secondBuy + prices[i]);
            }
            return secondSell;
        }
    }
}
