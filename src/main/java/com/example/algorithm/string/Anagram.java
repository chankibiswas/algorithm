package com.example.algorithm.string;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }
        char[] char1 = s.toCharArray();
        Arrays.sort(char1);
        char[] char2 = t.toCharArray();
        Arrays.sort(char2);
        return Arrays.equals(char1, char2);
    }
}
