package com.ant.datastrucutreandalog.metwally.dataStrucutre.stackImpl.dependOnList;

import com.ant.data.structure.metwally.dataStrucutre.linked.LinkedList;

public class MyStack {
    private LinkedList dataList;

    public MyStack(boolean unique) {
        this.dataList = new LinkedList(unique);
    }

    /**
     * add new data to the stack
     */
    public void push(int data) {
        this.dataList.insertFirst(data);
    }

    /**
     * returns the element that is available at the top of the stack
     * and removes that element from the stack
     */
    public int pop() {
        int popData = this.dataList.getHead().getData();
        this.dataList.deleteHead();
        return popData;
    }

    public int peek() {
        return this.dataList.getHead().getData();
    }

    public boolean isEmpty() {
        return this.dataList.getLength() <= 0;
    }

    public int size() {
        return this.dataList.getLength();
    }

    public void print() {
        this.dataList.printList();
    }

}
