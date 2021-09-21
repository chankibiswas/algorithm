package com.example.algorithm.slidingWindow;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase
English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
*
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(final String[] s) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(final String s, final int k) {
        int result = 0;
        int i = 0;
        int maxFrequency = 0;
        final int[] arr = new int[26];
        for (int j = 0; j < s.length(); j++) {
            final int index = s.charAt(j) - 'A';
            arr[index]++;
            maxFrequency = Math.max(maxFrequency, arr[index]);
            while (j - i + 1 - maxFrequency > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
