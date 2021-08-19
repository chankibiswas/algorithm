package com.example.algorithm.stack;

/*
Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:
Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0
Output : 8 from  1 1 1 1
                 1 1 1 1
*
The trick here is to convert 2-D Matrix to 1-D Histogram.
Then calculate max areas coming in all histograms and return.
 */
public class MaximumAreaOfRectangleInBinaryMatrix {

    public static void main(final String[] s) {
        final int[][] arr = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println(new MaximumAreaOfRectangleInBinaryMatrix().getMaximumAreaOfRectangle(arr));
    }

    private int getMaximumAreaOfRectangle(final int[][] arr) {
        final int row = arr.length;
        if (row == 0) {
            return 0;
        }
        final int column = arr[0].length;
        int max = Integer.MIN_VALUE;
        final MaximumAreaHistogram mah = new MaximumAreaHistogram();

        final int[] oneDHistogram = new int[column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                final int item = arr[i][j];
                if (item == 0) {
                    oneDHistogram[j] = 0;
                } else {
                    oneDHistogram[j] = oneDHistogram[j] + item;
                }
            }
            final int maxHistogramArea = mah.getMaximumAreaOfHistogram(oneDHistogram);
            max = Math.max(max, maxHistogramArea);
        }
        return max;
    }
}
