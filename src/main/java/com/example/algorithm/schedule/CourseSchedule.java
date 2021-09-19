package com.example.algorithm.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
*
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is
impossible.
 */
public class CourseSchedule {

    public static void main(final String[] s) {
        final int courseCount = 5;
        final int[][] prerequisites = {{0, 1}, {1, 0}};//{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        System.out.println(canFinish(courseCount, prerequisites));
    }

    public static boolean canFinish(final int numCourses, final int[][] prerequisites) {
        if (prerequisites.length == 0 || numCourses == 0) {
            return true;
        }
        final Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisiteMap.containsKey(prerequisites[i][0])) {
                prerequisiteMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                final List<Integer> temp = new ArrayList<>();
                temp.add(prerequisites[i][1]);
                prerequisiteMap.put(prerequisites[i][0], temp);
            }
        }

        final int[] visited = new int[numCourses];

        for (final Map.Entry<Integer, List<Integer>> entry : prerequisiteMap.entrySet()) {
            final boolean canVisit = dfs(prerequisiteMap, entry.getKey(), visited);
            if (!canVisit) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(final Map<Integer, List<Integer>> prerequisiteMap, final Integer current,
                               final int[] visited) {
        if (visited[current] == -1) {
            return false;
        }
        if (visited[current] == 1) {
            return true;
        }
        List<Integer> dependants = prerequisiteMap.get(current);
        if (!prerequisiteMap.containsKey(current)
            || (prerequisiteMap.containsKey(current) && dependants.isEmpty())) {
            return true;
        }

        visited[current] = -1;
        for (final Integer dependant : dependants) {
            if (!dfs(prerequisiteMap, dependant, visited)) {
                return false;
            }
        }
        visited[current] = 1;
        dependants = new ArrayList<>();
        return true;
    }
}
