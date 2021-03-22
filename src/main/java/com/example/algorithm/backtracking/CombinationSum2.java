package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        final Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void combinationSum2(final int[] candidates, final int index, final int target,
                                 final List<Integer> oneCombination, final Set<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(oneCombination));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                oneCombination.add(candidates[i]);
                combinationSum2(candidates, i + 1, target - candidates[i], oneCombination, result);
                oneCombination.remove(oneCombination.size() - 1);
            }
        }
    }
}
