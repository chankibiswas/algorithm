package com.example.algorithm.heap;

class Pair implements Comparable<Pair> {

    private final int key;
    private final int value;

    Pair(final int key, final int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(final Pair pair) {
        return value - pair.value;
    }

    int getKey() {
        return key;
    }
}
