package com.ant.datastrucutreandalog.metwally.dataStrucutre.doublyLinkedList;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    private DoublyIterator begin() {
        return new DoublyIterator(head);
    }

    void printList() {
        for (DoublyIterator it = begin(); it.current() != null; it.next()) {
            System.out.print(it.data());
            System.out.print(" -> ");
        }
        System.out.println("end");
    }

    public DoublyNode findByData(int data) {
        for (DoublyIterator d = begin(); d.current() != null; d.next()) {
            if (data == d.data()) {
                return d.current();
            }
        }
        return null;
    }

    public void insertAfter(DoublyNode after, int data) {
        DoublyNode newNode = new DoublyNode(data);
        newNode.setNext(after.getNext());
        newNode.setBack(after);
        after.setNext(newNode);
        if (newNode.getNext() == null) {
            this.tail = newNode;
        } else {
            newNode.getNext().setBack(newNode);
        }
    }

    public void insertLast(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            newNode.setBack(this.tail);
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
    }

    public void insertBefore(DoublyNode before, int data) {
        DoublyNode newNode = new DoublyNode(data);
        newNode.setNext(before);
        if (this.head == before) {
            this.head = newNode;
        } else {
            before.getBack().setNext(newNode);
        }
        before.setBack(newNode);
    }

    public void deleteNode(int data) {
        DoublyNode deletedNode = this.findByData(data);
        if (deletedNode == this.tail && deletedNode == this.head) {
            this.head = null;
            this.tail = null;
        } else if (deletedNode == this.head) {
            deletedNode.getNext().setBack(null);
            this.head = deletedNode.getNext();
        } else if (deletedNode == this.tail) {
            deletedNode.getBack().setNext(null);
            this.tail = deletedNode.getBack();
        } else {
            deletedNode.getBack().setNext(deletedNode.getNext());
            deletedNode.getNext().setBack(deletedNode.getBack());
        }
        deletedNode.setNext(null);
        deletedNode.setBack(null);
    }
}
