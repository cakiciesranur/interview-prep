package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumValues(l1, l2, 0);
    }

    private ListNode sumValues(ListNode list1, ListNode list2, int carry) {
        ListNode result = new ListNode();
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }
        int value = carry;

        if (list1 != null) {
            value += list1.val;
        }

        if (list2 != null) {
            value += list2.val;
        }

        carry = value >= 10 ? 1 : 0;
        result.val = value % 10;

        if (list1 != null || list2 != null) {
            result.next = sumValues(list1 != null ? list1.next : null,
                    list2 != null ? list2.next : null,
                    carry);
        }
        return result;
    }

}
