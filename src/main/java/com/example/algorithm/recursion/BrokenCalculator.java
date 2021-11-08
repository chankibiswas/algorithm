package com.example.algorithm.recursion;

/*
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
*
Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
*
Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
*
Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
*
Input: startValue = 1024, target = 1
Output: 1023
Explanation: Use decrement operations 1023 times.
*/
public class BrokenCalculator {

    public int brokenCalc(final int startValue, final int target) {
        if (target <= startValue) {
            return startValue - target;
        }
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        } else {
            return 1 + brokenCalc(startValue, target + 1);
        }
    }
}
