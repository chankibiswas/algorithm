package com.example.algorithm.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchInMaze {

    private static boolean canTraverse(final Coordinate node, final List<List<Color>> maze) {
        return node.row >= 0 && node.row < maze.size() &&
                node.col >= 0 && node.col < maze.get(node.row).size() &&
                maze.get(node.row).get(node.col) == Color.WHITE;
    }

    public List<Coordinate> findPath(final List<List<Color>> maze, final Coordinate start, final Coordinate end) {
        final List<Coordinate> path = new ArrayList<>();
        maze.get(start.row).set(start.col, Color.BLACK);
        path.add(start);
        if (!hasPathToEnd(maze, start, end, path)) {
            path.remove(path.size() - 1);
        }
        return path;
    }

    private boolean hasPathToEnd(final List<List<Color>> maze, final Coordinate node, final Coordinate end, final List<Coordinate> path) {
        if (node.equals(end)) {
            return true;
        }

        final int[][] SHIFTS = {
                {0, 1}, // going right
                {1, 0}, // going down
                {0, -1}, // going left
                {-1, 0} // going up`
        };

        for (final int[] shift : SHIFTS) {
            final Coordinate next = new Coordinate(node.row + shift[0], node.col + shift[1]);
            if (canTraverse(next, maze)) {
                maze.get(next.row).set(next.col, Color.BLACK);
                path.add(next);
                if (hasPathToEnd(maze, next, end, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private enum Color {WHITE, BLACK}

    public static class Coordinate {
        public int row, col;

        public Coordinate(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Coordinate that = (Coordinate) o;
            if (row != that.row || col != that.col) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
