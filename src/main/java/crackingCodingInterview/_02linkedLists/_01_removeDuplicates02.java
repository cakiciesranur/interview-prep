package crackingCodingInterview._02linkedLists;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class _01_removeDuplicates02 {
    public static void main(String[] args) {

    }

    //This code runs in O ( 1) space, but O ( N2) time.
    static void deleteDups(LinkedListNode head) {
     LinkedListNode current= head;
     while(current!= null){
         LinkedListNode runner= current;

         while(runner.next != null){

             if (runner.next.data == current.data) {
                 runner.next= runner.next.next;
             }else{
                 runner = runner.next;
             }
         }

         current = current.next;
     }
    }
}
