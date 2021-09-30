package com.example.algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and
the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*
*
This method is better than FindMedianFromDataStream2
 */
public class FindMedianFromDataStream {

    private final PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> largeHeap = new PriorityQueue<>();

    public static void main(final String[] s) {
        final FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(3);
        f.addNum(2);
        f.addNum(7);
        //f.addNum(5);
        System.out.println(f.findMedian());
    }

    public void addNum(final int num) {
        smallHeap.add(num);
        if (smallHeap.size() - largeHeap.size() > 1) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() > 0 && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian() {
        final int i = smallHeap.size();
        final int j = largeHeap.size();
        if (i == j || i + j % 2 == 0) {
            return ((double)(smallHeap.peek() + largeHeap.peek())) / 2;
        } else {
            if (i < j) {
                return largeHeap.peek();
            } else {
                return smallHeap.peek();
            }
        }
    }
}
