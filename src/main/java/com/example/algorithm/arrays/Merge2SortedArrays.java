package com.example.algorithm.arrays;

public class Merge2SortedArrays {

    public static void main(final String[] args) {
        final Merge2SortedArrays m = new Merge2SortedArrays();
        final int[] arr1 = new int[]{10, 12};
        final int[] arr2 = new int[]{1, 2, 6, 8, 9};
        //m.merge2SortedArraysWithInsertionSort(arr1, arr2);
        m.merge2SortedArraysWithGapAlgorithm(arr1, arr2);
        System.out.println(arr1);
    }

    public void merge2SortedArraysWithGapAlgorithm(final int[] arr1, final int[] arr2) {
        final int m = arr1.length;
        final int n = arr2.length;
        if (m == 0 || n == 0) {
            return;
        }
        int gap = (int) Math.ceil(new Double(m + n) / 2);
        while (gap >= 1) {
            for (int i = 0; i + gap <= (m + n - 1); i++) {
                int firstIndex = -1, secondIndex = -1;
                final boolean firstArrFlag, secondArrFlag;
                if (i < m) {
                    firstArrFlag = true;
                    firstIndex = i;
                } else {
                    firstArrFlag = false;
                    firstIndex = i - m;
                }
                if (i + gap < m) {
                    secondIndex = i + gap;
                    secondArrFlag = false;
                } else {
                    secondIndex = i + gap - m;
                    secondArrFlag = true;
                }
                if (firstArrFlag) {
                    if (secondArrFlag) {
                        swapIfNecessary(arr1, firstIndex, arr2, secondIndex);
                    } else {
                        swapIfNecessary(arr1, firstIndex, arr1, secondIndex);
                    }
                } else {
                    swapIfNecessary(arr2, firstIndex, arr2, secondIndex);
                }
            }
            gap = nextGap(gap);
        }
    }

    private void swapIfNecessary(final int[] arr1, final int firstIndex, final int[] arr2, final int secondIndex) {
        if (arr1[firstIndex] > arr2[secondIndex]) {
            arr1[firstIndex] = arr1[firstIndex] + arr2[secondIndex];
            arr2[secondIndex] = arr1[firstIndex] - arr2[secondIndex];
            arr1[firstIndex] = arr1[firstIndex] - arr2[secondIndex];
        }
    }

    private int nextGap(final int gap) {
        if (gap == 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }

    public void merge2SortedArraysWithInsertionSort(final int[] arr1, final int[] arr2) {
        final int m = arr1.length;
        final int n = arr2.length;

        // Iterate through 2nd array to find proper place for each elements
        for (int i = n - 1; i >= 0; i--) {
            int j = m - 2;
            final int last = arr1[m - 1];
            for (; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
