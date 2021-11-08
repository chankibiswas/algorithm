package com.example.algorithm.string;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(final String[] st) {
        final String s = "y#fo##f";
        final String t = "y#f#o##f";
        System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
    }

    public boolean backspaceCompare(final String s, final String t) {
        final Stack<Character> sStack = getStack(s);
        final Stack<Character> tStack = getStack(t);

        while (!sStack.isEmpty()) {
            final char c = sStack.pop();
            if (tStack.isEmpty() || c != tStack.pop()) {
                return false;
            }
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }

    private Stack<Character> getStack(final String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }
}
