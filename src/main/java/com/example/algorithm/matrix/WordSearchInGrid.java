package com.example.algorithm.matrix;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class WordSearchInGrid {

    public static void main(final String[] s) {
        final char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        final String word = "ABCCED";
        final WordSearchInGrid w = new WordSearchInGrid();
        System.out.println(w.exist(board, word));
    }

    public boolean exist(final char[][] board, final String word) {
        if (word.length() == 0 || board.length == 0) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = searchWord(board, i, j, 0, word);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return res;
    }

    private boolean searchWord(final char[][] board, final int i, final int j, final int index, final String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        final char temp = board[i][j];
        board[i][j] = ' ';
        final boolean result = searchWord(board, i + 1, j, index + 1, word)
                               || searchWord(board, i, j + 1, index + 1, word)
                               || searchWord(board, i - 1, j, index + 1, word)
                               || searchWord(board, i, j - 1, index + 1, word);
        board[i][j] = temp;
        return result;
    }
}
