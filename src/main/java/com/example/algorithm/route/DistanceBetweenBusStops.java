package com.example.algorithm.route;

/*
A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops
where distance[i] is the distance between the stops number i and (i + 1) % n.
The bus goes along both directions i.e. clockwise and counterclockwise.
Return the shortest distance between the given start and destination stops.
*
Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
*
Input: distance = [1,2,3,4], start = 0, destination = 2
Output: 3
Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
*
Input: distance = [1,2,3,4], start = 0, destination = 3
Output: 4
Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 */
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(final int[] distance, final int start, final int destination) {
        if (start == destination) {
            return 0;
        }
        if (distance.length == 0) {
            return 0;
        }
        int dist = 0;
        int totalDist = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start < destination && i >= start && i < destination) {
                dist += distance[i];
            } else if (start > destination && (i >= start || i < destination)) {
                dist += distance[i];
            }
            totalDist += distance[i];
        }
        return Math.min(dist, totalDist - dist);
    }
}
