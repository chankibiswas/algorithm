package com.example.algorithm.stack;

import java.util.Stack;

/*
Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the right side of x in array.
Elements for which no greater element exist, consider next greater element as -1.
Time complexity - O(n)
Space complexity - O(n)
 */
public class NearestGreaterToRight {

    public static void main(final String[] s) {
        final int[] arr = {1, 3, 1, 0, 0, 2, 4};
        new NearestGreaterToRight().printNearestGreaterToRight(arr);
    }

    public void printNearestGreaterToRight(final int[] arr) {
        final int[] ans = new int[arr.length];
        final Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.empty()) {
                ans[i] = -1;
            } else if (!s.empty() && s.peek() > arr[i]) {
                ans[i] = s.peek();
            } else if (!s.empty() && s.peek() <= arr[i]) {
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                if (s.empty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = s.peek();
                }
            }
            s.push(arr[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
