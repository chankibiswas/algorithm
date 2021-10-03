package com.example.algorithm.bitManipulation;

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in
the binary representation of i.
*
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */
public class CountingBits {

    public int[] countBits(final int n) {
        final int[] result = new int[n + 1];
        if (n == 0) {
            return result;
        }
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
