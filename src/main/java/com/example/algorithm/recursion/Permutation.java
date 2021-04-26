package com.example.algorithm.recursion;

public class Permutation {

    /*
    With any String as input, all permutations are printed with space in between.
    No leading or trailing space before first and after last characters, respectively.
    Input - ABC
    Output - ABC, A BC, AB C, A B C
     */
    public void permutationWithSpacesInBetween(final String input, final String output) {
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
    public void permutationWithCaseChange(final String input, final String output) {
        if (input.length() == 0) {
            System.out.println(output + input);
            return;
        }
        final String ip = "" + input.charAt(0);
        permutationWithCaseChange(input.substring(1), output + ip.toUpperCase());
        permutationWithCaseChange(input.substring(1), output + ip.toLowerCase());
    }

    /*
    Permutation in String with case change in characters. It also allows digits and special characters
    Input - a1B
    Output - A1B, A1b, a1B, a1b
    *
    Input - A&b
    Output - A&B, A&b, a&B, a&b
     */
    public void permutationInAnyInputWithCaseChange(final String input, final String output) {
        if (input.length() == 0) {
            System.out.println(output + input);
            return;
        }
        final String ip = "" + input.charAt(0);
        if (ip.toLowerCase() == ip.toUpperCase()) {
            permutationInAnyInputWithCaseChange(input.substring(1), output + ip);
        } else {
            permutationInAnyInputWithCaseChange(input.substring(1), output + ip.toUpperCase());
            permutationInAnyInputWithCaseChange(input.substring(1), output + ip.toLowerCase());
        }
    }
}
