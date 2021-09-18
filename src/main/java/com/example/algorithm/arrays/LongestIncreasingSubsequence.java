package com.example.algorithm.arrays;

import java.util.Arrays;

/*
Given an integer array nums, return the length of the longest strictly increasing sub-sequence.
A sub-sequence is a sequence that can be derived from an array by deleting some or no elements without changing the order
of the remaining elements. For example, [3,6,2,7] is a sub-sequence of the array [0,3,1,6,2,2,7].
*
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing sub-sequence is [2,3,7,101], therefore the length is 4.
*
Input: nums = [0,1,0,3,2,3]
Output: 4
*
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
public class LongestIncreasingSubsequence {

    public static void main(final String[] s) {
        final int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longestIncreasingSubSequence(nums));
    }

    public static int longestIncreasingSubSequence(final int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i =1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 1;
        for(int i: dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
