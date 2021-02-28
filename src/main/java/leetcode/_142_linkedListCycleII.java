package leetcode;
/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 */

import crackingCodingInterview._02linkedLists.LinkedListNode;

public class _142_linkedListCycleII {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(50);
        head.setNext(new LinkedListNode(20));
        head.getNext().setNext(new LinkedListNode(15));
        head.getNext().getNext().setNext(new LinkedListNode(4));
        head.getNext().getNext().getNext().setNext(new LinkedListNode(10));

        // Create a loop for testing
        head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext());

        LinkedListNode result = detectCycle(head);
        System.out.print("-> " + result.getData() + " ");
    }

    public static LinkedListNode detectCycle(LinkedListNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return fast;
    }
}
