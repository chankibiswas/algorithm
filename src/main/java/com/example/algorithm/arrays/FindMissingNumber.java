package com.example.algorithm.arrays;

public class FindMissingNumber {

    /*
    Find first positive missing number.
    Array is unsorted.
    **
    The same algorithm can be used to find all missing and duplicate numbers
     */
    public int firstMissingPositive(final int[] nums) {
        int i = 0;
        int j;
        while (i < nums.length) {
            j = nums[i] - 1;
            if ((j >= 0 && j < nums.length) && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return k + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(final int[] nums, final int i, final int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
