package com.example.algorithm.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private final Map<Integer, Integer> cache; // Main cache
    private final Map<Integer, Integer> frequencyCounts; // frequency count
    private final Map<Integer, LinkedHashSet<Integer>> frequencyMap; // freq map
    private final int capacity;
    private int min = -1; //least used count

    public LFUCache(final int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyCounts = new HashMap<>();
        frequencyMap = new HashMap<>();
        frequencyMap.put(1, new LinkedHashSet<>());
    }

    public int get(final int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        final int count = frequencyCounts.get(key);
        frequencyCounts.put(key, count + 1);
        frequencyMap.get(count).remove(key);

        if (count == min && frequencyMap.get(count).size() == 0) {
            min++;
        }

        if (!frequencyMap.containsKey(count + 1)) {
            frequencyMap.put(count + 1, new LinkedHashSet<>());
        }
        frequencyMap.get(count + 1).add(key);
        return cache.get(key);

    }

    public void put(final int key, final int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        if (cache.size() >= capacity) {
            final int evict = frequencyMap.get(min).iterator().next();
            cache.remove(evict);
            frequencyMap.get(min).remove(evict);
            frequencyCounts.remove(evict);
        }

        cache.put(key, value);
        frequencyCounts.put(key, 1);
        min = 1;
        frequencyMap.get(1).add(key);

    }
}
