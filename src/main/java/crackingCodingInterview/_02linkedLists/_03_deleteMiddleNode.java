package crackingCodingInterview._02linkedLists;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 */
public class _03_deleteMiddleNode {
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

        deleteMiddleNode(node1);
        while (node1 != null) {
            System.out.print("-> " + node1.data + " ");
            node1 = node1.next;
        }
    }


    static void deleteMiddleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode previous = null;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (previous != null) {
            previous.next = slow.next;
        }
    }
}
