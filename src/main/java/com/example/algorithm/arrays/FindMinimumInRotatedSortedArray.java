package com.example.algorithm.arrays;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,
1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ...,
a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.
*
Input: nums = [3,4,5,1,2]
Output: 1
*
Input: nums = [4,5,6,7,0,1,2]
Output: 0
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(final String[] s) {
        final int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(final int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[low] <= nums[mid] && nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
