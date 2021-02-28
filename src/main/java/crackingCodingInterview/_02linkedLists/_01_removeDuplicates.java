package crackingCodingInterview._02linkedLists;

import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class _01_removeDuplicates {
    public static void main(String[] args) {

    }

    //solution takes O(N) time, where N is the number of elements in the linked list.
    static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
                break;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
