package com.example.algorithm.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(final String[] s) {
        final KthLargestElement t = new KthLargestElement();
        final int arr[] = {7, 10, 4, 3, 20, 15};
        final int k = 3;
        System.out.println(t.getKthLargestElement(arr, k));
    }

    /*
    For finding Kth largest element, we should use Min heap of size K.
    After everything, the Top element will be the Kth largest element.
     */
    private int getKthLargestElement(final int[] arr, final int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
