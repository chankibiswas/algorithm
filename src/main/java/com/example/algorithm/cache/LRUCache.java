package com.example.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache
. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
 */
public class LRUCache {

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> map;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public static void main(final String[] s) {
        final LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));
        cache.put(3, 30);
        System.out.println(cache.get(2));
        cache.put(4, 40);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public int get(final int key) {
        final Node node = map.get(key);
        if (node != null) {
            remove(node);
            add(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(final int key, final int value) {
        final Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.previous.key);
                remove(tail.previous);
            }
            final Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }

    private void add(final Node node) {
        final Node headNext = head.next;
        node.next = headNext;
        headNext.previous = node;
        head.next = node;
        node.previous = head;
    }

    private void remove(final Node node) {
        final Node next = node.next;
        final Node previous = node.previous;

        next.previous = previous;
        previous.next = next;
    }

    private static class Node {

        int key;
        int value;
        Node previous;
        Node next;

        Node(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }
}
