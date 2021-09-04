package com.example.algorithm.dictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one
character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no
answer, return the empty string.
*
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
*
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is
lexicographically smaller than "apply".
 */
public class LongestWordInDictionary {

    public static void main(final String[] s) {
        final String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        final LongestWordInDictionary l = new LongestWordInDictionary();
        System.out.println(l.longestWord(words));
    }

    public String longestWord(final String[] words) {
        Arrays.sort(words);
        final Set<String> dict = new HashSet<>();
        String res = "";
        for (final String w : words) {
            if (w.length() == 1 || dict.contains(w.substring(0, w.length() - 1))) {
                if (w.length() > res.length()) {
                    res = w;
                }
                dict.add(w);
            }
        }
        return res;
    }
}
