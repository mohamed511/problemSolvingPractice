package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

public class MyTreeNode<Data> {
    private Data data;
    private MyTreeNode<Data> left;
    private MyTreeNode<Data> right;

    public MyTreeNode(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public MyTreeNode<Data> getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode<Data> left) {
        this.left = left;
    }

    public MyTreeNode<Data> getRight() {
        return right;
    }

    public void setRight(MyTreeNode<Data> right) {
        this.right = right;
    }


}
