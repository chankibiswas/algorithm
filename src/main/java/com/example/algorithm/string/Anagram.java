package com.example.algorithm.string;

import java.util.Arrays;

public class Anagram {

    /*
    When all the characters in s are there in t, and vice versa
     */
    public boolean isAnagram(final String s, final String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final char[] char1 = s.toCharArray();
        Arrays.sort(char1);
        final char[] char2 = t.toCharArray();
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}
