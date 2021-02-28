package crackingCodingInterview._02linkedLists;

//reverse and compare
public class _06_palindrome02 {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(10);
        LinkedListNode node4 = new LinkedListNode(10);
        LinkedListNode node5 = new LinkedListNode(1);
        LinkedListNode node6 = new LinkedListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(isPalindromeWithReverse(node1));
    }

    static boolean isPalindromeWithReverse(LinkedListNode head) {
        LinkedListNode reserved = reserveLinkedListAndClone(head);
        return isEqual(head, reserved);
    }

    private static boolean isEqual(LinkedListNode l1, LinkedListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.data != l2.data) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        return l1 == null && l2 == null;
    }

    private static LinkedListNode reserveLinkedListAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode newNode = new LinkedListNode(node.data);
            newNode.next = head;
            head = newNode;
            node = node.next;
        }
        return head;
    }
}
