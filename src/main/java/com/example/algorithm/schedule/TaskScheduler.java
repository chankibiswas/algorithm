package com.example.algorithm.schedule;

import java.util.Arrays;

/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete
either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in
the array), that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.
*
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
*
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
 */
public class TaskScheduler {

    public static void main(final String[] s) {
        final char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        final int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    /*
    1. Make a task counter
    2. Sort the counter array
    3. Take (max -1) to mark the intervals in between the maximum occurring task
    4. Subtract idleCount according the task counts
    5. Return count as per remaining idleCounts
     */
    public static int leastInterval(final char[] tasks, final int n) {
        final int[] taskCount = new int[26];
        for (final char c : tasks) {
            taskCount[c - 'A']++;
        }
        Arrays.sort(taskCount);

        final int maxCount = taskCount[25] - 1;
        int idleCount = maxCount * n;

        for (int i = 24; i >= 0; i--) {
            idleCount = idleCount - Math.min(taskCount[i], maxCount);
        }
        return idleCount > 0 ? (idleCount + tasks.length) : tasks.length;
    }
}











