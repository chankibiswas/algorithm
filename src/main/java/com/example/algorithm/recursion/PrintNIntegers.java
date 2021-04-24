package com.example.algorithm.recursion;

public class PrintNIntegers {

    public void printUptoN(final int n) {
        if (n <= 0) {
            return;
        }
        printUptoN(n - 1);
        System.out.println(n);
    }
}
