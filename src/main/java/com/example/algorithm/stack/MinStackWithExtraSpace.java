package com.example.algorithm.stack;

import java.util.Stack;

/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an
additional operation getMin() which should return minimum element from the SpecialStack.
All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data
structure and no other data structure like arrays, list, .. etc.
 */
public class MinStackWithExtraSpace {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> secondaryStack = new Stack<>();

    public static void main(final String[] s) {
        final MinStackWithExtraSpace m = new MinStackWithExtraSpace();
        m.push(10);
        m.push(18);
        m.push(21);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.peek());
        m.push(2);
        System.out.println(m.getMin());
    }

    private int peek() {
        return stack.peek();
    }

    private void pop() {
        if (secondaryStack.peek() == stack.peek()) {
            secondaryStack.pop();
        }
        stack.pop();
    }

    private int getMin() {
        return secondaryStack.peek();
    }

    private void push(final int i) {
        stack.push(i);
        if (secondaryStack.isEmpty() || secondaryStack.peek() >= i) {
            secondaryStack.push(i);
        }
    }

}
