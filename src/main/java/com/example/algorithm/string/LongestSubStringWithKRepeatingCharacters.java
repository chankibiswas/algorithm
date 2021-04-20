package com.example.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithKRepeatingCharacters {

    /*
    Longest sub-string with atleast K repeating characters
     */
    public int longestSubstring(final String s, final int k) {
        int max = 0;
        if (s.length() < k) {
            return 0;
        }
        final Map<Object, Integer> m = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (m.get(s.charAt(j)) != null) {
                m.put(s.charAt(j), m.get(s.charAt(j)) + 1);
            } else {
                m.put(s.charAt(j), 1);
            }
        }
        final Set<Object> set = new HashSet<>();
        for (final Map.Entry<Object, Integer> e : m.entrySet()) {
            if (e.getValue() < k) {
                set.add(e.getKey());
            }
        }
        if (set.size() == 0) {
            return s.length();
        }
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (i - last - 1 >= k) {
                    max = Math.max(max, longestSubstring(s.substring(last + 1, i), k));
                }
                last = i;
            }
        }
        if (last != s.length() - 1) {
            max = Math.max(max, longestSubstring(s.substring(last + 1, s.length()), k));
        }
        return max;
    }
}
