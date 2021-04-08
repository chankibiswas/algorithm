package com.example.algorithm.slidingWindow;

public class MaxSumSubArray {

    public int getMaxSumSubArrayWithSizeK(final int[] a, final int k) {
        int maxSum = 0;
        int sum = 0;
        int startWindowIndex = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - a[startWindowIndex];
                startWindowIndex++;
            }
        }
        return maxSum;
    }
}
