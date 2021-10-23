package com.example.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next
level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss
.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of
visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited
9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the
input. You may return the answer in any order.
*
Input: cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
*
Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class SubdomainVisitCount {

    public List<String> subdomainVisits(final String[] cpdomains) {
        final List<String> result = new ArrayList<>();
        final Map<String, Integer> wordCount = new HashMap<>();
        for (final String cpDomain : cpdomains) {
            calculateWordCount(cpDomain, wordCount);
        }

        for (final Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    private void calculateWordCount(final String cpDomain, final Map<String, Integer> wordCount) {
        final String[] domainArr = cpDomain.split(" ");
        final Integer count = Integer.valueOf(domainArr[0]);
        String domain = domainArr[1];
        int t = wordCount.getOrDefault(domain, 0);
        wordCount.put(domain, count + t);

        while (domain.indexOf(".") > 0) {
            domain = domain.substring(domain.indexOf(".") + 1);
            t = wordCount.getOrDefault(domain, 0);
            wordCount.put(domain, count + t);
        }
    }
}
