package crackingCodingInterview._02linkedLists;

public class _05_sumListsInReverseOrder01 {
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

        LinkedListNode result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.print("-> " + result.data + " ");
            result = result.next;
        }
    }
    //with iterative
    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode result= new LinkedListNode(0);
        int carry = 0;
        LinkedListNode p = l1,  q = l2, current= result;

        while(p != null || q!=null){
            int x = (p!= null) ? p.data : 0;
            int y = (q!= null) ? q.data : 0;
            int sum = x+y+carry ;
            carry = sum/10;

            current.next= new LinkedListNode(sum%10);
            current = current.next;
            if(p!= null) p = p.next;
            if(q!= null) q = q.next;
        }

        if(carry>0){
            current.next = new LinkedListNode(carry);
        }

        return result.next;

    }
}
