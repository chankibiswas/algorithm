package com.example.algorithm.stack;

class IndexValuePair {

    private int value;
    private int index;

    IndexValuePair(final int index, final int value) {
        this.value = value;
        this.index = index;
    }

    int getValue() {
        return value;
    }

    void setValue(final int value) {
        this.value = value;
    }

    int getIndex() {
        return index;
    }

    void setIndex(final int index) {
        this.index = index;
    }
}
