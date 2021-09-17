package com.example.algorithm.slidingWindow;

public class MaxSumSubArray {

    public static void main(final String[] s) {
        final int[] nums = {-5, 4, 6, -3, 4, -1};
        System.out.println(getMaxSumSubArray(nums));
        System.out.println(getMaxSumSubArrayWithSizeK(nums, 3));
    }

    /*
    Fixed size window problem
     */
    public static int getMaxSumSubArrayWithSizeK(final int[] a, final int k) {
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

    public static int getMaxSumSubArray(final int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = current + nums[i];
            max = Math.max(max, current);
            current = Math.max(current, 0);
        }
        return max;
    }
}
