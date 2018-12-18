package com.allenanker.chapter4;

public class SerializeBinaryTree {
    private static int index = -1;

    /**
     * Use '$' to represent null, and two '#'s to surround each node on both sides
     *
     * @param root the root of the binary tree
     * @param <T>  assumed to be integer here
     * @return
     */
    public static <T> String serializeTree(TreeNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid null ptr root");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append("#");
        if (root.left != null) {
            stringBuilder.append(serializeTree(root.left));
        } else {
            stringBuilder.append("$#");
        }
        if (root.right != null) {
            stringBuilder.append(serializeTree(root.right));
        } else {
            stringBuilder.append("$#");
        }
        return stringBuilder.toString();
    }

    public static TreeNode<Integer> deserializeTree(String serializedString) {
        if (serializedString == null || serializedString.length() == 0) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        String[] nodeValues = serializedString.split("#");
        return deserializeTreeCore(nodeValues);
    }

    private static TreeNode<Integer> deserializeTreeCore(String[] nodes) {
        ++index;
        TreeNode<Integer> root = null;
        if (!nodes[index].equals("$")) {
            root = new TreeNode<>(Integer.parseInt(nodes[index]));
            root.left = deserializeTreeCore(nodes);
            root.right = deserializeTreeCore(nodes);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.generateBST();
        String str = serializeTree(root);
        TreeNode<Integer> newRoot = deserializeTree(str);
        System.out.println();
    }
}
