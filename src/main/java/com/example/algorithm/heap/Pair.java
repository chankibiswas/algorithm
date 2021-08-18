package com.example.algorithm.heap;

class Pair<T> implements Comparable<Pair> {

    private final T key;
    private final int value;

    Pair(final T key, final int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(final Pair pair) {
        return value - pair.value;
    }

    T getKey() {
        return key;
    }

    int getValue() {
        return value;
    }
}
