package com.example.algorithm.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstringWithAllUniqueCharacters(final String s) {
        int max = 0;
        final Set<Object> charSet = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (charSet.contains(s.charAt(j))) {
                while (s.charAt(i) != s.charAt(j)) {
                    charSet.remove(s.charAt(i));
                    i++;
                }
                i++;
            } else {
                charSet.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
