package com.ant.datastrucutreandalog.metwally.dataStrucutre.priorityQueue;

public class MyPriorityQueueMain {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.enqueue(5, 24);
        queue.enqueue(5, 32);
        queue.enqueue(3, 16);
        queue.enqueue(3, 45);
        queue.enqueue(1, 20);
        queue.enqueue(1, 53);
        queue.enqueue(2, 14);
        queue.enqueue(2, 27);
        queue.print();
        queue.draw();

        while (queue.hasData()) {
            var result = queue.dequeue();
            System.out.println("dequeue => " + result);
        }
//        queue.enqueue(59);
//        queue.enqueue(48);
//        queue.enqueue(11);
//        queue.enqueue(25);
//        queue.draw();
    }
}
