package com.example.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, return the longest palindromic substring in s.
*
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 */
public class LongestPalindromeSubstring {

    private final Map<String, Boolean> dp = new HashMap<>();

    public static void main(final String[] st) {
        final String s = "babad";
        System.out.println(new LongestPalindromeSubstring().longestPalindrome(s));
    }

    private String longestPalindrome(final String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = s.length() - 1;
            boolean flag = false;
            int left = 0;
            int right = 0;

            while (l <= r) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (!flag) {
                        left = l;
                        right = r;
                    }
                    flag = true;
                    l++;
                    r--;
                } else {
                    if (flag)
                        r = right - 1;
                    else
                        r--;

                    flag = false;
                    l = i;
                }
            }
            if (flag) {
                final String str = s.substring(left, right + 1);
                if (result.length() < str.length())
                    result = str;
            }
        }
        return result;
    }

    private String longestPalindrome3(final String s) {
        if (s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        String res = "";
        int max = 0;

        final int[][] t = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            t[i][i] = 1;
            max = 1;
            res = s.substring(i, i + 1);
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                t[i - 1][i] = 1;
                max = 2;
                res = s.substring(i - 1, i + 1);
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                final String sub = s.substring(j - i, j + 1);
                if (sub.charAt(0) == sub.charAt(sub.length() - 1) && t[j - i + 1][j - 1] == 1) {
                    t[j - i][j] = 1;
                    if (sub.length() > max) {
                        max = sub.length();
                        res = sub;
                    }
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(final String s) {
        if (s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        String res = "";
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j + i <= s.length(); j++) {
                final String sub = s.substring(j, j + i);
                if (isPalindrome(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                        res = sub;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(final String s) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            dp.put(s, false);
            return false;
        }
        if (s.length() > 2) {
            final String sub = s.substring(1, s.length() - 1);
            if (dp.containsKey(sub) && dp.get(sub)) {
                dp.put(s, true);
            } else {
                dp.put(s, false);
            }
        } else {
            dp.put(s, true);
        }
        return dp.get(s);
    }
}
