package com.example.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateNumbers {

    /*
    Given an integer array of length n where all the integers are in the range [1, n] and each integer appears once or twice
    Return an array of all the integers that appears twice
     */
    public List<Integer> findDuplicates(final int[] nums) {
        final List<Integer> n = new ArrayList<>();
        int i = 0;
        int j;
        while (i < nums.length) {
            j = nums[i] - 1;
            if (j >= 0 && j < nums.length && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (k + 1 != nums[k]) {
                n.add(nums[k]);
            }
        }
        return n;
    }

    private void swap(final int[] nums, final int i, final int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
