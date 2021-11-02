package com.example.algorithm.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as
many times as it shows in both arrays and you may return the result in any order.
*
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
*
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */
public class IntersectionOfTwoArrays2 {

    public int[] intersect(final int[] nums1, final int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        final Map<Integer, Integer> countMap;
        if (nums1.length < nums2.length) {
            countMap = getCountMap(nums1);
            return getIntersection(nums2, countMap);
        } else {
            countMap = getCountMap(nums2);
            return getIntersection(nums1, countMap);
        }
    }

    private int[] getIntersection(final int[] nums, final Map<Integer, Integer> countMap) {
        final List<Integer> result = new ArrayList<>();
        for (final int num : nums) {
            if (countMap.containsKey(num)) {
                result.add(num);
                int c = countMap.get(num);
                if (c == 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, --c);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private Map<Integer, Integer> getCountMap(final int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (final int num : nums) {
            final int c = countMap.getOrDefault(num, 0);
            countMap.put(num, c + 1);
        }
        return countMap;
    }
}
