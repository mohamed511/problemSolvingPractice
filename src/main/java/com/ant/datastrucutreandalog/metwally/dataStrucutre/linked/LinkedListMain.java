package com.ant.datastrucutreandalog.metwally.dataStrucutre.linked;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(false);
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.printList();

        linkedList.insertAfter(linkedList.findByData(2),99);
        linkedList.printList();
        linkedList.insertAfter(linkedList.findByData(3),100);
        linkedList.printList();
        linkedList.insertAfter(linkedList.findByData(1),88);
        linkedList.printList();

        linkedList.insertBefore(linkedList.findByData(1),77);
        linkedList.printList();
        linkedList.insertBefore(linkedList.findByData(99),66);
        linkedList.printList();
        linkedList.insertBefore(linkedList.findByData(100),55);
        linkedList.printList();

        linkedList.deleteNode(77);
        linkedList.printList();
        linkedList.deleteNode(100);
        linkedList.printList();
        linkedList.deleteNode(3);
        linkedList.printList();
        linkedList.insertLast(1);
        linkedList.insertLast(1);
        linkedList.printList();

        System.out.println("=== testCanExist ===");
        LinkedList testCanExist = new LinkedList(true);
        testCanExist.insertLast(1);
        testCanExist.insertLast(1);
        testCanExist.insertLast(2);
        testCanExist.insertLast(3);
        testCanExist.insertLast(3);
        testCanExist.printList();
        System.out.println(testCanExist.isExist(1));

    }
}
