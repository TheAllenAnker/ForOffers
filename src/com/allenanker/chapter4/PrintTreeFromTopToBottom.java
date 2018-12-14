package com.allenanker.chapter4;

import java.util.LinkedList;

public class PrintTreeFromTopToBottom {
    /**
     * Print a binary tree from top to bottom.
     */
    public static <T> void printTree(TreeNode<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid parameter head: head of the binary tree cannot be null");
        }

        LinkedList<TreeNode<T>> nodes = new LinkedList<>();
        nodes.push(head);
        while (!nodes.isEmpty()) {
            TreeNode<T> curr = nodes.pop();
            System.out.println(curr.val + ", ");
            if (curr.left != null) {
                nodes.offer(curr.left);
            }
            if (curr.right != null) {
                nodes.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> head = new TreeNode<>(8);
        head.left = new TreeNode<>(6);
        head.right = new TreeNode<>(10);
        head.left.left = new TreeNode<>(5);
        head.left.right = new TreeNode<>(7);
        head.right.left = new TreeNode<>(9);
        head.right.right = new TreeNode<>(11);
        printTree(head);
    }
}

class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }
}