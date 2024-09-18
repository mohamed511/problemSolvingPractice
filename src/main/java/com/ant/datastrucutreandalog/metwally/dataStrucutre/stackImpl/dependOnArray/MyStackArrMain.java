package com.ant.datastrucutreandalog.metwally.dataStrucutre.stackImpl.dependOnArray;

public class MyStackArrMain {
    public static void main(String[] args) {
        MyStackArr stack = new MyStackArr();
        System.out.println("is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.print();
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());


        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();

        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();

        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();

        stack.push(7);
        stack.print();
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        System.out.println("=== start loop ===");
        while (!stack.isEmpty()){
            stack.pop();
            System.out.println(" => is empty: " + stack.isEmpty() + " size: " + stack.size());
            stack.print();
            System.out.println("peek: "+stack.peek());
        }
        System.out.println("peek: "+stack.peek());
        System.out.println("pop: "+stack.pop());
    }
}
