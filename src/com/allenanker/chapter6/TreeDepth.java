package com.allenanker.chapter6;

public class TreeDepth {
    private boolean isBalanced = false;

    public boolean isBalancedBinaryTree(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid parameter root");
        }

        isBalancedCore(root);

        return isBalanced;
    }

    public int isBalancedCore(TreeNode root) {
        if (root == null) {
            isBalanced = true;
            return 0;
        }

        int left = isBalancedCore(root.left);
        int right = isBalancedCore(root.right);
        int depth = 1 + (left > right ? left : right);
        if (Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }

        return depth;
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getSimpleBinaryTree();
        System.out.println(new TreeDepth().getTreeDepth(root));
        System.out.println(new TreeDepth().isBalancedBinaryTree(root));
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(0);
        root1.left.left = new TreeNode(0);
//        root1.right = new TreeNode(1);
        System.out.println(new TreeDepth().getTreeDepth(root1));
        System.out.println(new TreeDepth().isBalancedBinaryTree(root1));
    }
}
