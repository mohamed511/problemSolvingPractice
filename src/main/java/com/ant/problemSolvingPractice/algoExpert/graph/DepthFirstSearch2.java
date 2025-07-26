package com.ant.problemSolvingPractice.algoExpert.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch2 {

    static class Node {
        String name;
        boolean isVisited;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            depthFirstSearch(this, array);
            return array;
        }

        public void depthFirstSearch(Node current, List<String> array) {
            current.isVisited = true;
            array.add(current.name);
            List<Node> child = current.children;
            for (Node v : child) {
                if (!v.isVisited) {
                    depthFirstSearch(v, array);
                }
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
