package com.example.algorithm.string;

public class LongestCommonPrefix {

    /*
    Get the longest common prefix in array of strings
     */
    public String longestCommonPrefix(final String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        boolean breakCondition = false;
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            final char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    breakCondition = true;
                    break;
                }
            }
            if (breakCondition) {
                break;
            }
            ++count;
        }
        return strs[0].substring(0, count);
    }
}
