package com.example.algorithm.recursion;

public class GenerateAllBalancedParenthesis {

    public void generateAllBalancedParenthesis(final int n) {
        final int open = n;
        final int closed = n;
        final String output = "";
        generateAllBalancedParenthesis(output, open, closed);
    }

    private void generateAllBalancedParenthesis(final String output, final int open, final int closed) {
        if (open == 0 && closed == 0) {
            System.out.println(output);
            return;
        }
        if (open > 0) {
            generateAllBalancedParenthesis(output + "(", open - 1, closed);
        }
        if (closed > 0 && closed > open) {
            generateAllBalancedParenthesis(output + ")", open, closed - 1);
        }
    }
}
