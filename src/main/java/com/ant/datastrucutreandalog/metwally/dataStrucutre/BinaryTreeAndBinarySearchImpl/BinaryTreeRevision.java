package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeRevisionMain {
    public static void main(String[] args) {
//        BinaryTreeRevision<Integer> tree = new BinaryTreeRevision<>();
//        tree.insert(1);
//
//        tree.insert(2);
//        tree.insert(3);
//
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//
//        tree.insert(8);
//        tree.insert(9);
//
//        tree.print();
//        System.out.println("\ngetHeight = " + tree.getHeight());
//        System.out.println("PreOder");
//        tree.preOrder();
//        System.out.println("PostOrder");
//        tree.postOrder();
//        System.out.println("inOrder");
//        tree.inOrder();

//        BinaryTreeRevision<Integer> binarySearch = new BinaryTreeRevision<>();
//        binarySearch.binarySearchInsert(1);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(3);
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(6);
//        binarySearch.print();

//        BinaryTreeRevision<Integer> binarySearch = new BinaryTreeRevision<>();
//        binarySearch.binarySearchInsert(6);
//        binarySearch.binarySearchInsert(4);
//        binarySearch.binarySearchInsert(8);
//        binarySearch.binarySearchInsert(2);
//        binarySearch.binarySearchInsert(5);
//        binarySearch.binarySearchInsert(7);
//        binarySearch.binarySearchInsert(9);
//        binarySearch.print();
//        System.out.println();
//        System.out.println(binarySearch.binarySearchIsExist(6));
//        binarySearch.inOrder();

        BinaryTreeRevision<Integer> binarySearch = new BinaryTreeRevision<>();
        binarySearch.binarySearchInsert(4);
        binarySearch.binarySearchInsert(2);
        binarySearch.binarySearchInsert(1);
        binarySearch.binarySearchInsert(3);
        binarySearch.binarySearchInsert(5);
        binarySearch.binarySearchInsert(6);
        binarySearch.print();
        System.out.println();
        System.out.println(binarySearch.binarySearchIsExist(6));
        binarySearch.binarySearchDeleteNode(2);
        binarySearch.print();
    }
}

/**
 * ========== BinaryTreeRevision ==============
 ***/
public class BinaryTreeRevision<T extends Comparable<T>> {
    private NodeRevision<T> root;

