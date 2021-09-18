package com.example.algorithm.bitManipulation;

/*
Input would be normal integer.
The api will print bits in it.
 */
public class PrintBitsOfInteger {

    public static void main(final String[] s) {
        printBitsInInteger(4);
    }

    public static void printBitsInInteger(final int n) {
        for (int i = 31; i >= 0; i--) {
            final int mask = 1 << i;
            if ((n & mask) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }
}
