package com.example.algorithm.route;

import com.example.algorithm.Test1;
import java.util.Arrays;
import java.util.Stack;

/*
There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and
 speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a
car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return the number of car fleets that will arrive at the destination.
*
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.
*
Input: target = 10, position = [3], speed = [3]
Output: 1
 */
public class CarFleet {

    public static void main(final String[] s) {
        final int target = 12;
        final int[] position = {10, 8, 0, 5, 3};
        final int[] speed = {2, 4, 1, 1, 3};
        System.out.println(new Test1().carFleet(target, position, speed));
    }

    public int carFleet(final int target, final int[] position, final int[] speed) {
        final int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, ((i, j) -> j[0] - i[0]));
        final Stack<Float> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            final float temp = ((float)(target - cars[i][0])) / (float)cars[i][1];
            if (stack.isEmpty() || stack.peek() < temp) {
                stack.push(temp);
            }
        }
        return stack.size();
    }
}
