package org.matools.java.linkedlist.merge;

import org.matools.java.linkedlist.ListNode;

public class MergeSortedLinkedList {

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

    public static void main(String[] args) {

        ListNode list1 = ListNode.createList(new int[]{1, 4, 5});
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});
        ListNode list3 = ListNode.createList(new int[]{2, 6});

        ListNode[] lists = {list1, list2, list3};

        MergeSortedLinkedList solution = new MergeSortedLinkedList();

        ListNode mergedList = solution.mergeKLists(lists);

        System.out.println("Merged Sorted Linked List:");

        ListNode.printList(mergedList);
    }

}
