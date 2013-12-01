package com.github.fedeoasi.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public boolean depthFirstSearch(T elem) {
        if(value.equals(elem)) {
            return true;
        }
        return (left != null && left.depthFirstSearch(elem)) ||
                (right != null && right.depthFirstSearch(elem));
    }

    public boolean breadthFirstSearch(T elem) {
        Queue<TreeNode<T>> toVisit = new LinkedList<>();
        toVisit.add(this);
        while(!toVisit.isEmpty()) {
            TreeNode<T> node = toVisit.poll();
            if(node.getValue().equals(elem)) {
                return true;
            }
            if(node.getLeft() != null) {
                toVisit.add(node.getLeft());
            }
            if(node.getRight() != null) {
                toVisit.add(node.getRight());
            }
        }
        return false;
    }

    private boolean breadthFirstSearchInternal(T elem, Queue<T> toVisit) {

        return false;
    }
}
