package com.example.algorithm.stack;

import java.util.Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of
contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
Example input: {6, 2, 5, 4, 5, 1, 6}
Output: 12
*
Here we find Nearest-Smaller-to-left and nearest-smaller-to-right arrays so as to find the width of any possible
rectangular block.
 */
public class MaximumAreaHistogram {

    public static void main(final String[] s) {
        final int[] arr = {6, 2, 5, 4, 5, 1, 6};
        final MaximumAreaHistogram max = new MaximumAreaHistogram();
        System.out.println(max.getMaximumAreaOfHistogram(arr));
    }

    public int getMaximumAreaOfHistogram(final int[] arr) {
        final int[] nearestSmallerToLeft = getNearestSmallerIndexToLeft(arr);
        final int[] nearestSmallerToRight = getNearestSmallerIndexToRight(arr);

        final int[] width = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            width[i] = nearestSmallerToRight[i] - nearestSmallerToLeft[i] - 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < width.length; i++) {
            max = Math.max(max, (width[i] * arr[i]));
        }
        return max;
    }

    private int[] getNearestSmallerIndexToRight(final int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        final int[] ans = new int[arr.length];
        // This small change here is to consider a block of 0 height to the right most in arr.length index.
        final int pseudoIndex = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = pseudoIndex;
            } else if (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = pseudoIndex;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }

    private int[] getNearestSmallerIndexToLeft(final int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        final int[] ans = new int[arr.length];
        // This small change here is to consider a block of 0 height to the left most in -1 index.
        final int pseudoIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                ans[i] = pseudoIndex;
            } else if (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = pseudoIndex;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
