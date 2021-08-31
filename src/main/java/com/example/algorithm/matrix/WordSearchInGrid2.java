package com.example.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once in a word.
*
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
*
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 */
public class WordSearchInGrid2 {

    public static void main(final String[] s) {
        /*final char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        final String[] words = {"oath", "pea", "eat", "rain"};*/
        final char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        final String[] words = {"oa", "oaa"};
        final WordSearchInGrid2 w = new WordSearchInGrid2();
        final List<String> result = w.findWords(board, words);
        result.forEach(System.out::println);
    }

    public List<String> findWords(final char[][] board, final String[] words) {
        if (words.length == 0 || board.length == 0) {
            return new ArrayList<>();
        }
        final List<String> result = new ArrayList<>();
        for (final String word : words) {
            if (searchWord(board, result, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean searchWord(final char[][] board, final List<String> result, final String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchWord(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
