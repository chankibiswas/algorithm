package com.example.algorithm.heap;

import java.util.PriorityQueue;

/*
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that
sorts in O(n log k) time.
Example:
Input : arr[] = {6, 5, 3, 2, 12, 10, 9}
k = 4
Output : arr[] = {2, 3, 5, 6, 9, 10, 12}
 */
public class SortKSortedArray {

    public static void main(final String[] s) {
        final SortKSortedArray ks = new SortKSortedArray();
        final int[] arr1 = {6, 5, 4, 2, 1, 13, 11, 8};
        ks.sortKSortedArrayWithPriorityQueue(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        final int[] arr2 = {6, 5, 4, 2, 1, 17, 11, 9};
        ks.sortKSortedArrayWithoutExtraSpace(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    private void sortKSortedArrayWithoutExtraSpace(final int[] arr) {
        int k = 1;
        for (int i = 0; i < arr.length - 1 && arr[i] > arr[i + 1]; i++) {
            k++;
        }
        int i = 0;
        int j = k - 1;
        for (; j < arr.length; j = j + k) {
            reverseArray(arr, i, j);
            i = j + 1;
        }
        if (i != arr.length) {
            reverseArray(arr, i, arr.length - 1);
        }
    }

    private void reverseArray(final int[] arr, final int i, final int j) {
        int high = j;
        int low = i;
        while (low < high) {
            final int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
        }
    }

    public void sortKSortedArrayWithPriorityQueue(final int[] arr) {
        int k = 1;
        for (int i = 0; i < arr.length - 1 && arr[i] > arr[i + 1]; i++) {
            k++;
        }

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                arr[j] = pq.poll();
                j++;
            }
        }
        int rem = pq.size();
        while (rem > 0) {
            arr[j] = pq.poll();
            j++;
            rem--;
        }
    }
}
