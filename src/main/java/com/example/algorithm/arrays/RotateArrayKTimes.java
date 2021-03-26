package com.example.algorithm.arrays;

public class RotateArrayKTimes {

    public void rotate(final int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(final int[] nums, final int start, final int end) {
        int low = start;
        int high = end;
        while (low < high) {
            nums[low] = nums[low] + nums[high];
            nums[high] = nums[low] - nums[high];
            nums[low] = nums[low] - nums[high];
            low++;
            high--;
        }
    }
}
