package crackingCodingInterview._02linkedLists;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 */
public class _05_sumListsInReverseOrder02 {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(7);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(6);
        LinkedListNode head2 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(9);
        LinkedListNode node7 = new LinkedListNode(2);

        head1.next = node2;
        node2.next = node3;
        head2.next = node6;
        node6.next = node7;

        LinkedListNode result = sumLists(head1, head2);
        while (result != null) {
            System.out.print("-> " + result.data + " ");
            result = result.next;
        }
    }

    //with recursive
    static LinkedListNode sumLists(LinkedListNode list1, LinkedListNode list2) {
        return sumValues(list1, list2, 0);
    }

    private static LinkedListNode sumValues(LinkedListNode list1, LinkedListNode list2, int carry) {
        LinkedListNode result = new LinkedListNode();
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }
        int value = carry;

        if (list1 != null) {
            value += list1.data;
        }

        if (list2 != null) {
            value += list2.data;
        }

        carry = value >= 10 ? 1 : 0;
        result.data = value % 10;

        if (list1 != null || list2 != null) {
            result.next = sumValues(list1 != null ? list1.next : null,
                    list2 != null ? list2.next : null,
                    carry);
        }
        return result;
    }
}
