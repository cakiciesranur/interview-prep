package crackingCodingInterview._02linkedLists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
 */
public class _02_printKthToLast02 {
    public static void main(String[] args) {

        LinkedListNode node1 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(10);
        LinkedListNode node4 = new LinkedListNode(9);
        LinkedListNode node5 = new LinkedListNode(25);
        LinkedListNode node6 = new LinkedListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        printKthToLast(node1, 2);
        printKthToLast(node1, 6);
        printKthToLast(node1, 1);

    }

    static int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(head.data);
        }

        return index;

    }


}
