package com.example.algorithm.arrays;

public class RotateMatrix {

    public void rotateAntiClockWise(final int[][] matrix) {
        transpose(matrix);
        reverseArrayColumnWise(matrix);
    }

    public void rotateClockWise(final int[][] matrix) {
        transpose(matrix);
        reverseArrayRowWise(matrix);
    }

    private void reverseArrayColumnWise(final int[][] matrix) {
        int low, high;
        for (int i = 0; i < matrix.length; i++) {
            low = 0;
            high = matrix.length - 1;
            while (low < high) {
                matrix[low][i] = matrix[low][i] + matrix[high][i];
                matrix[high][i] = matrix[low][i] - matrix[high][i];
                matrix[low][i] = matrix[low][i] - matrix[high][i];
                low++;
                high--;
            }
        }
    }

    private void reverseArrayRowWise(final int[][] matrix) {
        int[] arr;
        int low, high;
        for (int i = 0; i < matrix.length; i++) {
            arr = matrix[i];
            low = 0;
            high = arr.length - 1;
            while (low < high) {
                arr[low] = arr[high] + arr[low];
                arr[high] = arr[low] - arr[high];
                arr[low] = arr[low] - arr[high];
                low++;
                high--;
            }
        }
    }

    private void transpose(final int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (i != j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
