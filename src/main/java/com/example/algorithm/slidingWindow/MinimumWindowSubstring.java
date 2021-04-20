package com.example.algorithm.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

    /*
    Gives minimum substring
    All characters present in t, has to be there in minimum substring
    1. First expand the window by pointer j
    2. Then contract the window by pointer i
     */
    public String minimumWindow(final String s, final String t) {
        String str = "";
        if (t.length() > s.length()) {
            return str;
        }
        final Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.keySet().contains(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        final Set keySet = map.keySet();
        int count = keySet.size();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (keySet.contains(s.charAt(j))) {
                final int temp = map.get(s.charAt(j));
                map.put(s.charAt(j), temp - 1);
                if (temp - 1 == 0) {
                    count--;
                }
            }
            if (count == 0) {
                if (str == "" || (str != "" && str.length() >= j - i + 1)) {
                    str = s.substring(i, j + 1);
                }
                while (count == 0) {
                    if (keySet.contains(s.charAt(i))) {
                        final int temp = map.get(s.charAt(i));
                        map.put(s.charAt(i), temp + 1);
                        if (temp + 1 > 0) {
                            count++;
                        }
                    }
                    i++;
                    if (count == 0) {
                        if (str == "" || (str != "" && str.length() >= j - i + 1)) {
                            str = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return str;
    }
}
