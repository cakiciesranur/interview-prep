package crackingCodingInterview._02linkedLists;

import static crackingCodingInterview._02linkedLists._02_printKthToLast.getLengthofLinkedList;

/*** Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in forward order. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class _05_sumLists {
    public static void main(String[] args) {

    }

    static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {
        int length1 = getLengthofLinkedList(l1);
        int length2 = getLengthofLinkedList(l2);

        if (length1 < length2) {
            l1 = padding(l1, length2 - length1);
        } else {
            l2 = padding(l2, length1 - length2);
        }

        //TODO:
        return null;



    }

    private static LinkedListNode padding(LinkedListNode list, int padding) {
        LinkedListNode head = list;
        for (int a = 0; a < padding; a++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static LinkedListNode insertBefore(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head != null) {
            newNode.next = head;
        }
        return newNode;
    }
}
