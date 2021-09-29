package com.example.algorithm.dictionary;

/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order
of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the
given words are sorted lexicographically in this alien language.
*
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
*
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
*
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than
any other character.
 */
public class VerifyingAnAlienDictionary {

    public static void main(final String[] s) {
        final String[] words = {"hello", "leetcode"};
        final String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(final String[] words, final String order) {
        final int[] orderArr = new int[26];
        for (int i = 0; i < 26; i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                final String first = words[i];
                final String second = words[j];
                final int minLength = Math.min(first.length(), second.length());
                for (int k = 0; k < minLength; k++) {
                    final int firstOrder = orderArr[first.charAt(k) - 'a'];
                    final int secondOrder = orderArr[second.charAt(k) - 'a'];
                    if (firstOrder < secondOrder) {
                        break;
                    } else if (firstOrder > secondOrder) {
                        return false;
                    } else if (k == minLength - 1 && first.length() > second.length()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
