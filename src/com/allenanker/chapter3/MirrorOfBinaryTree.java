package com.allenanker.chapter3;

public class MirrorOfBinaryTree {
    public static <T> void mirrorRecursively(TreeNode<T> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode<T> temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            mirrorRecursively(root.left);
        }
        if (root.right != null) {
            mirrorRecursively(root.right);
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
        mirrorRecursively(head);
        System.out.println();
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
