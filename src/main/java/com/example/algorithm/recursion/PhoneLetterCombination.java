package com.example.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {

    private final String[] registry = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> result = new ArrayList<>();

    /*
    Given a string containing digits from 2-9 inclusive, this program returns all possible letter combinations that the number could represent
    The combination of letters are returned in any order, in list 'result'
    *
    Registry of digits to corresponding letters is present in Registry array.
    It is same as found in any mobile phone
     */
    public List<String> letterCombinations(final String digits) {
        if (digits.length() > 0) {
            letterCombinations(digits, "", 0);
        }
        return result;
    }

    private void letterCombinations(final String digits, final String output, final int index) {
        if (digits.length() == index) {
            result.add(output);
            return;
        }
        final char c = digits.charAt(index);
        final String teleLetters = registry[c - '0'];
        for (int i = 0; i < teleLetters.length(); i++) {
            letterCombinations(digits, output + teleLetters.charAt(i), index + 1);
        }
    }
}
