package com.example.algorithm.string;

/*
Every messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
*
Encryption logic: Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the
second one to the last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range
of lowercase letters a-z in ASCII. Convert the values back to letters.
*
For instance, to encrypt the word “crime”

Decrypted message:	c	r	i	m	e
Step 1:	            99	114	105	109	101
Step 2:	            100	214	319	428	529
Step 3:	            100	110	111	116	113
Encrypted message:	d	n	o	t	q
*
Write a function named decrypt(word) that receives a string that consists of small latin letters only, and returns the
decrypted word.
 */
public class DecryptMessage {

    public static void main(final String[] args) {
        final String word = "dnotq";
        System.out.println("Encrypted text - " + word);
        System.out.println("Decrypted text - " + decrypt(word));
    }

    private static String decrypt(final String word) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (i == 0) {
                c = (char)(c - 1);
                if (c < 'a') {
                    c = (char)(c + 26);
                }
                result.append(c);
            } else {
                c = (char)(c - word.charAt(i - 1));
                while (!(c >= 'a' && c <= 'z')) {
                    c = (char)(c + 26);
                }
                result.append(c);
            }
        }
        return result.toString();
    }
}
