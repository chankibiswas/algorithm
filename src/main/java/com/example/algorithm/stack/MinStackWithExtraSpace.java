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
    private final Stack<Integer> minStack = new Stack<>();

    public static void main(final String[] s) {
        final MinStackWithExtraSpace m = new MinStackWithExtraSpace();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }

    public void push(final int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }

}
