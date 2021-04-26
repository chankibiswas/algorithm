package com.example.algorithm.recursion;

public class Permutation {

    /*
    With any String as input, all permutations are printed with space in between.
    No leading or trailing space before first and after last characters, respectively.
    Input - ABC
    Output - ABC, A BC, AB C, A B C
     */
    private void permutationWithSpacesInBetween(final String input, final String output) {
        if (input.length() == 1) {
            System.out.println(output + input);
            return;
        }
        permutationWithSpacesInBetween(input.substring(1), output + input.charAt(0) + " ");
        permutationWithSpacesInBetween(input.substring(1), output + input.charAt(0));
    }

    /*
    Permutation in String with case change in characters.
    Input - abc
    Output - ABC, ABc, AbC, Abc, aBC, aBc, abC, abc
     */
    private void permutationWithCaseChange(final String input, final String output) {
        if (input.length() == 0) {
            System.out.println(output + input);
            return;
        }
        final String ip = "" + input.charAt(0);
        permutationWithCaseChange(input.substring(1), output + ip.toUpperCase());
        permutationWithCaseChange(input.substring(1), output + ip.toLowerCase());
    }
}
