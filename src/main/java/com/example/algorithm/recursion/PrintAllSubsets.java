package com.example.algorithm.recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubsets {

    private final Set<String> op = new HashSet<>();

    /*
    Prints all subsets of a String input
    input - ab
    output -  , a, b, ab   -- 1st output is empty string
     */
    public void printAllSubSets(final String input, final String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        printAllSubSets(input.substring(1), output);
        printAllSubSets(input.substring(1), output + input.charAt(0));
    }

    /*
    Prints all unique subsets of a String input
    input - aaab
    i.e., when there are repeated characters
     */
    private void printAllUniqueSubSets(final String input, final String output) {
        if (input.length() == 0) {
            if (!op.contains(output)) {
                System.out.println(output);
                op.add(output);
            }
            return;
        }
        printAllUniqueSubSets(input.substring(1), output);
        printAllUniqueSubSets(input.substring(1), output + input.charAt(0));
    }
}
