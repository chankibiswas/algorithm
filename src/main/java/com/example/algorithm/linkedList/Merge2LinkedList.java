package com.example.algorithm.linkedList;

public class Merge2LinkedList {

    public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        final ListNode dummy = new ListNode(0);
        ListNode dummy1 = new ListNode(0, l1);
        ListNode dummy2 = new ListNode(0, l2);
        boolean firstAssignment = false;
        while (dummy1.next != null && dummy2.next != null) {
            if (dummy1.next.val <= dummy2.next.val) {
                if (!firstAssignment) {
                    dummy.next = dummy1.next;
                    firstAssignment = true;
                }
                dummy1 = dummy1.next;
            } else {
                final ListNode temp = new ListNode(dummy2.next.val, dummy1.next);
                dummy1.next = temp;
                if (!firstAssignment) {
                    dummy.next = temp;
                    firstAssignment = true;
                }
                dummy2 = dummy2.next;
            }
        }
        while (dummy2.next != null) {
            final ListNode temp = new ListNode(dummy2.next.val, dummy1.next);
            dummy1.next = temp;
            dummy2 = dummy2.next;
            dummy1 = dummy1.next;
        }
        return dummy.next;
    }
}
