package com.example.algorithm.sort;

/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending
order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.
*
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
*
Input: nums = [1,2,3,4]
Output: 0
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(final String[] s) {
        final int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(final int[] nums) {
        int end = -1;
        boolean sorted = true;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
                sorted = false;
            } else {
                max = nums[i];
            }
        }

        if (sorted) return 0;

        int start = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }
        return end - start + 1;
    }
}
