package org.matools.java.linkedlist.merge;

public class MergeSortedLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode r = new ListNode();
        ListNode previous = r;

        while(true) {

            ListNode smallNode = null;
            int bucket = -1;
            for(int i = 0; i < lists.length; i++) {
                ListNode n = lists[i];

                if(smallNode == null && n != null) {
                    bucket = i;
                    smallNode = n;
                    continue;
                }
                if(smallNode != null && n != null && smallNode.val > n.val) {
                    smallNode = n;
                    bucket = i;
                }
            }
            if(smallNode == null || bucket == -1) {
                break;
            }

            previous.next = smallNode;
            previous = smallNode;

            lists[bucket] = smallNode.next;
            smallNode.next = null;
        }
        return r.next;
    }

    // Utility method to create linked list
    public static ListNode createList(int[] values) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});

        ListNode[] lists = {list1, list2, list3};

        MergeSortedLinkedList solution = new MergeSortedLinkedList();

        ListNode mergedList = solution.mergeKLists(lists);

        System.out.println("Merged Sorted Linked List:");

        printList(mergedList);
    }

}
