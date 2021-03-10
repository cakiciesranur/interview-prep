package leetcode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass?
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class _19_RemoveNthNodeFromEndofList {
    //twoPass algorithm

    /**
     * Time complexity : O(L)
     * The algorithm makes two traversal of the list, first to calculate list length LL and second to find the (L - n) th node.
     * There are 2L-n operations and time complexity is O(L)
     * Space complexity : O(1).
     * We only used constant extra space.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = head;
        int size = 0;
        while (first != null) {
            first = first.next;
            size++;
        }

        int index = size - n;
        first = dummy;
        while (index > 0) {
            index--;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
