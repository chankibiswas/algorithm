package com.example.algorithm.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique
words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more
words have the same count, they should be sorted according to their order in the original sentence. Assume that all
letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and
“perfect” should be considered the same word.
*
The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
 */
public class WordCountEngine {

    public static void main(final String[] st) {
        final String[][] strings = wordCountEngine(
            "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; "
            + "and every man is a quotation from all his ancestors. ");
        System.out.println(strings.length);
    }

    private static String[][] wordCountEngine(final String document) {
        final Map<String, Integer> wordCount = new HashMap<>();
        final Map<String, Integer> wordPosition = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0, j = 0; j < document.length() && i < document.length(); j++) {
            if (document.charAt(j) == ' ') {
                final String w = word.toString().toLowerCase();
                if (wordCount.containsKey(w)) {
                    final int count = wordCount.get(w);
                    wordCount.put(w, count + 1);
                } else {
                    wordCount.put(w, 1);
                    wordPosition.put(w, i);
                }
                i = j + 1;
                word = new StringBuilder();
            } else if ((document.charAt(j) >= 'a' && document.charAt(j) <= 'z') || (document.charAt(j) >= 'A'
                                                                                    && document.charAt(j) <= 'Z')) {
                word.append(document.charAt(j));
            }
        }
        if (word.length() > 0) {
            final String w = word.toString().toLowerCase();
            if (wordCount.containsKey(w)) {
                final int count = wordCount.get(w);
                wordCount.put(w, count + 1);
            } else {
                wordCount.put(w, 1);
                wordPosition.put(w, document.length() - w.length());
            }
        }

        final TreeSet<WordNode> wordCountTreeSet = fillWordCount(wordCount, wordPosition);

        final String[][] res = new String[wordCountTreeSet.size()][2];
        int i = 0;
        for (final WordNode w : wordCountTreeSet) {
            res[i][0] = w.word;
            res[i][1] = String.valueOf(w.count);
            i++;
        }
        wordCountTreeSet.forEach(System.out::println);
        return res;
    }

    private static TreeSet<WordNode> fillWordCount(final Map<String, Integer> wordCount,
                                                   final Map<String, Integer> wordPosition) {
        final TreeSet<WordNode> t = new TreeSet<>((w1, w2) -> {
            if (w1.count == w2.count) {
                return w1.position - w2.position;
            }
            // For decreasing order
            return w2.count - w1.count;
        });
        for (final Map.Entry<String, Integer> e : wordCount.entrySet()) {
            t.add(new WordNode(e.getKey(), e.getValue(), wordPosition.get(e.getKey())));
        }
        return t;
    }

    private static class WordNode {

        private final int position;
        private final int count;
        private final String word;

        private WordNode(final String word, final int count, final int position) {
            this.position = position;
            this.count = count;
            this.word = word;
        }

        @Override
        public String toString() {
            return word + " : " + count + " : " + position;
        }
    }
}
