package com.example.algorithm.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(final String[] s) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(6);
        pq.add(1);
        pq.add(11);
        pq.add(4);
        pq.add(20);
        System.out.println("Displaying elements in Min Heap");
        pq.forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("Now removing all items from Priority queue");
        final int initialSizeOfHeap = pq.size();
        for (int i = 0; i < initialSizeOfHeap; i++) {
            System.out.println(pq.poll());
        }
    }
}
