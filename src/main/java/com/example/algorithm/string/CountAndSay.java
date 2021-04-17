package com.example.algorithm.string;

public class CountAndSay {

    /*
    Count and say goes as a sequence that starts with 1 (where n=1)
    n=1, O/P - 1
    If n=2, One 1, i.e., O/P - 11
    If n=3, Two 1, i.e., O/P - 21
    If n=4, One 2 One 1, i.e., O/P - 1211
    If n=5, One 1 One 2 Two 1, i.e., O/P - 111221
    and so on
     */
    public String countAndSay(final int n) {
        StringBuilder ref = new StringBuilder("1");
        if (n < 1) {
            return "";
        } else if (n == 1) {
            return ref.toString();
        }
        for (int i = 1; i < n; i++) {
            final StringBuilder newStr = new StringBuilder();
            int count = 1;
            for (int j = 0; j < ref.length(); j++) {
                if (j < ref.length() - 1 && ref.charAt(j) == ref.charAt(j + 1)) {
                    count++;
                } else {
                    newStr.append(count).append(ref.charAt(j));
                    count = 1;
                }
            }
            ref = newStr;
        }
        return ref.toString();
    }
}
