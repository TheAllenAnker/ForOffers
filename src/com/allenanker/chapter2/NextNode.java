package com.allenanker.chapter2;

public class NextNode {
    public static Node nextNode(Node<Character> root, Node<Character> target) {
        if (root == null || (root.right == null && root.left == null) || target == null) {
            return null;
        }

        if (target.right != null) {
            Node<Character> curr = target.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else {
            if (target == target.parent.left) {
                return target.parent;
            } else {
                Node curr = target.parent;
                while (curr.parent != null && curr.parent.left != curr) {
                    curr = curr.parent;
                }
                return curr.parent;
            }
        }
    }

    private static Node<Character> generateTree() {
        Node<Character> head = new Node<>('a');
        Node<Character> b = new Node<>('b');
        Node<Character> c = new Node<>('c');
        Node<Character> d = new Node<>('d');
        Node<Character> e = new Node<>('e');
        Node<Character> h = new Node<>('h');
        Node<Character> i = new Node<>('i');
        Node<Character> f = new Node<>('f');
        Node<Character> g = new Node<>('g');
        head.left = b;
        head.right = c;
        b.parent = head;
        c.parent = head;
        b.left = d;
        b.right = e;
        d.parent = b;
        e.parent = b;
        e.left = h;
        e.right = i;
        h.parent = e;
        i.parent = e;
        c.left = f;
        c.right = g;
        f.parent = c;
        g.parent = c;

        return head;
    }

    public static void main(String[] args) {
        Node<Character> head = generateTree();
        System.out.println(nextNode(head, head).val);
        System.out.println(nextNode(head, head.left.left).val);
        System.out.println(nextNode(head, head.left.right.right).val);
        System.out.println(nextNode(head, head.right.right).val); // this should throw NullPointerException
    }
}

class Node<T> {
    T val;
    Node<T> parent;
    Node<T> left;
    Node<T> right;

    public Node() {
    }

    public Node(T val) {
        this.val = val;
    }
}
