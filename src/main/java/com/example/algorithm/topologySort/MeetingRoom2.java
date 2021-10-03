package com.example.algorithm.topologySort;

import java.util.Arrays;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number
of conference rooms required.
*
For example,
Given [ [0, 30], [5, 10], [15, 20] ]
return 2
 */
public class MeetingRoom2 {

    public static void main(final String[] s) {
        final int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(final int[][] intervals) {
        if(intervals.length<=1) {
            return intervals.length;
        }
        final int[] start = new int[intervals.length];
        final int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int maxCount = 0;
        int count = 0;
        int i = 0, j = 0;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
