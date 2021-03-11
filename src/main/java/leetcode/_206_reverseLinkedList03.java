package leetcode;

import java.util.Stack;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class _206_reverseLinkedList03 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.add(curr.val);
            curr = curr.next;
        }
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }

        return res.next;
    }
}
