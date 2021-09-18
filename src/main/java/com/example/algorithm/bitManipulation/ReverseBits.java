package com.example.algorithm.bitManipulation;

/*
Reverse bits of a given 32 bits unsigned integer.
*
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so
return 3221225471 which its binary representation is 10111111111111111111111111111111.
*

 */
public class ReverseBits {

    public static void main(final String[] s) {
        System.out.println(reverseBits(3));
    }

    /*
    Algo:
    1. Keep comparing the last bit with 1
    2. Slide result 1 position left at each iteration.
    3. Slide n 1 position right at each iteration
     */
    public static int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >> 1;
        }
        return result;
    }
}
