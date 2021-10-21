package com.example.algorithm.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose
the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*
Input: stones = [2,7,4,1,8,1]
Output: 1
*
Input: stones = [1]
Output: 1
*
Input: stones = [2, 2]
Output: 0
 */
public class LastStoneWeight {

    public int lastStoneWeight(final int[] stones) {
        final PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (final int i : stones) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            final int x = pq.poll();
            final int y = pq.poll();
            if (x > y) {
                pq.add(x - y);
            }
        }
        if (pq.size() == 1) {
            return pq.poll();
        } else {
            return 0;
        }
    }
}
