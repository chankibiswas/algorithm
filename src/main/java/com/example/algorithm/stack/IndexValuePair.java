package com.example.algorithm.stack;

public class IndexValuePair {

    private int value;
    private int index;

    public IndexValuePair(final int index, final int value) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(final int index) {
        this.index = index;
    }
}
