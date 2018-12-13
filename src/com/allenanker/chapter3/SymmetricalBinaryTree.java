package com.allenanker.chapter3;

public class SymmetricalBinaryTree {
    public static <T> boolean isSymmetrical(TreeNode<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid parameter head");
        }

        return isSymmetrical(head, head);
    }

    private static <T> boolean isSymmetrical(TreeNode<T> head1, TreeNode<T> head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        if (head1.val != head2.val) {
            return false;
        }
        return isSymmetrical(head1.left, head2.right) && isSymmetrical(head1.right, head2.left);
    }

    public static void main(String[] args) {
        TreeNode<Integer> head = new TreeNode<>(8);
        head.left = new TreeNode<>(6);
        head.right = new TreeNode<>(6);
        head.left.left = new TreeNode<>(5);
        head.left.right = new TreeNode<>(7);
        head.right.left = new TreeNode<>(7);
        head.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(head));
        System.out.println(isSymmetrical(head.left));
    }
}