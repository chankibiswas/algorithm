package com.example.algorithm.arrays;

/*
This current algo doesn't work for all inputs. I'll be rectifying this in future.
*
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume
of water it can trap after raining.
https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class RainWaterTrappingIn2DMatrix {

    public static void main(final String[] s) {
        //final int[][] height = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        final int[][] height = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        final RainWaterTrappingIn2DMatrix r = new RainWaterTrappingIn2DMatrix();
        System.out.println(r.getRainWaterIn2DMatrix(height));
    }

    private int getRainWaterIn2DMatrix(final int[][] height) {
        final int row = height.length;
        if (row < 3) {
            return 0;
        }
        final int column = height[0].length;

        final int[][] maxLeft = new int[row][column];
        final int[][] maxRight = new int[row][column];
        final int[][] maxBottom = new int[row][column];
        final int[][] maxTop = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    maxLeft[i][j] = height[i][j];
                } else {
                    maxLeft[i][j] = Math.max(maxLeft[i][j - 1], height[i][j]);
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (j == column - 1) {
                    maxRight[i][j] = height[i][j];
                } else {
                    maxRight[i][j] = Math.max(maxRight[i][j + 1], height[i][j]);
                }
            }
        }

        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    maxBottom[i][j] = height[i][j];
                } else {
                    maxBottom[i][j] = Math.max(maxBottom[i - 1][j], height[i][j]);
                }
            }
        }

        for (int j = column - 1; j >= 0; j--) {
            for (int i = row - 1; i >= 0; i--) {
                if (i == row - 1) {
                    maxTop[i][j] = height[i][j];
                } else {
                    maxTop[i][j] = Math.max(maxTop[i + 1][j], height[i][j]);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                sum = sum
                      + Math.min(Math.min(maxLeft[i][j], maxRight[i][j]), Math.min(maxBottom[i][j], maxTop[i][j]))
                      - height[i][j];
            }
        }
        return sum;
    }

}
