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
                                 final List<Integer> combinationList, final Set<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(combinationList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i == index || candidates[i] != candidates[i - 1]) {
                combinationList.add(candidates[i]);
                combinationSum2(candidates, i + 1, target - candidates[i], combinationList, result);
                combinationList.remove(combinationList.size() - 1);
            }
        }
    }
}
