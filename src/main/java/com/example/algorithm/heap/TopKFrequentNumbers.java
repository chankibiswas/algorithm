package com.example.algorithm.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an array of n numbers.
We basically need to print top k numbers sorted by
frequency when input stream has included at-least k distinct elements,
else need to print all distinct elements sorted by frequency.
Output can be any order.
 */
public class TopKFrequentNumbers {

    public static void main(final String[] s) {
        final int[] arr = {2, 1, 3, 1, 1, 1, 6, 11, 6, 6, 3, 3, 3, 3, 5};
        final int k = 3;
        final TopKFrequentNumbers t = new TopKFrequentNumbers();
        t.printTopKFrequentNumbers(arr, k);
    }

    private void printTopKFrequentNumbers(final int[] arr, final int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                final int freq = map.get(arr[i]);
                map.put(arr[i], freq + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        final PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll().getKey());
        }
    }
}
