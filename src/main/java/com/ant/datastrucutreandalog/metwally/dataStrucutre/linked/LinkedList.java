package com.ant.datastrucutreandalog.metwally.dataStrucutre.linked;

public class LinkedList {
    private LinkedListNode head;
    private LinkedListNode tail;
    private final boolean unique;
    private int length;

    public LinkedList(boolean unique) {
        this.unique = unique;
    }

    public LinkedListNode getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    private LinkedListIterator begin() {
        return new LinkedListIterator(head);
    }

    public void printList() {
        for (LinkedListIterator it = begin(); it.current() != null; it.next()) {
            System.out.print(it.data());
            System.out.print(" -> ");
        }
        System.out.println("end");
    }

    private LinkedListNode findParent(LinkedListNode data) {
        for (LinkedListIterator it = begin(); it.current() != null; it.next()) {
            if (it.current().getNext() == data) {
                return it.current();
            }
        }
        return null;
    }

    public LinkedListNode findByData(int data) {
        for (LinkedListIterator it = begin(); it.current() != null; it.next()) {
            if (data == it.data()) {
                return it.current();
            }
        }
        return null;
    }

    public boolean isExist(int data) {
        if (this.findByData(data) != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canInsert(int data) {
        if (this.isExist(data) && unique) {
            return false;
        } else {
            return true;
        }
    }

    public void insertLast(int data) {
        if (!this.canInsert(data)) {
            System.out.println(" this data already exist: " + data);
            return;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        this.length++;
    }

    public void insertAfter(LinkedListNode after, int data) {
        if (!this.canInsert(data)) {
            System.out.println(" this data already exist: " + data);
            return;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.setNext(after.getNext());
        after.setNext(newNode);
        if (this.tail == after) {
            tail = newNode;
        }
        this.length++;
    }

    public void insertBefore(LinkedListNode before, int data) {
        if (!this.canInsert(data)) {
            System.out.println(" this data already exist: " + data);
            return;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.setNext(before);
        LinkedListNode parent = findParent(before);
        if (parent == null) {
            head = newNode;
        } else {
            parent.setNext(newNode);
        }
        this.length++;
    }

    public void deleteNode(int data) {
        LinkedListNode node = this.findByData(data);
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else if (this.head == node) {
            this.head = node.getNext();
        } else {
            LinkedListNode parentNode = this.findParent(node);
            if (parentNode != null) {
                if (this.tail == node) {
                    parentNode.setNext(null);
                    this.tail = parentNode;
                } else {
                    parentNode.setNext(node.getNext());
                }
            }
        }
        this.length--;
    }

    /**
     * this method used to use in the stack implementation
     */
    public void insertFirst(int data) {
        if (!this.canInsert(data)) {
            System.out.println(" this data already exist: " + data);
            return;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.length++;
    }

    public void deleteHead() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.getNext();
        this.length--;
    }
}
