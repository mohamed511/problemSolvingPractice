package com.ant.datastrucutreandalog.metwally.dataStrucutre.priorityQueue;

public class MyPriorityQueue<T extends Comparable<T>> {
    private PriorityNode<T>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue() {
        this.data = new PriorityNode[10];
        this.size = 0;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i] + " - ");
        }
    }

    public boolean hasData() {
        return this.size > 0;
    }

    public void enqueue(int priority, T data) {
        int indexOfNewNode = this.size;
        this.data[indexOfNewNode] = new PriorityNode<>(priority, data);
        this.size++;
        int parentIndex = (int) Math.floor((double) (indexOfNewNode - 1) / 2);
        while (indexOfNewNode != 0 && this.data[indexOfNewNode].getPriority() < this.data[parentIndex].getPriority()) {
            PriorityNode<T> temp = this.data[indexOfNewNode];
            this.data[indexOfNewNode] = this.data[parentIndex];
            this.data[parentIndex] = temp;
            indexOfNewNode = parentIndex;
            parentIndex = (int) Math.floor((double) (indexOfNewNode - 1) / 2);
        }
    }

    public PriorityNode<T> dequeue() {
        if (this.size == 0) return null;
        int parentIndex = 0;
        PriorityNode<T> deletedData = this.data[parentIndex];
        // copy last node to root
        this.data[parentIndex] = this.data[this.size - 1];
        //delete last node
        this.data[size - 1] = null;
        this.size--;

        int leftIndex = (2 * parentIndex) + 1;
        while (leftIndex < this.size) {
            int rightIndex = (2 * parentIndex) + 2;
            int smallestIndex = leftIndex;

            if (this.data[rightIndex] != null &&
                    this.data[rightIndex].getPriority() < this.data[leftIndex].getPriority()) {
                smallestIndex = rightIndex;
            }
            if (this.data[smallestIndex].getPriority() >= this.data[parentIndex].getPriority()) {
                break;
            }

            var temp = this.data[parentIndex];
            this.data[parentIndex] = this.data[smallestIndex];
            this.data[smallestIndex] = temp;
            parentIndex = smallestIndex;
            leftIndex = (2 * parentIndex) + 1;
        }
        return deletedData;
    }


    /**
     * this code to print the data in tree
     **/
    public void draw() {
        int levelsCount = (int) (Math.log(size) / Math.log(2)) + 1;
        int lineWidth = (int) Math.pow(2, levelsCount - 1);

        int j = 0;
        for (int i = 0; i < levelsCount; i++) {
            int nodesCount = (int) Math.pow(2, i);
            int space = (int) Math.ceil((double) lineWidth - (double) nodesCount / 2);
            int spaceBetween = (int) Math.ceil((double) levelsCount / nodesCount);
            spaceBetween = spaceBetween < 1 ? 1 : spaceBetween;
            int k = j;
            StringBuilder str = new StringBuilder(" ".repeat(space + spaceBetween));
            for (; j < k + nodesCount; j++) {
                if (j == this.size) {
                    break;
                }
                if (this.data[j] != null) {
                    str.append(this.data[j]).append(" ".repeat(spaceBetween));
                }
            }
            str.append(" ".repeat(space)).append("\n");
            System.out.print(str);
        }
    }
}

class PriorityNode<T> {
    private T data;
    private int priority;

    public PriorityNode(int priority, T data) {
        this.data = data;
        this.priority = priority;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "{" + priority + " - " + data + "}";
    }
}