package crackingCodingInterview._02linkedLists;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class _06_palindrome {
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
    }

    //Time complexity: O(n)
    static boolean isPalindromeWithStack(LinkedListNode l1) {
        LinkedListNode current = l1;
        Stack<Integer> s = new Stack<>();

        while (current != null) {
            s.push(current.data);
            current = current.next;
        }

        boolean result = false;
        while (l1 != null) {
            if (l1.data == s.pop()) {
                result = true;
            } else {
                result = false;
                break;
            }
            l1 = l1.next;
        }

        return result;


    }
}
