package com.example.algorithm.linkedList;

/*
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
*
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 */
public class ReorderList {

    public static void main(final String[] s) {
        final ListNode l5 = new ListNode(5, null);
        final ListNode l4 = new ListNode(4, l5);
        final ListNode l3 = new ListNode(3, l4);
        final ListNode l2 = new ListNode(2, l3);
        final ListNode l1 = new ListNode(1, l2);

        reorderList(l1);
    }

    // First break the list in 2 halves
    // Reverse the second half
    // Merge the 2 halves
    public static void reorderList(final ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        final ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;

        final ListNode l2 = ReverseLinkedList.reverseList(slow);

        mergeLists(l1, l2);
    }

    private static void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            final ListNode l1Next = l1.next;
            final ListNode l2Next = l2.next;

            l1.next = l2;
            if (l1Next == null) {
                break;
            }
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
