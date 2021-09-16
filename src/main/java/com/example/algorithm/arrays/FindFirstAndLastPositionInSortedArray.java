package com.example.algorithm.arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*
Input: nums = [5,7,7,8,8,8,8,10], target = 8
Output: [3,6]
*
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*
Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPositionInSortedArray {

    public static void main(final String[] s) {
        final int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        final int target = 8;
        final int[] range = searchRange(nums, target);
    }

    public static int[] searchRange(final int[] nums, final int target) {
        final int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private static int findFirstPosition(final int[] nums, final int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    private static int findLastPosition(final int[] nums, final int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

}
