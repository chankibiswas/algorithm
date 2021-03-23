package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(final int k, final int n) {
        final Set<List<Integer>> result = new HashSet<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void combinationSum3(final int k, final int n, final int index,
                                 final List<Integer> oneCombo, final Set<List<Integer>> result) {
        if (oneCombo.size() > k) {
            return;
        }
        if (n == 0) {
            if (oneCombo.size() == k) {
                result.add(new ArrayList<>(oneCombo));
            }
            return;
        } else if (n < 0) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (i > n) {
                return;
            }
            oneCombo.add(i);
            combinationSum3(k, n - i, i + 1, oneCombo, result);
            oneCombo.remove(oneCombo.size() - 1);
        }
    }
}
