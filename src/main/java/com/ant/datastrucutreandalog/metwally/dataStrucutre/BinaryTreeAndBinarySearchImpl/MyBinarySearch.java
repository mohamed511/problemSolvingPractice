package com.ant.datastrucutreandalog.metwally.dataStrucutre.BinaryTreeAndBinarySearchImpl;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearch<Data extends Comparable<Data>> extends MyBinaryTree {
    public void binarySearchInsert(Data data) {
        MyTreeNode<Data> newNode = new MyTreeNode<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        MyTreeNode<Data> currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData().compareTo(data) > 0) { // currentNode.Data > data
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    break;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    break;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    public boolean binarySearchIsExist(Data data) {
        if (binarySearchFind(data) == null) {
            return false;
        } else {
            return true;
        }
    }

    private MyTreeNode binarySearchFind(Data data) {
        MyTreeNode<Data> currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData().compareTo(data) == 0) {
                return currentNode;
            } else if (currentNode.getRight().getData().compareTo(data) > 0) { // current is greater than data
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    public NodeAndParent<Data> binarySearchFindNodeAndParent(Data data) {
        MyTreeNode<Data> currentNode = root;
        MyTreeNode<Data> parent = null;
        NodeAndParent<Data> nodeInfo = null;
        boolean isLeft = false;
        while (currentNode != null) {
            if (currentNode.getData().compareTo(data) == 0) {
                nodeInfo = new NodeAndParent<>(currentNode, parent, isLeft);
                return nodeInfo;
            } else if (currentNode.getRight().getData().compareTo(data) > 0) { // current is greater than data
                parent = currentNode;
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                parent = currentNode;
                isLeft = false;
                currentNode = currentNode.getRight();
            }
        }
        return nodeInfo;
    }

    public void binarySearchDeleteNode(Data data) {
        NodeAndParent<Data> nodeInfo = binarySearchFindNodeAndParent(data);
        if (nodeInfo == null || nodeInfo.node == null) {
            return;
        }
        // node has both right and left node
        if (nodeInfo.node.getLeft() != null && nodeInfo.node.getRight() != null) {
            binarySearchDeleteNodeHasChilds(nodeInfo.node);
        } else if (nodeInfo.node.getLeft() != null ^ nodeInfo.node.getRight() != null) {
            binarySearchDeleteNodeHasOneChild(nodeInfo.node);
        } else {
            binarySearchDeleteNodeLeaf(nodeInfo);
        }
    }

    private void binarySearchDeleteNodeLeaf(NodeAndParent<Data> nodeAndParent) {
        if (nodeAndParent.parent == null) {
            this.root = null;
        } else {
            if (nodeAndParent.isLeft) {
                nodeAndParent.parent.setLeft(null);
            } else {
                nodeAndParent.parent.setRight(null);
            }
        }

    }

    private void binarySearchDeleteNodeHasOneChild(MyTreeNode<Data> nodeToDelete) {
        MyTreeNode<Data> nodeToReplace = null;
        if (nodeToDelete.getLeft() != null) {
            nodeToReplace = nodeToDelete.getLeft();
        } else {
            nodeToReplace = nodeToDelete.getRight();
        }
        nodeToDelete.setData(nodeToReplace.getData());
        nodeToDelete.setLeft(nodeToReplace.getLeft());
        nodeToDelete.setRight(nodeToReplace.getRight());
    }

    private void binarySearchDeleteNodeHasChilds(MyTreeNode<Data> nodeToDelete) {
        MyTreeNode<Data> currentNode = nodeToDelete.getRight();
        MyTreeNode<Data> parentForSmallestNode = null;
        // get the smallest node (always the small will be in the left)
        while (currentNode.getLeft() != null) {
            parentForSmallestNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        if (parentForSmallestNode != null) {
            parentForSmallestNode.setLeft(currentNode.getRight());
        } else {
            nodeToDelete.setRight(currentNode.getRight());
        }
        nodeToDelete.setData(currentNode.getData());
    }

    public void balance() {
        List<Data> nodeList = new ArrayList<>();
        BSInorder(this.root, nodeList);
        this.root = recursiveBalance(0, nodeList.size() - 1, nodeList);
    }

    private void BSInorder(MyTreeNode<Data> node, List<Data> nodeList) {
        if (node == null) {
            return;
        }
        BSInorder(node.getLeft(), nodeList);
        nodeList.add(node.getData());
        BSInorder(node.getRight(), nodeList);
    }

    private MyTreeNode<Data> recursiveBalance(int start, int end, List<Data> nodeList) {
        if (start > end) {
            return null;
        }
        if (nodeList == null || nodeList.isEmpty()) {
            return null;
        }
        int mid = (start + end) / 2;
        MyTreeNode<Data> newNode = new MyTreeNode<>(nodeList.get(mid));
        newNode.setLeft(recursiveBalance(start, mid - 1, nodeList));
        newNode.setRight(recursiveBalance(mid + 1, end, nodeList));
        return newNode;
    }
}

/**
 * class to find node and its parent
 **/
class NodeAndParent<Data> {
    MyTreeNode<Data> node;
    MyTreeNode<Data> parent;
    boolean isLeft;

    public NodeAndParent(MyTreeNode<Data> node, MyTreeNode<Data> parent, boolean isLeft) {
        this.node = node;
        this.parent = parent;
        this.isLeft = isLeft;
    }
}
