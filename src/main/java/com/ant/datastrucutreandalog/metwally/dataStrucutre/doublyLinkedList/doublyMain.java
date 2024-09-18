package com.ant.datastrucutreandalog.metwally.dataStrucutre.doublyLinkedList;

public class doublyMain {
    public static void main(String[] args) {
        DoublyLinkedList doubly = new DoublyLinkedList();
        doubly.insertLast(1);
        doubly.insertLast(2);
        doubly.insertLast(3);
        doubly.printList();

        System.out.println("===> insertAfter");
        doubly.insertAfter(doubly.findByData(2),99);
        doubly.printList();
        doubly.insertAfter(doubly.findByData(3),100);
        doubly.printList();
        doubly.insertAfter(doubly.findByData(1),88);
        doubly.printList();

        System.out.println("===> insertBefore");
        doubly.insertBefore(doubly.findByData(1),77);
        doubly.printList();
        doubly.insertBefore(doubly.findByData(99),66);
        doubly.printList();
        doubly.insertBefore(doubly.findByData(100),55);
        doubly.printList();

        System.out.println("===> start delete");
        doubly.deleteNode(100);
        doubly.printList();
        doubly.deleteNode(1);
        doubly.printList();
        doubly.deleteNode(2);
        doubly.printList();
        doubly.deleteNode(99);
        doubly.printList();
    }
}
