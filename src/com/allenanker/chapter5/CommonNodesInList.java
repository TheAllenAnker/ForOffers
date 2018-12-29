package com.allenanker.chapter5;

public class CommonNodesInList {
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            throw new IllegalArgumentException("head1 and head2 must not be null");
        }

        int length1 = 0;
        int length2 = 0;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1 != null) {
            length1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            length2++;
            curr2 = curr2.next;
        }

        curr1 = head1;
        curr2 = head2;
        while (length1 > length2) {
            curr1 = curr1.next;
            length1--;
        }
        while (length2 > length1) {
            curr2 = curr2.next;
            length2--;
        }
        while (curr1 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head2.next = new ListNode(5);
        ListNode common1 = new ListNode(6);
        common1.next = new ListNode(7);
        head1.next.next.next = common1;
        head2.next.next = common1;
        System.out.println(findFirstCommonNode(head1, head2).val);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
