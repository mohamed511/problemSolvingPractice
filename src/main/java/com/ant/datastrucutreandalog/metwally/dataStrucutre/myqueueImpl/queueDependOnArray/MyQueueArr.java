package com.ant.datastrucutreandalog.metwally.dataStrucutre.myqueueImpl.queueDependOnArray;

public class MyQueueArr {
    private Integer[] dataList;
    private int front;
    private int back;

    public MyQueueArr() {
        this.dataList = new Integer[5];
        this.front = 0;
        this.back = 0;
    }

    public void resize() {
        if (this.size() == this.dataList.length - 1) {
            System.out.println("=========> resize");
            Integer[] newArr = new Integer[this.dataList.length * 2];
            int itemSize = this.size();
            System.arraycopy(this.dataList, this.front, newArr, 0, this.dataList.length - 1);
            System.arraycopy(this.dataList, 0, newArr, this.dataList.length - this.front, back);
            this.dataList = newArr;
            this.back = itemSize;
            this.front = 0;
        }
    }

    public void enqueue(int data) {
        resize();
        this.dataList[back] = data;
        if (back < this.dataList.length - 1) {
            this.back++;
        } else {
            this.back = 0;
        }
    }

    public Integer dequeue() {
        if (size() > 0) {
            Integer deletedItem = this.dataList[front];
            this.dataList[front] = null;
            front++;
            if (size() == 0) {
                front = 0;
                back = 0;
            } else if (front == dataList.length) {
                front = 0;
            }
            return deletedItem;
        } else {
            return null;
        }
    }

    public Integer peek() {
        if (size() == 0) {
            System.out.println("== no data ==");
            return null;
        }
        return this.dataList[front];
    }

    public Boolean hasData() {
        return this.size() != 0;
    }

    public Integer size() {
        if (this.front > this.back) {
            return this.back - this.front + this.dataList.length;
        } else {
            return this.back - this.front;
        }
    }

    public void print() {
        if (size() > 0) {
            if (front <= back) {
                for (int i = front; i < back; i++) {
                    System.out.print("index: " + i + " val: " + dataList[i] + " => ");
                }
                System.out.println(" end ");
            } else {
                for (int i = front; i < dataList.length; i++) {
                    System.out.print("index: " + i + " val: " + dataList[i] + " => ");
                }
                for (int i = 0; i < back; i++) {
                    System.out.print("index: " + i + " val: " + dataList[i] + " => ");
                }
                System.out.println(" end ");
            }
        } else {
            System.out.println("======= NO DATA TO PRINT ======");
        }

    }


}
