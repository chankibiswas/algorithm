package com.example.algorithm.topologySort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new
language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes
before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller
if and only if s.length < t.length.
*
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
*
Input: words = ["z","x"]
Output: "zx"
*
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {

    public static void main(final String[] s) {
        final String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        //final String[] words = {"ac", "ab", "zc", "zb"};
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(final String[] words) {
        final Map<Character, Integer> indegree = new HashMap();
        final Map<Character, Set<Character>> map = new HashMap();

        for (final String word : words) {
            for (final char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            final String first = words[i];
            final String second = words[i + 1];
            final int minSize = Math.min(first.length(), second.length());
            for (int j = 0; j < minSize; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    if (map.containsKey(first.charAt(j))) {
                        final Set<Character> set = map.get(first.charAt(j));
                        if (!set.contains(second.charAt(j))) {
                            set.add(second.charAt(j));
                            map.put(first.charAt(j), set);
                            indegree.put(second.charAt(j), indegree.get(second.charAt(j)) + 1);
                        }
                    } else {
                        final Set<Character> set = new HashSet();
                        set.add(second.charAt(j));
                        map.put(first.charAt(j), set);
                        indegree.put(second.charAt(j), indegree.get(second.charAt(j)) + 1);
                    }
                    break;
                } else if (j == minSize - 1 && first.length() > second.length()) {
                    return "";
                }
            }
        }

        final LinkedList<Character> q = new LinkedList();
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.addLast(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            final char c = q.removeFirst();
            sb.append(c);
            if (map.containsKey(c)) {
                final Set<Character> set = map.get(c);
                for (final char next : set) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) {
                        q.addLast(next);
                    }
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        } else {
            return sb.toString();
        }
    }
}
