package com.example.algorithm.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {

    public int countAnagrams(final String text, final String word) {
        final char[] textArr = text.toCharArray();
        final char[] wordArr = word.toCharArray();
        final Map<Object, Integer> m = new HashMap<>();
        int countCharacter = 0;
        int anagramCount = 0;
        for (int i = 0; i < wordArr.length; i++) {
            if (m.get(wordArr[i]) == null) {
                m.put(wordArr[i], 1);
                countCharacter++;
            } else {
                m.put(wordArr[i], m.get(wordArr[i]) + 1);
            }
        }
        final Set<Object> keySet = m.keySet();

        for (int i = 0, j = 0; i < textArr.length; i++) {
            if (keySet.contains(textArr[i])) {
                final int temp = m.get(textArr[i]);
                m.put(textArr[i], temp - 1);
                if (temp - 1 == 0) {
                    countCharacter--;
                }
            }
            if (i - j + 1 >= wordArr.length) {
                if (countCharacter == 0) {
                    anagramCount++;
                }
                if (keySet.contains(textArr[j])) {
                    final int temp = m.get(textArr[j]);
                    m.put(textArr[j], temp + 1);
                    if (temp == 0) {
                        countCharacter++;
                    }
                }
                j++;
            }
        }
        return anagramCount;
    }
}
