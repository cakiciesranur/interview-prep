package leetcode;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class _21_MergeTwoSortedLists {
    //Time complexity : O(n + m) Iteration ile
    //Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations
    // equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.
    //Space complexity : O(1)
    //The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while(l1 != null && l2!= null){
            if(l1.val<=l2.val){
                prev.next = l1;
                l1= l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev =prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
