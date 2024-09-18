package com.ant.datastrucutreandalog.metwally.dataStrucutre.stackImpl.dependOnArray;

import java.util.Arrays;

public class MyStackArr {
    private int[] dataList;
    private int topIndex; // to get the data from the top
    private int initialSize; // the started size of the array
    //private int currentSize;

    public MyStackArr() {
        this.initialSize = 5;
        //this.currentSize = this.initialSize;
        this.dataList = new int[this.initialSize];
        this.topIndex = -1;
    }

    public void resizeOrNot() {
        if (this.topIndex < this.dataList.length-1) {
            return;
        }
        System.out.println("==> resize");
        int[] newArr = new int[this.dataList.length + this.initialSize];
        newArr = Arrays.copyOf(this.dataList, newArr.length);
        dataList = newArr;
    }

    public void push(int data) {
        this.resizeOrNot();
        this.dataList[++topIndex] = data;
    }

    public int peek() {
        if (topIndex == -1) {
            return -1;
        }
        return this.dataList[topIndex];
    }

    public int pop() {
        if (topIndex == -1) {
            return -1;
        }
        int head = this.dataList[topIndex];
        this.dataList[topIndex] = 0;
        topIndex--;
        return head;
    }

    public boolean isEmpty() {
        return this.topIndex < 0;
    }

    public int size() {
        return topIndex + 1;
    }

    public void print() {
        for (int i = this.topIndex; i >= 0; i--) {
            System.out.print(this.dataList[i] + " -> ");
        }
        System.out.println(" end");
    }
}
