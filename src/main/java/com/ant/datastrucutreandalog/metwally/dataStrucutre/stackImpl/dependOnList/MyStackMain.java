package com.ant.datastrucutreandalog.metwally.dataStrucutre.stackImpl.dependOnList;


public class MyStackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack(false);
        System.out.println("is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();

        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();

        System.out.println("=> pop data: " + stack.pop());
        System.out.println("=> is empty: " + stack.isEmpty() + " size: " + stack.size());
        stack.print();
    }
}
