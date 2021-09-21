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
        final Interval[] intervals = {new Interval(7, 10), new Interval(2, 5), new Interval(3, 6)};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(final Interval[] intervals) {
        if (intervals.length == 0) {
            return false;
        }
        if (intervals.length == 1) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        Interval current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            final int currentEnd = current.end;
            final Interval next = intervals[i];
            if (currentEnd < next.start) {
                current = next;
            } else {
                return false;
            }
        }
        return true;
    }
}
