package com.example.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an unsorted array and two numbers x and k, find k closest values to x.
Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3
Output : {4, 7, 6} in any order is acceptable
 */
public class ClosestKNumbers {

    public static void main(final String[] s) {
        final int arr[] = {10, 2, 14, 4, 7, 6};
        final int x = 5;
        final int k = 3;
        new ClosestKNumbers().printKClosestNumbers(arr, x, k);
    }

    public void printKClosestNumbers(final int[] arr, final int x, final int k) {
        final PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(i, Math.abs(arr[i] - x)));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            System.out.println(arr[pq.poll().key]);
        }
    }

    private static class Pair implements Comparable<Pair> {

        private final int key;
        private final int value;

        Pair(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(final Pair pair) {
            return value - pair.value;
        }
    }
}
