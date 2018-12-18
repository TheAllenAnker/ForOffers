package com.allenanker.chapter4;

public class TreeUtil {
    public static TreeNode<Integer> generateBST() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(14);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(8);
        root.right.left = new TreeNode<>(12);
        root.right.right = new TreeNode<>(16);
        return root;
    }
}
