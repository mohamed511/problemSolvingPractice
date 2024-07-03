package com.ant.problemSolvingPractice.algoExpert.linkedList;

public class RemoveDuplicationFromLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        while (linkedList.next!=null){
            if(linkedList.value == linkedList.next.value){
                linkedList.next = linkedList.next.next;
            }
        }
        return null;
    }
}
