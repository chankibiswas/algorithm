package com.example.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class PrintFirstNegativeIntegerInSubArray {

    public void printFirstNegativeInteger(final int arr[], final int k) {
        final List<Integer> lst = new ArrayList<>();
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                lst.add(j);
            }
            if (j - i + 1 == k) {
                if (lst.size() > 0) {
                    System.out.println(arr[lst.get(0)]);
                    if (lst.get(0) == i) {
                        lst.remove(0);
                    }
                } else {
                    System.out.println(0);
                }
                i++;
            }
        }
    }
}
