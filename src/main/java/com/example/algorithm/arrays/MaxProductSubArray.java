package com.example.algorithm.arrays;

/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and
return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.
*
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubArray {

    public static void main(final String[] s) {
        final int[] nums = {2, 3, -2, 4, 0, 8};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final int tempMax = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            max = tempMax;
            result = Math.max(max, result);
        }
        return result;
    }
}
