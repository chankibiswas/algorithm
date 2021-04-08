package com.example.algorithm.string;

public class StringPalindrome {

    public boolean isPalindrome(final String s) {
        final char[] c = s.toLowerCase().toCharArray();
        int low = 0;
        int high = c.length - 1;
        while (low < high) {
            while (low < high && !((c[low] >= 'a' && c[low] <= 'z') || (c[low] >= '0' && c[low] <= '9'))) {
                low++;
            }
            while (low < high && !((c[high] >= 'a' && c[high] <= 'z') || (c[high] >= '0' && c[high] <= '9'))) {
                high--;
            }
            if (c[low] != c[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
