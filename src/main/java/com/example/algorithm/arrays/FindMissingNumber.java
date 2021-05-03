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

    /*
    Given array is of positive integers sorted in a strictly increasing order
    k is a positive integer
    Find the kth positive integer that is missing from this array
     */
    public int findKthPositive(final int[] arr, final int k) {
        int i = 1;
        int j = 0;
        int count = 0;
        while (j <= arr.length) {
            if (j == arr.length || arr[j] != i) {
                count++;
                if (count == k) {
                    return i;
                }
            } else {
                j++;
            }
            i++;
        }
        return arr.length + k;
    }
}
