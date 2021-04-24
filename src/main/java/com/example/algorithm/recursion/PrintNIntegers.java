package com.example.algorithm.recursion;

public class PrintNIntegers {

    public void printFromOneToN(final int n) {
        if (n <= 0) {
            return;
        }
        printFromOneToN(n - 1);
        System.out.println(n);
    }

    public void printFromNToOne(final int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printFromNToOne(n - 1);
    }
}
