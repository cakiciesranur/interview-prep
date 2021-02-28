package crackingCodingInterview._02linkedLists;

import java.util.Stack;

public class _05_sumLists02 {
    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(6);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(7);
        LinkedListNode head2 = new LinkedListNode(2);
        LinkedListNode node6 = new LinkedListNode(9);
        LinkedListNode node7 = new LinkedListNode(5);

        head1.next = node2;
        node2.next = node3;
        head2.next = node6;
        node6.next = node7;

        LinkedListNode result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.print("-> " + result.data + " ");
            result = result.next;
        }
    }

    //with Stack
    static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        Stack<Integer> s1 = listToStack(l1);
        Stack<Integer> s2 = listToStack(l2);

        LinkedListNode head = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            LinkedListNode newNode = new LinkedListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
        }

        return head;
    }


    private static Stack<Integer> listToStack(LinkedListNode l1) {
        LinkedListNode current = l1;
        Stack<Integer> s = new Stack<>();

        while (current != null) {
            s.push(current.data);
            current = current.next;
        }
        return s;
    }
}
