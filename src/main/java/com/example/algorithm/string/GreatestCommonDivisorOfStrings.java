package com.example.algorithm.string;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
*
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
*
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
*
Input: str1 = "LEET", str2 = "CODE"
Output: ""
*
Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(final String str1, final String str2) {
        final int l1 = str1.length();
        final int l2 = str2.length();
        final int m = Math.min(l1, l2);

        for (int i = m; i >= 1; i--) {
            if (l1 % i == 0 && l2 % i == 0 && check(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    private boolean check(final String str1, final String str2, final int len) {
        final String temp = str1.substring(0, len);
        for (int i = 0; i <= str1.length() - len; i = i + len) {
            if (!temp.equals(str1.substring(i, i + len))) {
                return false;
            }
        }
        for (int i = 0; i <= str2.length() - len; i = i + len) {
            if (!temp.equals(str2.substring(i, i + len))) {
                return false;
            }
        }
        return true;
    }
}
