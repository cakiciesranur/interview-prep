package crackingCodingInterview._02linkedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class _05_sumListsInReverseOrder {
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

    static LinkedListNode sumLists(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Integer number1 = getNumberFromLinkedList(list1);
        Integer number2 = getNumberFromLinkedList(list2);
        int total = number1 + number2;

        return convertLinkedList(total);
    }

    private static LinkedListNode convertLinkedList(int total) {
        LinkedListNode node = null;
        LinkedListNode last = node;
        String number = String.valueOf(total);
        for (int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            LinkedListNode next = new LinkedListNode(j);
            if (node == null) {
                node = next;
                last = next;
            } else {
                last.next = next;
                last = last.next;
            }
        }
        return node;
    }

    private static Integer getNumberFromLinkedList(LinkedListNode list1) {
        LinkedListNode current = list1;
        List<Integer> listOfValue = new ArrayList<>();
        while (current != null) {
            listOfValue.add(current.data);
            current = current.next;
        }
        Collections.reverse(listOfValue);

        String numberAsString = listOfValue.stream().map(i -> i.toString()).collect(Collectors.joining(""));
        return Integer.valueOf(numberAsString);
    }
}
