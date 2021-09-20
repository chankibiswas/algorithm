package com.example.algorithm.arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
*
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(final String[] s) {
        final int[] nums = {0, 4, 0};
        final int[] result = productExceptSelf(nums);
    }

    public static int[] productExceptSelf(final int[] nums) {
        final int length = nums.length;
        final int[] left = new int[length];
        final int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
