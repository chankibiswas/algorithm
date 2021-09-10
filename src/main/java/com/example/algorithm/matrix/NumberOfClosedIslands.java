package com.example.algorithm.matrix;

/*
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a
closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
*
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
*
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 */
public class NumberOfClosedIslands {

    public static void main(final String[] st) {
        final int[][] grid = {
            {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
            {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        };
        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(final int[][] grid) {
        if (grid.length < 3) {
            return 0;
        }
        if (grid[0].length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    final boolean isIsland = applyDFS(grid, i, j);
                    if (isIsland) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    private static boolean applyDFS(final int[][] grid, final int i, final int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        if ((i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) && grid[i][j] == 0) {
            return false;
        }
        grid[i][j] = 1;
        if (applyDFS(grid, i + 1, j) && applyDFS(grid, i - 1, j) && applyDFS(grid, i, j + 1) && applyDFS(grid, i, j - 1)) {
            return true;
        } else {
            grid[i][j] = 0;
        }
        return false;
    }
}
