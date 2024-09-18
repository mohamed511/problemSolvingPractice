package com.ant.datastrucutreandalog.metwally.dataStrucutre.myqueueImpl.queueDependOnLink;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println("is empty: " + myQueue.hasData() + " size: " + myQueue.size());
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.print();
        System.out.println("=> peek data: " + myQueue.peek());
        System.out.println("=> dequeue data: " + myQueue.dequeue());
        System.out.println("=> is empty: " + myQueue.hasData() + " size: " + myQueue.size());
        myQueue.print();
        System.out.println("=> peek data: " + myQueue.peek());
        System.out.println("=> dequeue data: " + myQueue.dequeue());
        System.out.println("=> is empty: " + myQueue.hasData() + " size: " + myQueue.size());
        myQueue.print();

        System.out.println("=> dequeue data: " + myQueue.dequeue());
        System.out.println("=> is empty: " + myQueue.hasData() + " size: " + myQueue.size());
        myQueue.print();
        System.out.println("--------- start loop ---------------------------------------------");
        System.out.println("--------- start loop ---------------------------------------------");
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.print();
        // while (!myQueue.isEmpty())
        while (!myQueue.hasData()) {
            System.out.println("=> peek data: " + myQueue.peek());
            System.out.println("=> dequeue data: " + myQueue.dequeue());
            System.out.println("=> is empty: " + myQueue.hasData() + " size: " + myQueue.size());
            myQueue.print();
            System.out.println("===========================================================");
        }
        System.out.println("=> peek data: " + myQueue.peek());
        System.out.println("=> dequeue data: " + myQueue.dequeue());
        System.out.println("=> is empty: " + myQueue.hasData() + " size: " + myQueue.size());
        myQueue.print();
    }
}
