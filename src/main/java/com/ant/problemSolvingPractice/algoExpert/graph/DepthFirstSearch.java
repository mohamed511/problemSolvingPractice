package com.ant.problemSolvingPractice.algoExpert.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        List<String> result = graph.dfs(new ArrayList<>());
        System.out.println(result);
        String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};

    }
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> dfs(List<String> array) {
            // Write your code here.
            array.add(this.name);
            for (int i = 0; i < children.size() ; i++) {
                children.get(i).dfs(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
