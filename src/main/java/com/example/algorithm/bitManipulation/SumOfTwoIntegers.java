package com.example.algorithm.bitManipulation;

/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
*
Input: a = 1, b = 2
Output: 3
*
Input: a = 2, b = 3
Output: 5
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            final int xor = a ^ b;
            final int carry = (a & b) << 1;
            a = xor;
            b = carry;
        }
        return a;
    }
}
