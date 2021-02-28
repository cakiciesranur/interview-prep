package crackingCodingInterview._02linkedLists;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class _07_intersection {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(7);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(6);
        LinkedListNode node4 = new LinkedListNode(9);
        LinkedListNode node5 = new LinkedListNode(2);
        LinkedListNode head2 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(9);
        LinkedListNode node7 = new LinkedListNode(2);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        head2.next = node6;
        node6.next = node7;

        LinkedListNode result = getIntersection(head1, head2);
        while (result != null) {
            System.out.print("-> " + result.data + " ");
            result = result.next;
        }
    }

    //This algorithm takes O(A + B) time, where A and Bare the lengths of the two linked lists.
    // It takes O( 1) additional space.
    static LinkedListNode getIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            return null;
        }


        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;

    }

    private static LinkedListNode getKthNode(LinkedListNode node, int k) {
        LinkedListNode current = node;

        while (k > 0 && current.next != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static Result getTailAndSize(LinkedListNode node) {
        if (node == null) {
            return null;
        }
        LinkedListNode current = node;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(size, current);
    }
}

class Result {
    int size;
    LinkedListNode tail;

    public Result(int size, LinkedListNode tail) {
        this.size = size;
        this.tail = tail;
    }
}