package com.example.algorithm.stack.nearest;

import java.util.Stack;

/*
Given an array of integers, find the closest (not considering distance, but value) smaller on left of every element.
If an element has no smaller on the left side, print -1.
 */
public class NearestSmallerToLeft {

    public static void main(final String[] s) {
        final int[] arr = {1, 3, 1, 0, 0, 2, 4};
        new NearestSmallerToLeft().printNearestSmallerToLeft(arr);
    }

    private void printNearestSmallerToLeft(final int[] arr) {
        final Stack<Integer> stack = new Stack<>();
        final int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
