package com.allenanker.chapter6;

public class KthNodeInBST {
    private int k;
    /**
     * Find the kth smallest node in a given binary search tree.
     *
     * @param root
     * @param k
     * @return
     */
    public TreeNode getKthNodeInBST(TreeNode root, int k) {
        this.k = k;
        if (root == null || k < 1) {
            throw new IllegalArgumentException("Invalid argument(s)");
        }

       return getKthNodeCore(root);
    }

    private TreeNode getKthNodeCore(TreeNode root) {
        TreeNode target = null;
        if (root.left != null) {
            target = getKthNodeCore(root.left);
        }
        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }
        if (target == null && root.right != null) {
            target = getKthNodeCore(root.right);
        }

        return target;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        System.out.print(root.val + "->");
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new KthNodeInBST().getKthNodeInBST(root, 4).val);
        new KthNodeInBST().inOrderTraversal(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
