package com.example.algorithm.topologySort;

import java.util.Arrays;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need
to remove to make the rest of the intervals non-overlapping.
*
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
*
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
*
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {

    public static void main(final String[] s) {
        final int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //final int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        //final int[][] intervals = {{1, 2}, {2, 3}};
        //final int[][] intervals = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        //final int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(final int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(intervals, (a, b) -> (a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]);
        int previousEnd = Integer.MIN_VALUE;
        for (final int[] interval : intervals) {
            if (previousEnd > interval[0]) {
                count++;
            } else {
                previousEnd = interval[1];
            }
        }
        return count;
    }
}
