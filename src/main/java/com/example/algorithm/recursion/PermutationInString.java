package com.example.algorithm.recursion;

public class PermutationInString {

    /*
    Normal Case where all characters are to be used find all possible permutations
    Input - ABC
    Output - ABC, ACB, BAC, BCA, CAB, CBA
     */
    public void permutationInString(String input, final int index) {
        if (index == input.length() - 1) {
            System.out.println(input);
            return;
        }
        for (int i = index; i < input.length(); i++) {
            input = swap(input, index, i);
            permutationInString(input, index + 1);
        }
    }

    private String swap(final String input, final int a, final int b) {
        final char[] chars = input.toCharArray();
        final char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
        return String.valueOf(chars);
    }
}
