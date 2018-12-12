package com.allenanker.chapter3;

public class DeleteNodeInList {
    /**
     * Delete a node in a linked list in O(1) time complexity
     *
     * @param head        head of the linked list
     * @param toBeDeleted the node to be deleted
     */
    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        if (toBeDeleted.next != null) {
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
            toBeDeleted.next = null;
        } else if (toBeDeleted == head) {
            // this does not actually delete the head, it doesn't work
            head = null;
        } else {
            ListNode curr = head;
            while (curr.next != toBeDeleted) {
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        deleteNode(head, node3);
        System.out.println(head);
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}