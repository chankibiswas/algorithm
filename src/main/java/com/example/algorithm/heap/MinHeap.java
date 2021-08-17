package com.example.algorithm.heap;

import java.util.PriorityQueue;

public class MinHeap {

    public static void main(final String[] s) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
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
