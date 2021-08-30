package com.example.algorithm.arrays;

import java.util.Arrays;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and
sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class StockBuySellProblem4 {

    public static void main(final String[] s) {
        final int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        final StockBuySellProblem4 sp = new StockBuySellProblem4();
        System.out.println("Max profit for 2 transactions: " + sp.maxProfit(prices, 4));
    }

    private int maxProfit(final int[] prices, final int k) {
        if (prices.length <= 1 || k < 1) {
            return 0;
        } else if (prices.length > 1 && k / 2 >= prices.length) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i - 1] < prices[i]) {
                    max = max + (prices[i] - prices[i - 1]);
                }
            }
            return max;
        } else {
            final int[] buy = new int[k];
            final int[] sell = new int[k];
            Arrays.fill(buy, Integer.MIN_VALUE);
            Arrays.fill(sell, 0);
            for (int i = 0; i < prices.length; i++) {
                for (int j = 0; j < k; j++) {
                    buy[j] = Math.max(buy[j], j == 0 ? -prices[i] : sell[j - 1] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                }
            }
            return sell[k - 1];
        }
    }
}
