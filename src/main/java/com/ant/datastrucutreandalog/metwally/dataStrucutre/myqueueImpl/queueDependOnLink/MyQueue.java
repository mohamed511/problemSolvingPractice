package com.ant.datastrucutreandalog.metwally.dataStrucutre.myqueueImpl.queueDependOnLink;

import com.ant.datastrucutreandalog.metwally.dataStrucutre.linked.LinkedList;

public class MyQueue {
    private LinkedList dataList;

    public MyQueue() {
        this.dataList = new LinkedList(false);
    }

    public void enqueue(int data) {
        this.dataList.insertLast(data);
    }

    public Integer dequeue() {
        if(this.dataList.getHead() == null){
            return null;
        }
        int data = this.dataList.getHead().getData();
        this.dataList.deleteHead();
        return data;
    }

    public Integer peek() {
        if (this.dataList.getHead() == null) {
            return null;
        } else {
            return this.dataList.getHead().getData();
        }
    }

    public boolean hasData() {
        return this.dataList.getLength() == 0;
    }

    public int size() {
        return this.dataList.getLength();
    }

    public void print() {
        this.dataList.printList();
    }


}
