package com.ant.datastrucutreandalog.metwally.dataStrucutre.linked;

public class LinkedListIterator {
    private LinkedListNode current;

    public LinkedListIterator(LinkedListNode current) {
        this.current = current;
    }

    public int data(){
        return this.current.getData();
    }

    public LinkedListIterator next(){
        this.current = this.current.getNext();
        return this;
    }

    public LinkedListNode current(){
        return this.current;
    }
}
