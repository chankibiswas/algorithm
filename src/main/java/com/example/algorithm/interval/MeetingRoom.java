package com.example.algorithm.interval;

import java.util.Arrays;

/*
Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person
could attend all meetings.
For example,
Given [ [0, 30], [5, 10], [15, 20] ]
return false.
*
Given [ [7, 10], [2, 5] ]
return true.
 */
public class MeetingRoom {

    public static void main(final String[] s) {
        //final int[][] interval = {{0, 30}, {5, 10}, {15, 20}};
        final int[][] interval = {{13, 15}, {1, 13}};
        System.out.println(canAttendMeetings(interval));
    }

    public static boolean canAttendMeetings(final int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            final int currentEnd = current[1];
            final int[] next = intervals[i];
            if (currentEnd <= next[0]) {
                current = next;
            } else {
                return false;
            }
        }
        return true;
    }
}
