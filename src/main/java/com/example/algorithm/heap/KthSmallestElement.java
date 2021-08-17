package com.example.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the
given array. It is given that all array elements are distinct.
Example:
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7
 */
public class KthSmallestElement {

    public static void main(final String[] s) {
        final KthSmallestElement t = new KthSmallestElement();
        final int arr[] = {7, 10, 4, 3, 20, 15};
        final int k = 3;
        System.out.println(t.getKthSmallestElement(arr, k));
    }

    /*
    For finding Kth smallest element, we should use Max heap of size K.
    After everything, the Top element will be the Kth smallest element
     */
    private int getKthSmallestElement(final int[] arr, final int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
