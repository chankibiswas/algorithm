package com.example.algorithm.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the
 island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c]
represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent
 to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci)
 to both the Pacific and Atlantic oceans.
*
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
*
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(final int[][] heights) {
        final List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        final int row = heights.length;
        final int column = heights[0].length;
        final boolean[][] pacific = new boolean[row][column];
        final boolean[][] atlantic = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            dfs(i, 0, pacific, 0, heights);
            dfs(i, column - 1, atlantic, 0, heights);
        }
        for (int j = 0; j < column; j++) {
            dfs(0, j, pacific, 0, heights);
            dfs(row - 1, j, atlantic, 0, heights);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(final int i, final int j, final boolean[][] visited, final int previous, final int[][] heights) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) {
            return;
        }
        if (heights[i][j] < previous || visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        dfs(i + 1, j, visited, heights[i][j], heights);
        dfs(i - 1, j, visited, heights[i][j], heights);
        dfs(i, j + 1, visited, heights[i][j], heights);
        dfs(i, j - 1, visited, heights[i][j], heights);
    }

}
