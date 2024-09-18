package com.ant.datastrucutreandalog.metwally.dataStrucutre.doublyLinkedList;

public class DoublyNode {
    private int data;
    private DoublyNode next;
    private DoublyNode back;

    public DoublyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getBack() {
        return back;
    }

    public void setBack(DoublyNode back) {
        this.back = back;
    }
}
