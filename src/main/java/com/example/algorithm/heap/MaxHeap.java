package com.example.algorithm.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(final String[] s) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.asList(6, 1, 11, 4, 20));
        System.out.println("Displaying elements in Max Heap");
        pq.forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("Now removing all items from Priority queue");
        final int initialSizeOfHeap = pq.size();
        for (int i = 0; i < initialSizeOfHeap; i++) {
            System.out.println(pq.poll());
        }
    }
}
