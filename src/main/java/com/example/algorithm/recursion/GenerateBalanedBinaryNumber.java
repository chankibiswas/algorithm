package com.example.algorithm.recursion;

public class GenerateBalanedBinaryNumber {

    /*
    Problem statement - generate all binary numbers of n digits where every prefix has more or equal
    number of Ones than Zeros
    if n = 3
    111, 110, 101 should be the output
    *
    At any point, number of zeros should be more than Ones.
    So, 011, 001, 100, 010 can never be an output
     */
    public void balancedBinary(final int n) {
        final int ones = 0;
        final int zeros = 0;
        final String output = "";
        balancedBinary(output, ones, zeros, n);
    }

    private void balancedBinary(final String output, final int ones, final int zeros, final int n) {
        if (ones + zeros == n) {
            System.out.println(output);
            return;
        }
        if (ones <= n) {
            balancedBinary(output + "1", ones + 1, zeros, n);
        }
        if (ones > 0 && zeros < ones) {
            balancedBinary(output + "0", ones, zeros + 1, n);
        }
    }
}
