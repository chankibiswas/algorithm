package com.example.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the
number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
*
Input: time = [30,20,150,100,40]
Output: 3
*
Input: time = [60,60,60]
Output: 3
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(final int[] time) {
        final Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (final int i : time) {
            final int a = i % 60;
            final int b = (60 - a) % 60;
            if (map.containsKey(b)) {
                final int c = map.get(b);
                count += c;
            }
            final int m = map.getOrDefault(a, 0);
            map.put(a, m + 1);
        }
        return count;
    }
}
