package com.example.algorithm.heap;

import java.util.PriorityQueue;

/*
You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i]
is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the
sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.
*
Input: sticks = [2,4,3]
Output: 14
*
Input: sticks = [1,8,3,5]
Output: 30
Explanation: You start with sticks = [1,8,3,5].
1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks = [4,8,5].
2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks = [9,8].
3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks = [17].
There is only one stick left, so you are done. The total cost is 4 + 9 + 17 = 30.
*
Input: sticks = [5]
Output: 0
 */
public class MinimumCostToConnectSticks {

    public int connectSticks(final int[] sticks) {
        final PriorityQueue<Integer> pq = new PriorityQueue();
        for (final int i : sticks) {
            pq.add(i);
        }
        int count = 0;
        while (pq.size() > 1) {
            final int m = pq.poll();
            final int n = pq.poll();
            count += (m + n);
            pq.add(m + n);
        }
        return count;
    }
}
