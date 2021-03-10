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
public class _19_RemoveNthNodeFromEndofList02 {
    //One pass algorithm

    /**
     * Time complexity : O(L)
     * The algorithm makes one traversal of the list of L nodes. Therefore time complexity is O(L)
     * Space complexity : O(1)
     * We only used constant extra space.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
