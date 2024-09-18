package com.ant.datastrucutreandalog.metwally.dataStrucutre.heap;

public class MyIntegerHeap {
    private Integer[] data;
    private int size;

    public MyIntegerHeap() {
        this.data = new Integer[20];
        this.size = 0;
    }

    public void print() {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            data.append(this.data[i] + " - ");
        }
        System.out.println(data);
    }

    public int getSize() {
        return this.size;
    }

    public void insert(Integer data) {
        int indexOfNewNode = this.size;
        this.data[indexOfNewNode] = data;
        this.size++;
        int parentIndex = (int) Math.floor((double) (indexOfNewNode - 1) / 2);
        while (indexOfNewNode != 0 && this.data[indexOfNewNode] < this.data[parentIndex]) {
            Integer temp = this.data[indexOfNewNode];
            this.data[indexOfNewNode] = this.data[parentIndex];
            this.data[parentIndex] = temp;
            indexOfNewNode = parentIndex;
            parentIndex = (int) Math.floor((double) (indexOfNewNode - 1) / 2);
        }
    }

    public Integer pop() {
        if (this.size == 0) return null;
        int parentIndex = 0;
        Integer deletedData = this.data[parentIndex];
        this.data[parentIndex] = this.data[this.size - 1];
        this.data[size - 1] = null;
        this.size--;
        int leftIndex = (2 * parentIndex) + 1;
        while (leftIndex < this.size) {
            int rightIndex = (2 * parentIndex) + 2;
            int smallestIndex = leftIndex;

            if (this.data[rightIndex] != null &&
                    this.data[rightIndex] < this.data[leftIndex]) {
                smallestIndex = rightIndex;
            }
            if (this.data[smallestIndex] >= this.data[parentIndex]) {
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
