package com.example.algorithm.recursion;

public class PermutationInString {

    public static void main(final String[] s) {
        permutationInString("abc", "");
    }

    public static void permutationInString(final String input, final String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            final String newInput = input.substring(0, i) + input.substring(i + 1);
            permutationInString(newInput, output + input.charAt(i));
        }
    }
}
