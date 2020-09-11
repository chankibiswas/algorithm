package com.example.algorithm.list;

public class LinkedList {

    private static Node head;

    private static class Node {
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
        int data;
        Node next;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(int data) {
        Node n = new Node(data);
        if(null == head) {
            head = n;
        } else {
            Node temp = head;
            while(temp.next!= null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public void printLinkedList() {
        Node temp = head;
        while(temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void printLinkedList(Node n) {
        while(n!= null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public void printReverseLinkedList(Node n) {
        if(n.next!=null) {
            printReverseLinkedList(n.next);
        }
        System.out.println(n.data);
    }

    public Node reverse(Node n) {
        Node prev = null;
        Node curr = n;
        Node nxt = null;

        while(curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    public Node reverseInGroupWithGivenSize(Node n, int size) {
        Node prev = null;
        Node curr = n;
        Node nxt = null;
        int count = 0;

        while(count < size && curr!= null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }

        if(nxt != null) {
            n.next = reverseInGroupWithGivenSize(nxt, size);
        }
        return prev;
    }

    public static void main(String[] s) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(10);
        linkedList.addNode(11);
        linkedList.addNode(12);
        linkedList.addNode(13);
        linkedList.addNode(14);
        linkedList.addNode(15);
        linkedList.addNode(16);

        linkedList.printLinkedList();
        System.out.println("***********");
        linkedList.printReverseLinkedList(head);
        System.out.println("***********");
        head = linkedList.reverse(head);
        linkedList.printLinkedList();
        System.out.println("***********");
        head = linkedList.reverseInGroupWithGivenSize(linkedList.getHead(), 3);
        linkedList.printLinkedList();
    }
}