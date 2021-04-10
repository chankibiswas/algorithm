package com.example.algorithm.slidingWindow;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxInsideSubArray {

    /*
    Finds max in sub-array using DeQue
    This is much more efficient than the second algo
    */
    public int[] maxSlidingWindow1(final int[] nums, final int k) {
        final int[] res = new int[nums.length - k + 1];
        final Deque<Integer> q = new LinkedList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (!q.isEmpty() && nums[j] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.add(j);

            if (j - i + 1 >= k) {
                res[i] = nums[q.peekFirst()];
                q.remove(i);
                i++;
            }
        }
        return res;
    }

    /*
    Finds max in sub-array using Priority Queue
    */
    public int[] maxSlidingWindow2(final int[] nums, final int k) {
        final int[] res = new int[nums.length - k + 1];
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; j < nums.length; j++) {
            pq.add(nums[j]);
            if (j - i + 1 >= k) {
                res[i] = pq.peek();
                pq.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}
