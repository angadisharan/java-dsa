package org.matools.java.linkedlist.merge;


import org.matools.java.linkedlist.ListNode;

public class MergeSortedTwoLinkedList {

    public static void main(String[] args) {

        ListNode list1 = ListNode.createList(new int[]{1, 3, 5});
        ListNode list2 = ListNode.createList(new int[]{2, 4, 6});

        Solution solution = new Solution();

        ListNode result =
                solution.mergeTwoLists(list1, list2);

        ListNode.printList(result);
    }
}

class Solution {

    public ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2
    ) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Remaining nodes
        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}