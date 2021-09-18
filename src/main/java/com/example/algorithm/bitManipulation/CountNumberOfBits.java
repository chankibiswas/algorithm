package com.example.algorithm.bitManipulation;

/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
*
Input: n = 11 (i.e. 00000000000000000000000000001011)
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
*
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
public class CountNumberOfBits {

    public static void main(final String[] s) {
        System.out.println(hammingWeight(5));
    }

    public static int hammingWeight(final int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask<<1;
        }
        return count;
    }
}
