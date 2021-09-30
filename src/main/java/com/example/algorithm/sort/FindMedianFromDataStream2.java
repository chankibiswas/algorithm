package com.example.algorithm.sort;

import java.util.LinkedList;

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
This method is lesser efficient than FindMedianFromDataStream
 */
public class FindMedianFromDataStream2 {

    private final LinkedList<Integer> l = new LinkedList();

    public static void main(final String[] s) {
        final FindMedianFromDataStream2 f = new FindMedianFromDataStream2();
        f.addNum(3);
        f.addNum(2);
        f.addNum(7);
        f.addNum(5);
        System.out.println(f.findMedian());
    }

    public void addNum(final int num) {
        int i = 0;
        for (; i < l.size(); i++) {
            if (l.get(i) > num) {
                break;
            }
        }
        l.add(i, num);
    }

    public double findMedian() {
        final int len = l.size();
        if (len % 2 == 0) {
            return ((double)l.get(len / 2 - 1) + l.get(len / 2)) / 2;
        } else {
            return l.get(len / 2);
        }
    }

}
