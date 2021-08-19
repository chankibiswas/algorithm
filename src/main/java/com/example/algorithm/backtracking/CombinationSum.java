package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        final Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);
    }

    private void combinationSum(final int[] candidates, final int index, final int target,
                                final List<Integer> list, final Set<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
