package com.allenanker.chapter4;

public class ConvertBST {
    /**
     * Convert the given binary search tree into a doubly linked list.
     *
     * @param root root of the given BST
     * @param <T>
     * @return head of the result linked list
     */
    public static <T> TreeNode<T> convert(TreeNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid null pointer root");
        }

        convertNode(root, null);
        TreeNode<T> currLeft = root;
        while (currLeft.left != null) {
            currLeft = currLeft.left;
        }

        return currLeft;
    }

    private static <T> TreeNode<T> convertNode(TreeNode<T> curr, TreeNode<T> lastNode) {
        // in-order traversal and linking
        if (curr.left != null) {
            lastNode = convertNode(curr.left, lastNode);
        }
        // found the left most node in current sub-tree
        curr.left = lastNode;
        if (lastNode != null) {
            lastNode.right = curr;
        }
        lastNode = curr;
        if (curr.right != null) {
            lastNode = convertNode(curr.right, lastNode);
        }

        return lastNode;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(14);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(8);
        root.right.left = new TreeNode<>(12);
        root.right.right = new TreeNode<>(16);
        root = convert(root);
        System.out.println();
    }
}
