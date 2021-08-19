package com.example.algorithm.stack;

import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to
calculate span of stock’s price for all n days.
The span S[i] of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the
given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example: if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*
If you examine this problem closely then you will find we are examining elements that are in left side and trying to find
an element that is greater than the current one. So, this problem will be solved by Nearest-Greater-to-Left algorithm.
*
https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpanProblem {

    public static void main(final String[] s) {
        final int[] arr = {100, 80, 60, 70, 60, 75, 85};
        new StockSpanProblem().printStockSpan(arr);
    }

    public void printStockSpan(final int[] arr) {
        final Stack<IndexValuePair> stack = new Stack<>();
        final int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (!stack.isEmpty() && stack.peek().getValue() > arr[i]) {
                ans[i] = stack.peek().getIndex();
            } else if (!stack.isEmpty() && stack.peek().getValue() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek().getValue() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek().getIndex();
                }
            }
            stack.push(new IndexValuePair(i, arr[i]));
        }
        // This change is to add that particular day as well
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i - ans[i];
            System.out.println(ans[i]);
        }
    }

}
