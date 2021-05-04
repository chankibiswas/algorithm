package com.example.algorithm.binarysearch;

public class SearchInRotatedSortedArray {

    /*
    There is an integer array nums sorted in ascending order (with distinct values)
    Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
    such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]
    *
    Given the array nums after the rotation and an integer target, this method returns the index of target if it is in nums,
    or -1 if it is not in nums
     */
    public int searchInRotatedSortedArray(final int[] nums, final int target) {
        final int low = 0;
        final int high = nums.length - 1;
        if (nums[low] < nums[high]) {
            return binarySearch(nums, target, low, high);
        } else {
            final int pivotIndex = getPivotIndex(nums);
            final int res1 = binarySearch(nums, target, low, pivotIndex - 1);
            if (res1 != -1) {
                return res1;
            }
            final int res2 = binarySearch(nums, target, pivotIndex, high);
            if (res2 != -1) {
                return res2;
            }
        }
        return -1;
    }

    /*
    If a sorted array(having distinct elements) is rotated anticlockwise, this method gives the index of smallest element.
    Index+1 also gives the number of times array is rotated.
     */
    private int getPivotIndex(final int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return low;
            }
            mid = (low + high) / 2;
            final int i = (mid + nums.length - 1) % nums.length;
            final int j = (mid + 1) % nums.length;
            if (nums[mid] <= nums[i] && nums[mid] <= nums[j]) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                high = mid - 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    private int binarySearch(final int[] nums, final int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target == nums[low]) {
                return low;
            } else if (target == nums[high]) {
                return high;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
