package com.example.algorithm.cache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheByLinkedHashMap {

    private final int CAPACITY;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCacheByLinkedHashMap(final int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

            protected boolean removeEldestEntry(final Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public static void main(final String[] args) {
        final LRUCacheByLinkedHashMap cache = new LRUCacheByLinkedHashMap(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        cache.put(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2));
        cache.put(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));

    }

    public int get(final int key) {
        System.out.println("Going to get the value for the key : " + key);
        return map.getOrDefault(key, -1);
    }

    public void put(final int key, final int value) {
        System.out.println("Going to put the (key, value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }
}

