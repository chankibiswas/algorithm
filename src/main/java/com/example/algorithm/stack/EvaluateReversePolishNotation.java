package com.example.algorithm.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a
result, and there will not be any division by zero operation.
*
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
*
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(final String[] tokens) {
        final Stack<Integer> stack = new Stack();
        final Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (final String token : tokens) {
            if (operators.contains(token)) {
                final int j = stack.pop();
                final int i = stack.pop();
                stack.push(eval(i, j, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(final int i, final int j, final String operator) {
        if (operator.equals("+")) {
            return i + j;
        } else if (operator.equals("-")) {
            return i - j;
        } else if (operator.equals("*")) {
            return i * j;
        } else if (operator.equals("/")) {
            return i / j;
        }
        return 0;
    }
}
