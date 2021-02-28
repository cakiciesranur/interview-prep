package crackingCodingInterview._02linkedLists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
 */
public class _02_printKthToLast {
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

        System.out.println(getKthLastElement(node1, 2).data);
        System.out.println(getKthLastElement(node1, 6).data);
        System.out.println(getKthLastElement(node1, 1).data);

    }

    static LinkedListNode getKthLastElement(LinkedListNode head, int k) {
        int listCount = getLengthofLinkedList(head);
        if (listCount == 0 || k > listCount) {
            return null;
        }
        int n= listCount -k+1;
        LinkedListNode current = head;

        for (int i = 1; i < n; i++) {
            current = current.next;
        }

        return current;

    }

    public static int getLengthofLinkedList(LinkedListNode head) {
        LinkedListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


}
