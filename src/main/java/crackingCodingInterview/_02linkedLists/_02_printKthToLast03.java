package crackingCodingInterview._02linkedLists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
 */
public class _02_printKthToLast03 {
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
        System.out.println(getKthLastElement(node1, 3).data);

    }

    //Each of these recursive solutions takes 0( n) space due to the recursive calls.
    static LinkedListNode getKthLastElement(LinkedListNode head, int k) {
        Index index = new Index();
        return getKthLastElement(head, k, index);

    }

    private static LinkedListNode getKthLastElement(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = getKthLastElement(head.next, k, index);
        index.value++;

        if (index.value == k) {
            return head;
        }

        return node;
    }

}

class Index {
    public int value = 0;
}