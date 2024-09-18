package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyBinaryTreePrint<Data> extends MyBinarySearch {

    public <T extends Comparable<?>> void printNode() {
        int maxLevel = MyBinaryTreePrint.maxLevel(super.root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<MyTreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || MyBinaryTreePrint.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        MyBinaryTreePrint.printWhitespaces(firstSpaces);

        List<MyTreeNode<T>> newNodes = new ArrayList<>();
        for (MyTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            MyBinaryTreePrint.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                MyBinaryTreePrint.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    MyBinaryTreePrint.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    MyBinaryTreePrint.printWhitespaces(1);

                MyBinaryTreePrint.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    MyBinaryTreePrint.printWhitespaces(1);

                MyBinaryTreePrint.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(MyTreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(MyBinaryTreePrint.maxLevel(node.getLeft()), MyBinaryTreePrint.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }


}

