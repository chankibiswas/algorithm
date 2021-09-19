package com.example.algorithm.schedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
If it is impossible to finish all courses, return an empty array.
*
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both
courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */
public class CourseSchedule2 {

    private static final Set<Integer> result = new LinkedHashSet<>();

    public static void main(final String[] s) {
        final int courseCount = 5;
        final int[][] prerequisites = {{1, 0}};//{0, 2}, {1, 3}, {1, 4}, {3, 4}};
        final int[] order = findOrder(courseCount, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    public static int[] findOrder(final int numCourses, final int[][] prerequisites) {
        if (prerequisites.length == 0) {
            final int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
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
                return new int[0];
            } else {
                result.add(entry.getKey());
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
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
            } else {
                result.add(dependant);
            }
        }
        visited[current] = 1;
        dependants = new ArrayList<>();
        return true;
    }
}
