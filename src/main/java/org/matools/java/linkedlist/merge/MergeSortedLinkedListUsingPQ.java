package org.matools.java.linkedlist.merge;

import org.matools.java.linkedlist.ListNode;

import java.util.PriorityQueue;

public class MergeSortedLinkedListUsingPQ {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {

            ListNode smallest = minHeap.poll();

            current.next = smallest;
            current = current.next;

            // Add next node from same list
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
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

        ListNode list1 = ListNode.createList(new int[]{1, 4, 5});
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});
        ListNode list3 = ListNode.createList(new int[]{2, 6});

        ListNode[] lists = {list1, list2, list3};

        MergeSortedLinkedListUsingPQ solution = new MergeSortedLinkedListUsingPQ();

        ListNode mergedList = solution.mergeKLists(lists);

        System.out.println("Merged Sorted Linked List:");

        printList(mergedList);
    }
}