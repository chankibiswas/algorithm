package com.example.algorithm.list;

public class SwapPairsInList {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = null;
        if (head != null && head.next != null) {
            head = swap(head, head.next);
            temp = head.next;
        }
        while (temp != null && temp.next != null && temp.next.next != null) {
            temp.next = swap(temp.next, temp.next.next);
            temp = temp.next.next;
        }
        return head;
    }

    private ListNode swap(final ListNode first, final ListNode second) {
        final ListNode temp = first;
        first.next = second.next;
        second.next = temp;
        return second;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
