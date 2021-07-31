package com.example.algorithm.arrays;

public class CalculateTrappingRainWater {

    public int calculateRainWater(final int arr[]) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > leftMax) {
                    leftMax = arr[low];
                } else {
                    result += leftMax - arr[low];
                }
                low++;
            } else {
                if (arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    result += rightMax - arr[high];
                }
                high--;
            }
        }
        return result;
    }
}
