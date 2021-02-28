package examples;

import crackingCodingInterview._02linkedLists.LinkedListNode;

/**
 * Reverse singly linked list
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(10);
        LinkedListNode node4 = new LinkedListNode(9);
        LinkedListNode node5 = new LinkedListNode(25);
        LinkedListNode node6 = new LinkedListNode(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        LinkedListNode reversed = reverse(node1);
        while (reversed != null) {
            System.out.print("-> " + reversed.getData() + " ");
            reversed = reversed.getNext();
        }
    }

    static LinkedListNode reverse(LinkedListNode node) {
        if (node == null) {
            return null;
        }

        LinkedListNode previous = null;
        LinkedListNode current = node;
        while (current != null) {
            LinkedListNode temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }

        return previous;
    }
}