package com.example.algorithm.trie;

public class TrieNode {

    public String word;

    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }

}
