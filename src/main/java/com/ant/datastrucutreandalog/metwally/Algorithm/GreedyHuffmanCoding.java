package com.ant.datastrucutreandalog.metwally.Algorithm;

import java.util.*;

public class GreedyHuffmanCoding {
    public static void main(String[] args) {
        String message = "internet";
        Huffman huffman = new Huffman(message);
        for (Map.Entry<Character, String> c : huffman.codes.entrySet()) {
            System.out.println(c.getKey() + " " + c.getValue());
        }
    }
}

class HeapNode implements Comparable<HeapNode> {
    private Character data;
    private int freq;
    private HeapNode right;
    private HeapNode left;

    public HeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public Character getData() {
        return data;
    }

    public int getFreq() {
        return freq;
    }

    public HeapNode getRight() {
        return right;
    }

    public void setRight(HeapNode right) {
        this.right = right;
    }

    public HeapNode getLeft() {
        return left;
    }

    public void setLeft(HeapNode left) {
        this.left = left;
    }

    @Override
    public int compareTo(HeapNode o) {
        return Integer.compare(this.freq, o.freq);
    }

    @Override
    public String toString() {
        return "{" + data + "-" + freq + "}" + " => ";
    }
}

class Huffman {
    Character INTERNAL_CHARACTER = 0;
    private PriorityQueue<HeapNode> nodesQueue;
    Map<Character, String> codes;

    public Huffman(String message) {
        codes = new HashMap();
        // get frequencies for every character in the message
        Map<Character, Integer> characterFreq = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            char current = message.charAt(i);
            characterFreq.put(current, characterFreq.getOrDefault(current, 0) + 1);
        }
        // copy map in priority queue
        nodesQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> item : characterFreq.entrySet()) {
            char key = item.getKey();
            int value = item.getValue();
            HeapNode newNode = new HeapNode(key, value);
            nodesQueue.add(newNode);
        }
        System.out.println("===> map");
        System.out.println(characterFreq);
        System.out.println("===> queue");
        System.out.println(nodesQueue);

        // create the tree
        HeapNode top, left, right;
        int newFreq;
        while (nodesQueue.size() != 1) {
            // get first smallest nodes
            left = nodesQueue.poll();
            right = nodesQueue.poll();
            // calculate the freq for the new node
            newFreq = left.getFreq() + right.getFreq();
            // create new node and add the left and right node
            // and the freq
            top = new HeapNode(INTERNAL_CHARACTER, newFreq);
            top.setRight(right);
            top.setLeft(left);
            // add the new node in the queue
            nodesQueue.add(top);
        }
        System.out.println("===> queue second");
        System.out.println();
        print(nodesQueue);
        // generates the code
        this.generateCode(this.nodesQueue.peek(), "");
        System.out.println("===> codes");
        System.out.println(codes);
    }

    private void generateCode(HeapNode node, String str) {
        if (node == null) {
            return;
        }
        if (!node.getData().equals(INTERNAL_CHARACTER)) {
            codes.put(node.getData(), str);
        }

        generateCode(node.getLeft(), str + "0");
        generateCode(node.getRight(), str + "1");

    }

    private void print(PriorityQueue<HeapNode> nodesQueue) {
        HeapNode root = nodesQueue.peek();
        Queue<HeapNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            HeapNode current = queue.poll();
            System.out.print(current);
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        System.out.println("==============");
    }
}