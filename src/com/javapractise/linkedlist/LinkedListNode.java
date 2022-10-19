package com.javapractise.linkedlist;

public class LinkedListNode {
    private Integer value;
    LinkedListNode next;

    public Integer getValue(){
        return this.value;
    }
    public LinkedListNode(Integer value) {
        this.value = value;
        this.next = null;
    }
}
