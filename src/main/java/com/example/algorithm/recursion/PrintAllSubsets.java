package com.example.algorithm.recursion;

public class PrintAllSubsets {

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
}
