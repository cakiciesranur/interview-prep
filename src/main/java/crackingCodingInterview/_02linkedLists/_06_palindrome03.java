package crackingCodingInterview._02linkedLists;

import java.util.Stack;

public class _06_palindrome03 {
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

        System.out.println(isPalindromeWithStack(node1));
        LinkedListNode node = new LinkedListNode(3);
        System.out.println(isPalindromeWithStack(node));

    }

    //using stack and reverse half of linked list
    static boolean isPalindromeWithStack(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (fast != null && slow != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
