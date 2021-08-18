package com.example.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given a list of points on the 2-D plane and an integer K.
The task is to find K closest points to the origin and print them.
Note: The distance between two points on a plane is the Euclidean distance.
Example:
Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2
 */
public class ClosestKPoints {

    public static void main(final String[] s) {
        final int[][] points = {{3, 3}, {5, -1}, {-2, 4}, {2, 1}, {-2, -3}, {3, -4}, {-4, 6}};
        final int k = 2;
        final ClosestKPoints c = new ClosestKPoints();
        c.printClosestKPoints(points, k);
    }

    private void printClosestKPoints(final int[][] points, final int k) {
        final PriorityQueue<Pair<Pair<Integer>>> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < points.length; i++) {
            final int x = points[i][0];
            final int y = points[i][1];
            pq.add(new Pair<>(new Pair<>(x, y), ((x * x) + (y * y))));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++) {
            final Pair<Pair<Integer>> p = pq.poll();
            System.out.println(p.getKey().getKey() + " " + p.getKey().getValue());
        }
    }
}
