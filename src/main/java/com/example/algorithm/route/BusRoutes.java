package com.example.algorithm.route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1
 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You
can travel between bus stops by buses only.
Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
*
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
*
Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1
 */
class BusRoutes {

    public static void main(final String[] s) {
        final int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        final int count = numBusesToDestination(routes, 1, 6);
        System.out.println(count);
    }

    public static int numBusesToDestination(final int[][] routes, final int source, final int target) {
        final int length = routes.length;
        final Map<Integer, List<Integer>> busStopMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                final List<Integer> busList = busStopMap.getOrDefault(routes[i][j], new ArrayList());
                busList.add(i);
                busStopMap.put(routes[i][j], busList);
            }
        }

        final Set<Integer> processedBus = new HashSet<>();
        final Set<Integer> processedStop = new HashSet<>();
        final LinkedList<Integer> stopQ = new LinkedList<>();

        int busCount = 0;
        stopQ.addLast(source);

        while (!stopQ.isEmpty()) {
            int size = stopQ.size();
            while (size-- > 0) {
                final int currentStop = stopQ.removeFirst();
                if (target == currentStop) {
                    return busCount;
                }
                processedStop.add(currentStop);
                final List<Integer> busList = busStopMap.get(currentStop);
                if (busList == null || busList.size() == 0) {
                    break;
                }
                for (final Integer bus : busList) {
                    if (processedBus.contains(bus)) {
                        continue;
                    }
                    final int[] stopList = routes[bus];
                    for (final int stop : stopList) {
                        if (processedStop.contains(stop)) {
                            continue;
                        }
                        stopQ.addLast(stop);
                        processedStop.add(stop);
                    }
                    processedBus.add(bus);
                }
            }
            busCount++;
        }
        return -1;
    }
}