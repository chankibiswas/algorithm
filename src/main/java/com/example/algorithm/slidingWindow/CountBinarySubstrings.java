package com.example.algorithm.slidingWindow;

/*
Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the
0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.
*
Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011",
 and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
*
Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(final String s) {
        int i = 1;
        int previous = 0;
        int current = 1;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count += Math.min(previous, current);
                previous = current;
                current = 1;
            } else {
                current++;
            }
            i++;
        }
        return count + Math.min(previous, current);
    }
}
