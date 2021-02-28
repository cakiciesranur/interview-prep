package crackingCodingInterview._02linkedLists;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class _04_partition {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(5);
        LinkedListNode node3 = new LinkedListNode(8);
        LinkedListNode node4 = new LinkedListNode(5);
        LinkedListNode node5 = new LinkedListNode(10);
        LinkedListNode node6 = new LinkedListNode(2);
        LinkedListNode node7 = new LinkedListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        LinkedListNode result = partition(node1, 5);
        while (result != null) {
            System.out.print("-> " + result.data + " ");
            result = result.next;
        }
    }

    //Time Complexity: O(N)O(N), where NN is the number of nodes in the original linked list and we iterate the original list.
    static LinkedListNode partition(LinkedListNode node, int partition) {
        if (node == null) {
            return null;
        }

        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < partition) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;


    }
}
