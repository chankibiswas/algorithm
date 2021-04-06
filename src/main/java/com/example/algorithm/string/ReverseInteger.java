package com.example.algorithm.string;

public class ReverseInteger {

    public int reverse(int x) {
        final boolean isNegative = x < 0;
        if (isNegative) {
            x = -1 * x;
        }
        int n = 0;
        int last = 0;
        while (x / 10 != 0) {
            n = (n * 10) + (x % 10);
            x = x / 10;
            if (n / 10 == last) {
                last = n;
            } else {
                return 0;
            }
        }
        n = (n * 10) + (x % 10);
        if (n / 10 != last) {
            return 0;
        }
        return isNegative ? (-1 * n) : n;
    }
}
