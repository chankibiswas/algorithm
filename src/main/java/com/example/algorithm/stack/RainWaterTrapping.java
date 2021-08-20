package com.example.algorithm.stack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
Input: arr[] = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[] = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_|
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2
and 4.  See below diagram also.
Refer : https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class RainWaterTrapping {

    public static void main(final String[] s) {
        final int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(new RainWaterTrapping().getMaximumRainWater(arr));
    }

    /*
    We need to find a max element to right and left.
    Rain water will be sum of min(maxLeft, maxRight) - arr[i]
     */
    private int getMaximumRainWater(final int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        final int[] maxRight = new int[arr.length];
        final int[] maxleft = new int[arr.length];

        maxRight[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxRight[i] = Math.max(maxRight[i - 1], arr[i]);
        }

        maxleft[maxleft.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxleft[i] = Math.max(maxleft[i + 1], arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + Math.min(maxleft[i], maxRight[i]) - arr[i];
        }
        return sum;
    }
}
