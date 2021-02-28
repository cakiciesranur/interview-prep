package crackingCodingInterview._02linkedLists;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input:
 * A - > B - > C - > D - > E - > C [the same C as earlier]
 * Output:
 * C
 */
public class _08_loopDetection {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(50);
        head.next = new LinkedListNode(20);
        head.next.next = new LinkedListNode(15);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(10);

        // Create a loop for testing
        head.next.next.next.next.next = head.next.next;

        LinkedListNode result = findFirstNodeOfLoop(head);
        System.out.print("-> " + result.data + " ");

    }

    static LinkedListNode findFirstNodeOfLoop(LinkedListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}


