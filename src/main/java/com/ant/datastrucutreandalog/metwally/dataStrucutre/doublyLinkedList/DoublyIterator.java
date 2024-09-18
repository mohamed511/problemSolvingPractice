package com.ant.datastrucutreandalog.metwally.dataStrucutre.doublyLinkedList;

public class DoublyIterator {
    private DoublyNode current;

    public DoublyIterator(DoublyNode current) {
        this.current = current;
    }

    public int data(){
        return this.current.getData();
    }

    public DoublyIterator next(){
        this.current = this.current.getNext();
        return this;
    }

    public DoublyNode current(){
        return this.current;
    }
}
