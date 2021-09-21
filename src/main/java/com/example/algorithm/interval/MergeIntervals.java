package com.example.algorithm.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
the non-overlapping intervals that cover all the intervals in the input.
*
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    public static void main(final String[] s) {
        final int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {4, 5}};
        final int[][] result = merge(intervals);
        System.out.println(result);
    }

    public static int[][] merge(final int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        final List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        for (final int[] interval : intervals) {
            final int currentEnd = current[1];
            final int nextBegin = interval[0];
            final int nextEnd = interval[1];
            if (currentEnd >= nextBegin) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
