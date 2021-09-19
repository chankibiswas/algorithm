package com.example.algorithm.trie;

public class Trie {

    private static final char SMALL_LETTER_START = 'a';
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(final String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            final int index = word.charAt(i) - SMALL_LETTER_START;
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.word = word;
    }

    public TrieNode getTrie() {
        return root;
    }
}
