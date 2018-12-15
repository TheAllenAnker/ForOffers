package com.allenanker.chapter4;

import java.util.HashMap;

public class CopyComplexList {
    public static <T> ComplexListNode<T> copyComplexList_v2(ComplexListNode<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid parameter head");
        }

        ComplexListNode<T> curr = head;
        ComplexListNode<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = new ComplexListNode<>(curr.val);
            curr.next.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        ComplexListNode<T> newHead = new ComplexListNode<>(head.val);
        ComplexListNode<T> oldHead = new ComplexListNode<>(head.val);
        ComplexListNode<T> currNew = newHead;
        ComplexListNode<T> currOld = oldHead;
        while (curr != null) {
            currNew.next = curr.next;
            currOld.next = curr;
            curr = curr.next.next;
            currNew = currNew.next;
            currOld = currOld.next;
        }
        currOld.next = null;

        return newHead.next;
    }

    public static <T> ComplexListNode<T> copyComplexList(ComplexListNode<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("Invalid parameter head");
        }

        HashMap<ComplexListNode<T>, ComplexListNode<T>> nodesMap = new HashMap<>();
        ComplexListNode<T> curr = head;
        while (curr != null) {
            nodesMap.put(curr, new ComplexListNode<>(curr.val));
            curr = curr.next;
        }

        curr = head;
        ComplexListNode<T> newHead = new ComplexListNode<>(head.val);
        ComplexListNode<T> currNew = newHead;
        while (curr != null) {
            currNew.next = nodesMap.get(curr);
            currNew.next.random = nodesMap.get(curr.random);
            curr = curr.next;
            currNew = currNew.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ComplexListNode<Integer> head = new ComplexListNode<>(1);
        ComplexListNode<Integer> node2 = new ComplexListNode<>(2);
        ComplexListNode<Integer> node3 = new ComplexListNode<>(3);
        ComplexListNode<Integer> node4 = new ComplexListNode<>(4);
        ComplexListNode<Integer> node5 = new ComplexListNode<>(5);
        head.next = node2;
        head.random = node3;
        node2.next = node3;
        node2.random = node5;
        node3.next = node4;
        node4.next = node5;
        node4.random = node2;
        ComplexListNode<Integer> newHead = copyComplexList(head);
        ComplexListNode<Integer> newHead2 = copyComplexList_v2(head);
    }
}

class ComplexListNode<T> {
    T val;
    ComplexListNode<T> next;
    ComplexListNode<T> random;

    public ComplexListNode(T val) {
        this.val = val;
    }
}