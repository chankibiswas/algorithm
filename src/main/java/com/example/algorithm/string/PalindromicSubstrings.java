package com.example.algorithm.string;

/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
*
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
*
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {

    private int count = 0;

    public static void main(final String[] s) {
        System.out.println(new PalindromicSubstrings().countSubstrings("abc"));
    }

    public int countSubstrings(final String s) {
        for (int i = 0; i < s.length(); i++) {
            expandFromMiddle(s, i, i);
            expandFromMiddle(s, i, i + 1);
        }
        return count;
    }

    private void expandFromMiddle(final String s, int i, int j) {
        if (s.length() <= j) {
            return;
        }
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}
