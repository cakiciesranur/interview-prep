package leetcode;

import crackingCodingInterview._02linkedLists.LinkedListNode;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false
 */
public class _141_linkedListCycle {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(50);
        head.setNext(new LinkedListNode(20));
        head.getNext().setNext(new LinkedListNode(15));
        head.getNext().getNext().setNext(new LinkedListNode(4));
        head.getNext().getNext().getNext().setNext(new LinkedListNode(10));

        // Create a loop for testing
        head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext());

        boolean result = hasCycle(head);
        System.out.print(result);
    }

    static boolean hasCycle(LinkedListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