    public void print() {
        if (root == null) {
            return;
        }
        Queue<NodeRevision<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeRevision<T> currentNode = queue.poll();
            System.out.print(currentNode.data + " -> ");
            if (currentNode.leftNode != null) {
                queue.add(currentNode.leftNode);
            }
            if (currentNode.rightNode != null) {
                queue.add(currentNode.rightNode);
            }
        }
    }

    public void binarySearchInsert(T data) {
        NodeRevision<T> newNode = new NodeRevision<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        NodeRevision<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.compareTo(data) > 0) { // currentNode.Data > data
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = newNode;
                    break;
                } else {
                    currentNode = currentNode.leftNode;
                }
            } else {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = newNode;
                    break;
                } else {
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }

    public boolean binarySearchIsExist(T data) {
        if (binarySearchFind(data) == null) {
            return false;
        } else {
            return true;
        }
    }

    private NodeRevision binarySearchFind(T data) {
        NodeRevision<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.compareTo(data) == 0) {
                return currentNode;
            } else if (currentNode.data.compareTo(data) > 0) { // current is greater than data
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        return null;
    }

    public void binarySearchDeleteNode(T data) {
        NodeAndParentRevision<T> nodeInfo = binarySearchFindNodeAndParent(data);
        if (nodeInfo.node == null) {
            return;
        }
        // node has both right and left node
        if (nodeInfo.node.leftNode != null && nodeInfo.node.rightNode != null) {
            binarySearchDeleteNodeHasChild(nodeInfo.node);
        }
    }

    private void binarySearchDeleteNodeHasChild(NodeRevision<T> nodeToDelete) {
        NodeRevision<T> currentNode = nodeToDelete.rightNode;
        NodeRevision<T> parentForSmallestNode = null;
        // get the smallest node (always the small will be in the left)
        while (currentNode.leftNode != null) {
            parentForSmallestNode = currentNode;
            currentNode = currentNode.leftNode;
        }
        if(parentForSmallestNode!=null){
            parentForSmallestNode.leftNode = currentNode.rightNode;
        }else {
            nodeToDelete.rightNode = currentNode.rightNode;
        }
        nodeToDelete.data = currentNode.data;

    }

    public NodeAndParentRevision<T> binarySearchFindNodeAndParent(T data) {
        NodeRevision<T> currentNode = root;
        NodeRevision<T> parent = null;
        NodeAndParentRevision<T> nodeInfo = null;
        boolean isLeft = false;
        while (currentNode != null) {
            if (currentNode.data.compareTo(data) == 0) {
                nodeInfo = new NodeAndParentRevision<>(currentNode, parent, isLeft);
                return nodeInfo;
            } else if (currentNode.rightNode.data.compareTo(data) > 0) { // current is greater than data
                parent = currentNode;
                isLeft = true;
                currentNode = currentNode.leftNode;
            } else {
                parent = currentNode;
                isLeft = false;
                currentNode = currentNode.rightNode;
            }
        }
        return nodeInfo;
    }

    public void insert(T data) {
        NodeRevision<T> newNode = new NodeRevision<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<NodeRevision<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeRevision<T> currentNode = queue.poll();
            if (currentNode.leftNode == null) {
                currentNode.leftNode = newNode;
                break;
            } else {
                queue.add(currentNode.leftNode);
            }

            if (currentNode.rightNode == null) {
                currentNode.rightNode = newNode;
                break;
            } else {
                queue.add(currentNode.rightNode);
            }
        }
    }

    public Integer getHeight() {
        return internalHeight(root);
    }

    private Integer internalHeight(NodeRevision<T> startNode) {
        if (startNode == null) {
            return 0;
        }
        return 1 + Math.max(internalHeight(startNode.leftNode), internalHeight(startNode.rightNode));
    }

    /**
     * left -> node -> right
     */
    public void inOrder() {
        internalInOrder(root);
        System.out.println();
    }

    private void internalInOrder(NodeRevision<T> node) {
        if (node == null) {
            return;
        }
        internalInOrder(node.leftNode);
        System.out.print(node.data + " -> ");
        internalInOrder(node.rightNode);
    }

    /**
     * left -> right -> node
     */
    public void postOrder() {
        internalPostOrder(root);
        System.out.println();
    }

    private void internalPostOrder(NodeRevision<T> node) {
        if (node == null) {
            return;
        }
        internalPostOrder(node.leftNode);
        internalPostOrder(node.rightNode);
        System.out.print(node.data + " -> ");
    }

    /**
     * node -> left -> right
     */
    public void preOrder() {
        internalPreOrder(root);
        System.out.println();
    }

    private void internalPreOrder(NodeRevision<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        internalPreOrder(node.leftNode);
        internalPreOrder(node.rightNode);
    }

    // TODO: implement find method
    /**
     * find method
     */

    // TODO: implement delete method

    /**
     * delete method
     */
    public void delete(NodeRevision<T> node) {
        // find left node
        // get right node
        // find parent
        // find last right node in the tree
        // replace last right with the deleted node
    }
}

/**
 * class of node
 **/
class NodeRevision<T> {
    T data;
    NodeRevision<T> leftNode;
    NodeRevision<T> rightNode;

    public NodeRevision(T data) {
        this.data = data;
    }
}

/**
 * class to find node and its parent
 **/
class NodeAndParentRevision<Data> {
    NodeRevision<Data> node;
    NodeRevision<Data> parent;
    boolean isLeft;

    public NodeAndParentRevision(NodeRevision<Data> node, NodeRevision<Data> parent, boolean isLeft) {
        this.node = node;
        this.parent = parent;
        this.isLeft = isLeft;
    }
}
