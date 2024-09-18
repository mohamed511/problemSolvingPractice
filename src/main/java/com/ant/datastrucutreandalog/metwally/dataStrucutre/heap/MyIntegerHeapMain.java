package com.ant.datastrucutreandalog.metwally.dataStrucutre.heap;

public class MyIntegerHeapMain {
    public static void main(String[] args) {
        MyIntegerHeap heap = new MyIntegerHeap();
        heap.insert(24);
        heap.insert(32);
        heap.insert(16);
        heap.insert(45);
        heap.insert(20);
        heap.insert(53);
        heap.insert(14);
        heap.insert(27);
        heap.print();
        heap.draw();

        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        System.out.println("pop ==================> "+heap.pop());
        heap.draw();
        heap.insert(59);
        heap.insert(48);
        heap.insert(11);
        heap.insert(25);
        heap.draw();
    }
}
