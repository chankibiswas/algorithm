package com.example.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once.
*
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams1(final String[] strs) {
        final Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final String key = getKey(strs[i]);
            if (hashMap.containsKey(key)) {
                final List<String> list = hashMap.get(key);
                list.add(strs[i]);
            } else {
                final List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hashMap.put(key, temp);
            }
        }
        final List<List<String>> res = new ArrayList<>();
        for (final Map.Entry<String, List<String>> e : hashMap.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(final String[] strs) {
        final int[] prime =
            {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107};

        final HashMap<Long, List<String>> map = new HashMap<>();
        for (final String s : strs) {
            long key = 1;
            for (final char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(final String str) {
        final char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
