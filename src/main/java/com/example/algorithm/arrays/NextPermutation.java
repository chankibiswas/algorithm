package com.example.algorithm.arrays;

public class NextPermutation {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
        -------------------------
        Example - 1 3 5 4 2 -> 1 4 2 3 5
        -------------------------
        Algorithm:
        1. Traverse from the end and compare nums[i-1]>=nums[i]. This index will be the pivot.
            1 3 5 4 2 -  3 is the pivot
        2. Keeping the pivot, find the next highest number's index to pivot on the right side to it.
            1 3 5 4 2 - 4 is the next highest to 3
        3. Swap pivot and next highest number index values
            1 4 5 3 2
        4. Reverse the array now after pivot index
            1 4 2 3 5
     */
    public void nextPermutation(final int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i > 0) {
            final int nextHighestNumberIndex = findNextHighestNumberIndex(nums, i - 1);
            swap(nums, i - 1, nextHighestNumberIndex);
        }
        reverseArray(nums, i, nums.length - 1);
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
