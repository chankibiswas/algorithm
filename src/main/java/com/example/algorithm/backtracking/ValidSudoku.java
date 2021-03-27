package com.example.algorithm.backtracking;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
    Easiest coding, but not very efficient
     */
    public boolean isValidSudoku1(final char[][] board) {
        final Set<String> sudoku = new HashSet<>();
        final String inRow = " in row ";
        final String inColumn = " in column ";
        final String inGrid = " in grid ";
        final String separator = "-";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!sudoku.add(board[i][j] + inRow + i)
                            || !sudoku.add(board[i][j] + inColumn + j)
                            || !sudoku.add(board[i][j] + inGrid + i / 3 + separator + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
