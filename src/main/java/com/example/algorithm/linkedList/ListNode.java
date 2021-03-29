package com.example.algorithm.linkedList;

class ListNode {

    private final int val;
    private ListNode next;

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(final int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(final ListNode next) {
        this.next = next;
    }
}
