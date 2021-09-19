package com.example.algorithm.matrix;

import com.example.algorithm.trie.Trie;
import com.example.algorithm.trie.TrieNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private static final Set<String> result = new HashSet<>();

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
        if (board.length < 1 || words.length < 1) {
            return new ArrayList<>();
        }
        final Trie trie = new Trie();
        for (final String word : words) {
            trie.insert(word);
        }
        final TrieNode root = trie.getTrie();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(final char[][] board, final int i, final int j, final TrieNode root) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == '#') {
            return;
        }
        final char w = board[i][j];
        board[i][j] = '#';
        final TrieNode current = root.children[w - 'a'];
        if (current != null) {
            if (current.word != null) {
                result.add(current.word);
            }
            dfs(board, i + 1, j, current);
            dfs(board, i - 1, j, current);
            dfs(board, i, j + 1, current);
            dfs(board, i, j - 1, current);
        }
        board[i][j] = w;

    }

}
