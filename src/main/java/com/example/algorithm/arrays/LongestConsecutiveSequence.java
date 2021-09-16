package com.example.algorithm.arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
*
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class LongestConsecutiveSequence {

    public static void main(final String[] s) {
        final int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        final Set<Integer> numSet = new HashSet<>();
        for (final int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(nums[i] - 1)) {
                int count = 1;
                while (numSet.contains(nums[i] + count)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
