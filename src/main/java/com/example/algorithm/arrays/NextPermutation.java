package com.example.algorithm.arrays;

import java.util.Arrays;

public class NextPermutation {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
        -------------------------
        Algorithm:
        1. Compare nums[i] & nums[i-1]
        2. For i-1, find the next highest number's index
        3. Swap i-1 and next highest number index values
        4. Reverse the array now from index i
     */
    public void nextPermutation(final int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int j;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                final int nextHighestNumberIndex = findNextHighestNumberIndex(nums, i - 1);
                swap(nums, i - 1, nextHighestNumberIndex);
                reverseArray(nums, i, nums.length - 1);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private void reverseArray(final int[] nums, final int start, final int end) {
        int low = start;
        int high = end;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(final int[] nums, final int m, final int n) {
        nums[m] = nums[m] + nums[n];
        nums[n] = nums[m] - nums[n];
        nums[m] = nums[m] - nums[n];
    }

    private int findNextHighestNumberIndex(final int[] nums, final int m) {
        final int num = nums[m];
        int nextHighest = Integer.MAX_VALUE;
        int index = m + 1;
        for (int i = m + 1; i < nums.length; i++) {
            if (nums[i] > num && nums[i] <= nextHighest) {
                nextHighest = nums[i];
                index = i;
            }
        }
        return index;
    }
}
