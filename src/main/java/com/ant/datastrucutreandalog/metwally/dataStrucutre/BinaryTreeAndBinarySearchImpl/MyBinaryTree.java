package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree<Data extends Comparable<Data>> {
    protected MyTreeNode<Data> root;

    public void print() {
        Queue<MyTreeNode<Data>> queue = new LinkedList<>();
        if (this.root == null) {
            return;
        }
        queue.add(this.root);
        while (!queue.isEmpty()) {
            MyTreeNode<Data> current = queue.poll();
            System.out.print(current.getData() + " -> ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        System.out.print(" end ");
    }

    public void insert(Data data) {
        MyTreeNode<Data> newNode = new MyTreeNode<>(data);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            MyTreeNode<Data> currentNode = queue.poll();
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                break;
            } else {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                break;
            } else {
                queue.add(currentNode.getRight());
            }
        }
    }

}
