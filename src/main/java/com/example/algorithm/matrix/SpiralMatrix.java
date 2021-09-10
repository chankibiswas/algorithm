package com.example.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
*
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(final String[] s) {
        final int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        final List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::println);
    }

    public static List<Integer> spiralOrder(final int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        final List<Integer> result = new ArrayList<>();
        final int total = matrix.length * matrix[0].length;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        while (result.size() < total) {
            for (int i = top; i <= right && result.size() < total; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && result.size() < total; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && result.size() < total; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && result.size() < total; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
