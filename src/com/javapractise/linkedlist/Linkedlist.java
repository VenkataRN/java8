package com.javapractise.linkedlist;

public class Linkedlist {
    public static LinkedListNode head = null;

    public boolean insertNode(Integer value) {
        System.out.println("-------------------------------------");
        LinkedListNode newNode = new LinkedListNode(value);
        if (head == null) {
            head = newNode;
            return true;
        }
        if (head != null) {
            LinkedListNode llnode;
            for (llnode = head; llnode.next != null; llnode = llnode.next) {
                System.out.println(llnode.getValue());
            }
            llnode.next = newNode;
            return true;
        }

        return false;
    }

    //Can be enhanced
    public boolean deleteNode(LinkedListNode linkedListNode) {
        return true;
    }

    public void listNodes() {
        LinkedListNode llnode = head;
        while (llnode != null) {
            System.out.println("listNodes1: " + llnode.getValue());
            llnode = llnode.next;
        }
    }
}
