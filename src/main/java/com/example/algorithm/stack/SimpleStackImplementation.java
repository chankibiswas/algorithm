package com.example.algorithm.stack;

import java.util.Stack;

public class SimpleStackImplementation {

    public static void main(final String[] str) {
        final Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(5);
        System.out.println(s.pop());
        System.out.println("Current size of Stack = " + s.size());
    }

}
