package com.example.algorithm.decode;

import java.util.ArrayList;
import java.util.List;

/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
decoded back to the original list of strings.

Machine 1 (sender) has the function:
string encode(List<string> strs) { // ... your code return encoded_string; }
Machine 2 (receiver) has the function:
List<string> decode(string s) { //... your code return strs; }
So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
List<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.
 */
public class EncodeDecodeProblem {

    private static final char DELIMITER = '#';

    public static void main(final String[] s) {
        final List<String> input = new ArrayList<>();
        input.add("Leet");
        input.add("Code");
        input.add("Bad#$%Input");
        final String encode = encode(input);
        final List<String> decode = decode(encode);
        decode.forEach(System.out::println);
    }

    // Encodes a list of strings to a single string.
    /*
    The trick here is to append the strings in such a way so that they can be identified in the say way while decoding.
    If try to use delimiters, there is a chance that those might be present in String and it will cause issue while
    decoding.
    So the trick here is to also maintain a count of length along with delimiters.
    String length + Delimiter + String
     */
    public static String encode(final List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (final String s : strs) {
            sb.append(s.length()).append(DELIMITER).append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(final String s) {
        final List<String> result = new ArrayList<>();
        final int length = s.length();
        int i = 0;
        int count = 0;
        while (i < length) {
            // For more than 1 digit count
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (s.charAt(i) == DELIMITER) {
                i++;
                result.add(s.substring(i, i + count));
            }
            i+=count;
            count = 0;
        }
        return result;
    }
}
/*
4#leet
 */
