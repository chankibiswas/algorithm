package com.example.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible generateSubsets (the power set).
The solution set must not contain duplicate generateSubsets. Return the solution in any order.
*
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class SubsetsOfIntegerArray {

    public static void main(final String[] s) {
        final int[] nums = {1, 2, 3, 4};
        final List<List<Integer>> subsets = subsets(nums);
        subsets.forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(final int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        final List<List<Integer>> subsets = new ArrayList<>();
        return generateSubsets(nums, 0, new ArrayList<>(), subsets);
    }

    // A simple solution where you include number at index or don't include
    private static List<List<Integer>> generateSubsets(final int[] nums, final int index,
                                                       final List<Integer> current,
                                                       final List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(current);
            return subsets;
        }
        generateSubsets(nums, index + 1, new ArrayList<>(current), subsets);
        final List<Integer> l2 = new ArrayList<>(current);
        l2.add(nums[index]);
        generateSubsets(nums, index + 1, l2, subsets);
        return subsets;
    }

}
