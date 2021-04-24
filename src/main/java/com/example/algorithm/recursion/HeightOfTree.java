package com.example.algorithm.recursion;

public class HeightOfTree {

    public int findHeightOfTree(final Tree root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeightOfTree(root.left), findHeightOfTree(root.right));
    }

    public class Tree {
        final int data;
        Tree left;
        Tree right;

        public Tree(final int data) {
            this.data = data;
        }
    }
}
