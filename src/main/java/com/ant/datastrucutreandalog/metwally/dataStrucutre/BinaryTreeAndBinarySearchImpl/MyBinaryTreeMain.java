package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

public class MyBinaryTreeMain<Data> {
    public static void main(String[] args) {
//        MyBinaryTree<String> tree = new MyBinaryTree<>();
//        tree.insert("A");
//        tree.insert("B");
//        tree.insert("C");
//        tree.insert("D");
//        tree.insert("E");
//        tree.insert("F");
//        tree.insert("G");
//        tree.insert("H");
//        tree.insert("I");
//        tree.print();

//        MyBinaryTreePrint test = new MyBinaryTreePrint();
//        test.insert("A");
//        test.insert("B");
//        test.insert("C");
//        test.insert("D");
//        test.insert("E");
//        test.insert("F");
//        test.insert("G");
//        test.insert("H");
//        test.insert("I");
//        test.printNode();

//        MyBinaryTreePrint test = new MyBinaryTreePrint();
//        test.insert(1);
//        test.insert(2);
//        test.insert(3);
//        test.insert(4);
//        test.insert(5);
//        test.insert(6);
//        test.insert(7);
//        test.insert(8);
//        test.insert(9);
//        test.print();
//        System.out.println();
//        test.printNode();

//        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
//        binarySearch.binarySearchInsert(1);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(3);
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(6);
//        binarySearch.print();
//        System.out.println();
//        binarySearch.printNode();

//        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
//        binarySearch.binarySearchInsert(1);
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(3);
//        binarySearch.binarySearchInsert(6);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.print();
//        System.out.println();
//        binarySearch.printNode();

//        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
//        binarySearch.binarySearchInsert(6);
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(8);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(7);
//        binarySearch.binarySearchInsert(9);
//        binarySearch.print();
//        System.out.println();
//        binarySearch.printNode();
//        System.out.println(binarySearch.binarySearchIsExist(9));
//
//        MyBinaryTree.NodeAndParent t = binarySearch.binarySearchFindNodeAndParent(2);
//        System.out.println(t.isLeft);
//        System.out.println(t.parent.getData());
//        System.out.println(t.node.getData());

//        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(1);
//        binarySearch.binarySearchInsert(3);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(6);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(6);
//        binarySearch.printNode();

//        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(6);
//        binarySearch.binarySearchInsert(7);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(1);
//        binarySearch.binarySearchInsert(3);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(4);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(6);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(3);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(5);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(7);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(2);
//        binarySearch.printNode();
//        System.out.println("============");
//        binarySearch.binarySearchDeleteNode(1);
//        binarySearch.printNode();
//        binarySearch.binarySearchDeleteNode(1);
//        binarySearch.printNode();

        MyBinaryTreePrint<Integer> binarySearch = new MyBinaryTreePrint<>();
        binarySearch.binarySearchInsert(1);
        binarySearch.binarySearchInsert(2);
        binarySearch.binarySearchInsert(3);
        binarySearch.binarySearchInsert(4);
        binarySearch.binarySearchInsert(5);
        binarySearch.binarySearchInsert(6);
        binarySearch.binarySearchInsert(7);
        binarySearch.printNode();
        binarySearch.balance();
        binarySearch.printNode();
    }
}
